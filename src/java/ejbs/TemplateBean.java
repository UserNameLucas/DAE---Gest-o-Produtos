/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejbs;

import entities.Configuracao;
import entities.Template;
import exceptions.EntityAlreadyExistsException;
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
    
    public void create(String name, Configuracao configuracao)
            throws EntityAlreadyExistsException{
        try {
            if (em.find(Template.class, name) != null) {
                throw new EntityAlreadyExistsException("O utilizador com este username já existe!");
            }
            Template t = new Template(name, configuracao);
            em.persist(t);
        } catch (EntityAlreadyExistsException e) {
            throw e;
        } catch (Exception e) {
            throw new EJBException(e.getMessage());
        }
    }
}
