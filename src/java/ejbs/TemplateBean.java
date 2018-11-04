/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejbs;

import entities.Configuracao;
import entities.Template;
import exceptions.EntityAlreadyExistsException;
import exceptions.EntityDoesNotExistsException;
import javax.ejb.EJBException;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;



/**
 *
 * @author Lucas
 */
@Stateless
public class TemplateBean extends BaseBean<Template>{
    @PersistenceContext
    private EntityManager em;
    
    public void create(int codigo, String name, int codigoConfiguracao)
            throws EntityAlreadyExistsException, EntityDoesNotExistsException{
        try {
            if (em.find(Template.class, name) != null) {
                throw new EntityAlreadyExistsException("O utilizador com este username já existe!");
            }
            Configuracao c = em.find(Configuracao.class, codigoConfiguracao);
            if(c == null){
                throw new EntityDoesNotExistsException("A configuracão não existe.");
            }
            
            Template t = new Template(codigo,name, c);
            em.persist(t);
        } catch (EntityAlreadyExistsException e) {
            throw e;
        } catch (Exception e) {
            throw new EJBException(e.getMessage());
        }
    }
}
