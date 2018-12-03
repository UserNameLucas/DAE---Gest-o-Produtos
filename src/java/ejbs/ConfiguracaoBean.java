/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejbs;

import entities.Cliente;
import entities.Configuracao;
import entities.Estado;
import entities.Modulo;
import exceptions.EntityAlreadyExistsException;
import exceptions.EntityDoesNotExistsException;
import javax.ejb.EJBException;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author RS
 */
@Stateless
public class ConfiguracaoBean extends BaseBean<Configuracao>{
    
    @PersistenceContext
    private EntityManager em;
    
    public void create(int codigo, String descricao, Estado estado, String nomeSoftware, int versaoBase, Modulo modulos, String usernameCliente) 
            throws EntityAlreadyExistsException, EntityDoesNotExistsException{
        try {
            if (em.find(Configuracao.class, codigo) != null) {
                throw new EntityAlreadyExistsException("A configuração com esse codigo já existe!");
            }
            Cliente c = em.find(Cliente.class, usernameCliente);
            if(c == null){
                throw new EntityDoesNotExistsException("O Cliente com este id não existe!");
            }
        
        Configuracao configuracao = new Configuracao(codigo, descricao, estado, nomeSoftware, versaoBase, modulos, c);
        em.persist(configuracao);
        
        } catch (EntityAlreadyExistsException e) {
            throw e;
        } 
    }
}