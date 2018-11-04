/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author Lucas
 * 
 * ------------------ VER FOLHA 
 * 
 */
@Entity
@Table(name = "CONFIGURACAO")
public class Configuracao implements Serializable{
    @Id
    private int codigo;
    private String descricao;
    private Estado estado;
    private String nomeSoftware;
    private int versaoBase;
    private Modulo modulos;
    
    // HARDWARE / SERVIÇOS CLOUD UTILIZADOS
    // LINCENCAS 
    // PARAMETRIZAÇÕES 
    // DADOS DO CONTRATO DE MANUTENÇAO     

    public Configuracao() { 
    }

    public Configuracao(int codigo, String descricao, Estado estado, String nomeSoftware, int versaoBase, Modulo modulos) {
        this.codigo = codigo;
        this.descricao = descricao;
        this.estado = estado;
        this.nomeSoftware = nomeSoftware;
        this.versaoBase = versaoBase;
        this.modulos = modulos;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    public String getNomeSoftware() {
        return nomeSoftware;
    }

    public void setNomeSoftware(String nomeSoftware) {
        this.nomeSoftware = nomeSoftware;
    }

    public int getVersaoBase() {
        return versaoBase;
    }

    public void setVersaoBase(int versaoBase) {
        this.versaoBase = versaoBase;
    }

    public Modulo getModulos() {
        return modulos;
    }

    public void setModulos(Modulo modulos) {
        this.modulos = modulos;
    }
    
    
    
}
