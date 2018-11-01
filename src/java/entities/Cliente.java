/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;

/**
 *
 * @author Lucas
 */
@Entity
public class Cliente extends User implements Serializable{
    private String morada;
    // ver com o prof se a pessoa de contacto pode ser string ou precisamos guardar a informacao da pessoa
    private String pessoaContacto; 
    
    private List<Configuracao> configuracoes;
    
    public Cliente() {
        this.configuracoes = new ArrayList<>();
    }

    public Cliente(String morada, String pessoaContacto, String name, String username, String password) {
            super(name, username, password);
        this.morada = morada;
        this.pessoaContacto = pessoaContacto;
        this.configuracoes = new ArrayList<>();
    }

    public List<Configuracao> getConfiguracoes() {
        return configuracoes;
    }

    public void setConfiguracoes(List<Configuracao> configuracoes) {
        this.configuracoes = configuracoes;
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
