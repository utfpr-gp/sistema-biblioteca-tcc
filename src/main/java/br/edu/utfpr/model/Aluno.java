/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.utfpr.model;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 *
 * @author Lucas
 */
@Entity
public class Aluno implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    //@NotEmpty
    //@Size(min = 2, max = 255)
    private String nome;
    
    //@NotEmpty
    //@Pattern(regexp = ".+@.+\\.[a-z]+")
    //@Size(min = 2, max = 255)
    private String email;
    
    //@NotEmpty
    //Dificil criar uma expressao de validacao
    //pois alguns numeros tem esse formato (2)(4)-(4) e outros (2)(5)-(4)
    private String celular;
    
    //@NotEmpty
    //@Size(min = 2, max = 255)
    private String mae;
    
    //@NotEmpty
    //@Size(min = 2, max = 255)
    private String pai;
    
    @ManyToOne
    private Turma turma;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getMae() {
        return mae;
    }

    public void setMae(String mae) {
        this.mae = mae;
    }

    public String getPai() {
        return pai;
    }

    public void setPai(String pai) {
        this.pai = pai;
    }

    public Turma getTurma() {
        return turma;
    }

    public void setTurma(Turma turma) {
        this.turma = turma;
    }
    
    
    
}
