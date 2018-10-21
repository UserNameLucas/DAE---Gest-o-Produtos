/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import javax.persistence.Entity;

/**
 *
 * @author Lucas
 */
@Entity
public class Cliente extends User implements Serializable{
    private String morada;
    private String pessoaContacto; // ver com o prof se a pessoa de contacto pode ser string ou precisamos guardar a informacao da pessoa

    public Cliente() {
    }

    public Cliente(String morada, String pessoaContacto, String name, String username, String password, String email) {
            super(name, username, password, email);
        this.morada = morada;
        this.pessoaContacto = pessoaContacto;
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
    
}
