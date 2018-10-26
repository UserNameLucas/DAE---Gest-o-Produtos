package ejbs;

import java.io.Serializable;
import java.lang.annotation.Annotation;
import java.lang.reflect.ParameterizedType;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;
import javax.persistence.EntityManager;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.PersistenceContext;
import javax.validation.constraints.NotNull;

public abstract class BaseBean<T extends Serializable> {
        
    @PersistenceContext
    protected EntityManager em;
    
    private Class<T> getGenericEntityClass() {
        // 1. Get the generic type passed as argument (some T that is a Serializable)
        ParameterizedType genericType = (ParameterizedType) this.getClass().getGenericSuperclass();
        
        // 2. return the cast of T Type to T Class
        return (Class<T>) genericType.getActualTypeArguments()[0];
    }
    
    private <A extends Annotation> Stream<A> getAnnotations(Class<T> tClass, Class<A> aClass) {
        return Arrays.stream(tClass.getAnnotationsByType(aClass));
    }
    
    private Stream<NamedQuery> getNamedQueriesForEntity(Class<T> entityClass) {
        // 3. Get the @NamedQuery annotations of T
        Stream<NamedQuery> nq = getAnnotations(entityClass, NamedQuery.class);
        
        // 4. check also for @NamedQueries annotations.
        Stream<NamedQuery> nq2 = getAnnotations(entityClass, NamedQueries.class).map(NamedQueries::value).flatMap(Arrays::stream);
        
        return Stream.concat(nq, nq2);
    }
   
    public boolean containsNamedQuery(Class<T> entityClass, String namedQuery) {
        Stream<NamedQuery> namedQueries = getNamedQueriesForEntity(entityClass);
        return namedQueries.map(NamedQuery::name).anyMatch(namedQuery::equals);
    }
    
    public List<T> getAll() {
        Class<T> entityClass = getGenericEntityClass();
        
        // 5. Compute the default query given the simple class name of T
        String genericClassName = entityClass.getSimpleName();
        String namedQuery = "getAll" + genericClassName + "s";
       
        // 6. If that NamedQuery is present in Entity, then we should use the default behaviour to getAll<GenericEntity>
        if (containsNamedQuery(entityClass, namedQuery)) {
            // With this, we ensure we respect, for instance, the business logic or simply the query order, for example.
            return em.createNamedQuery(namedQuery, entityClass).getResultList();
        }
        
        // 7. In case the default named query wasn't found or isn't set,
        // we assume the default app behaviour, query all from the generic Entity.
        String queryAll = String.format("SELECT entity FROM %s entity", genericClassName);
        return em.createQuery(queryAll, entityClass).getResultList();
    }
    
    public T remove(@NotNull Object primaryKey) {
        T entity = em.find(getGenericEntityClass(), primaryKey);
        
        if (entity == null) {
            // throw new EJBException(); Model not found!
        }
        
        em.remove(entity);
        
        return entity;
    }
}