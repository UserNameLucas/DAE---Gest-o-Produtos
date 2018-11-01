/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejbs;

import entities.Configuracao;
import entities.Estado;
import entities.Modulo;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author RS
 */
@Stateless
public class SoftConfigBean extends BaseBean<Configuracao>{
    
    @PersistenceContext
    private EntityManager em;
    
    public void create(s){
        Configuracao configuracao = new Configuracao(descricao, estado, nomeSoftware, versaoBase, modulos);
        em.persist(configuracao);
    }
}