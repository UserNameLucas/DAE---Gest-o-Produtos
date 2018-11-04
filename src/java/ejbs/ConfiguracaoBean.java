/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejbs;

import entities.Configuracao;
import entities.Estado;
import entities.Modulo;
import exceptions.EntityAlreadyExistsException;
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
    
    public void create(int id, String descricao, Estado estado, String nomeSoftware, int versaoBase, Modulo modulos) throws EntityAlreadyExistsException{
        try {
            if (em.find(Configuracao.class, id) != null) {
                throw new EntityAlreadyExistsException("O software com este id já existe!");
            }
        
        Configuracao configuracao = new Configuracao(id, descricao, estado, nomeSoftware, versaoBase, modulos);
        em.persist(configuracao);
        
        } catch (EntityAlreadyExistsException e) {
            throw e;
        } 
    }
}