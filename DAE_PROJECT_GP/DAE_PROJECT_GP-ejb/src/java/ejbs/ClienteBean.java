/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejbs;

import entities.Cliente;
import entities.User;
import exceptions.EntityAlreadyExistsException;
import exceptions.EntityDoesNotExistsException;
import exceptions.MyConstraintViolationException;
import exceptions.Utils;
import javax.ejb.EJBException;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.validation.ConstraintViolationException;


/**
 *
 * @author Lucas
 */
@Stateless
public class ClienteBean extends BaseBean<Cliente>{
    
    @PersistenceContext
    private EntityManager em;
    
    public void create(String morada, String pessoaContacto, String name,String username, String password)
            throws EntityAlreadyExistsException{
        try {
            if (em.find(User.class, username) != null) {
                throw new EntityAlreadyExistsException("O utilizador com este username já existe!");
            }
            Cliente cliente = new Cliente(morada, pessoaContacto, name, username, password);
            em.persist(cliente);
        } catch (EntityAlreadyExistsException e) {
            throw e;
        } catch (Exception e) {
            throw new EJBException(e.getMessage());
        }
    }
    
    public void update(String username, String name, String morada, String pessoaContacto) 
            throws EntityDoesNotExistsException, MyConstraintViolationException {
        try {
            Cliente c = em.find(Cliente.class, username);
            if (c == null) {
                throw new EntityDoesNotExistsException("Não existe nenhum cliente com esse username!");
            }
            c.setName(name);
            c.setMorada(morada);
            c.setPessoaContacto(pessoaContacto);
            em.merge(c);
        } catch (EntityDoesNotExistsException e) {
            throw e;
        } catch (ConstraintViolationException e) {
            throw new MyConstraintViolationException(Utils.getConstraintViolationMessages(e));
        /*} catch (Exception e) {
            throw new EJBException(e.getMessage());*/
        }
    }

    
}
