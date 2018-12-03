/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

/**
 *
 * @author Lucas
 */
@Entity
@Table(name="ADMINISTRADORS")
@NamedQuery(
    name="getAllAdministradors",
    query="SELECT c FROM Administrador c ORDER BY c.name"
)
public class Administrador  extends User implements Serializable {
    
    @NotNull(message="O cargo não pode estar vazio!")
    private String cargo;
    @NotNull(message="O Email não pode estar vazio")
    @Pattern(regexp = "[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\."
        +"[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@"
        +"(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?",
        message = "Formato do email invalido!")
    private String email;

    public Administrador() {
    }

    public Administrador(String cargo, String name, String username, String password, String email) {
        super(name, username, password);
        this.cargo = cargo;
        this.email = email;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }
        
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    
}
