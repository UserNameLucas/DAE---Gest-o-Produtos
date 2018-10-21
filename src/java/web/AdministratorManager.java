/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package web;

import ejbs.AdministradorBean;
import ejbs.ClienteBean;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author Lucas
 */
@ManagedBean
@SessionScoped
public class AdministratorManager {
    @EJB
    private ClienteBean cb;
    @EJB
    private AdministradorBean ab;

    public AdministratorManager() {
    }

   
    
    
}
