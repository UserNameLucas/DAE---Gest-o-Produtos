/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Lucas
 *  ------------------------------VER MESMO MELHOR
 *          configuracao e nome ????????
 */
@Entity
@NamedQuery(
    name="getAllTemplates",
    query="SELECT c FROM Template c "
)
@Table(name="TEMPLATES")
public class Template implements Serializable{
    @Id
    private int codigo;
    @NotNull(message = "Nome não pode estar vazio!")
    private String nome;
    @NotNull(message = "É necessario uma configuração!")
    private Configuracao configuracao;

    public Template() {
    }

    public Template(int codigo,String nome, Configuracao configuracao) {
        this.codigo = codigo;
        this.nome = nome;
        this.configuracao = configuracao;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Configuracao getConfiguracao() {
        return configuracao;
    }

    public void setConfiguracao(Configuracao configuracao) {
        this.configuracao = configuracao;
    }
    
}
