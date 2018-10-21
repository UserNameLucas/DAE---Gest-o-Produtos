/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejbs;

import entities.Cliente;
import entities.User;
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
public class ClienteBean {
    
    @PersistenceContext
    private EntityManager em;
    
    public void create(String morada, String pessoaContacto, String name,String username, String password, String email)
            throws EntityAlreadyExistsException{
        try {
            if (em.find(User.class, username) != null) {
                throw new EntityAlreadyExistsException("O utilizador com este username já existe!");
            }
            Cliente cliente = new Cliente(morada, pessoaContacto, name, username, password, email);
            em.persist(cliente);
        } catch (EntityAlreadyExistsException e) {
            throw e;
        } catch (Exception e) {
            throw new EJBException(e.getMessage());
        }
    }
    
}
