package br.edu.utfpr.model;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class LivroDidatico implements Serializable
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    //@NotEmpty
    //@Size(min = 2, max = 255)
    private String titulo;
    
    //@NotEmpty
    //@Min(value = 2019)
    //@Max(value = 2099)
    private int ano;
    
    //@NotEmpty
    //@Min(value = 1)
    //@Max(value = 9)
    private String serie;
    
    //@NotEmpty
    //@Min(value = 2000)
    //@Max(value = 2099)
    private int pnld;
    
    
    private String data_emprestimo;
    
    //@Future
    private String data_devolucao;
    
    @ManyToOne
    private Aluno aluno;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public String getSerie() {
        return serie;
    }

    public void setSerie(String serie) {
        this.serie = serie;
    }

    public int getPnld() {
        return pnld;
    }

    public void setPnld(int pnld) {
        this.pnld = pnld;
    }

    public String getData_emprestimo() {
        return data_emprestimo;
    }

    public void setData_emprestimo(String data_emprestimo) {
        this.data_emprestimo = data_emprestimo;
    }

    public String getData_devolucao() {
        return data_devolucao;
    }

    public void setData_devolucao(String data_devolucao) {
        this.data_devolucao = data_devolucao;
    }
    
    public Aluno getAluno()
    {
        return aluno;
    }
    
    public void setAluno(Aluno aluno)
    {
        this.aluno = aluno;
    }
    
    

}
