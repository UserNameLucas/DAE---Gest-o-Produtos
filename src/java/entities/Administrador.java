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
public class Administrador  extends User implements Serializable {
    private String cargo;

    public Administrador() {
    }

    public Administrador(String cargo, String name, String username, String password, String email) {
        super(name, username, password, email);
        this.cargo = cargo;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }
    
}
