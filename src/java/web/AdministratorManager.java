/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package web;

import ejbs.AdministradorBean;
import ejbs.ClienteBean;
import entities.Administrador;
import entities.Cliente;
import exceptions.EntityAlreadyExistsException;
import java.util.List;

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
    
    private String name;
    private String morada;
    private String pessoaContacto;
    private String username;
    private String password;

    public AdministratorManager() {
    }
    
 
    public String createCliente(){
        try{
           cb.create(morada, pessoaContacto, name, username, password);
           cleanCliente();
           return "index?faces-redirect=true";
        //cleanStudent();
        }catch(EntityAlreadyExistsException e){
            return e.getMessage();
        }
        
    }
    
    public void cleanCliente(){
        this.morada=null;
        this.name=null;
        this.username=null;
        this.password=null;
        this.pessoaContacto = null;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMorada() {
        return morada;
    }

    public void setMorada(String morada) {
        this.morada = morada;
    }

    public String getPessoaContacto() {
        return pessoaContacto;
    }

    public void setPessoaContacto(String pessoaContacto) {
        this.pessoaContacto = pessoaContacto;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    
    public List<Cliente> getAllClientes(){
        return cb.getAll();
    }
    
    public List<Administrador> getAllAdministradores(){
        return ab.getAll();
    }

    public ClienteBean getCb() {
        return cb;
    }

    public void setCb(ClienteBean cb) {
        this.cb = cb;
    }

    public AdministradorBean getAb() {
        return ab;
    }

    public void setAb(AdministradorBean ab) {
        this.ab = ab;
    }

   
    
    
}
