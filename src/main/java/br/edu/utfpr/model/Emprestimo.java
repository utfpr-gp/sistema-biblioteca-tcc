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

@Entity
public class Emprestimo implements Serializable{
    
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @ManyToOne
    private Aluno aluno;
    
    @ManyToOne
    private LivroLiterario livroLiterario;
    
    private String data_emprestimo;
    private String data_devolucao;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Aluno getAluno() {
        return aluno;
    }

    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }

    public LivroLiterario getLivroLiterario() {
        return livroLiterario;
    }

    public void setLivroLiterario(LivroLiterario livroLiterario) {
        this.livroLiterario = livroLiterario;
    }

    public String getDataEmprestimo() {
        return data_emprestimo;
    }

    public void setDataEmprestimo(String data_emprestimo) {
        this.data_emprestimo = data_emprestimo;
    }

    public String getDataDevolucao() {
        return data_devolucao;
    }

    public void setDataDevolucao(String data_devolucao) {
        this.data_devolucao = data_devolucao;
    }
    
    
    
}
