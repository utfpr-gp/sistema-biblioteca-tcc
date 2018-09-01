/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.utfpr.model;

import br.edu.utfpr.model.service.LivroLiterarioService;
import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class LivroLiterario implements Serializable
{
     @Id
     @GeneratedValue(strategy = GenerationType.IDENTITY)
     private Long id;
     
     //@NotEmpty
     //@Size(min = 2, max = 255)
     private String titulo;
     
     //@NotEmpty
     //@Size(min = 2, max = 255)
     private String autor;
     
     
    //@NotEmpty
    //@Min(value = 1)
    //@Max(value = 9999)
     private int paginas;
     
     private int edicao;
     
    //@NotEmpty
    //@Min(value = 1900)
    //@Max(value = 2019)
     private int ano;
     
     @ManyToOne
     private Genero genero;

     public Long getId() 
     {
        return id;
     }

     public void setId(Long id) 
     {
        this.id = id;
     }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public int getPaginas() {
        return paginas;
    }

    public void setPaginas(int paginas) {
        this.paginas = paginas;
    }

    public Genero getGenero() {
        return genero;
    }

    public void setGenero(Genero genero) {
        this.genero = genero;
    }
    
    public int getAno()
    {
        return ano;
    }
    
    public void setAno(int ano)
    {
        this.ano = ano;
    }
    
    public int getEdicao()
    {
        return edicao;
    }
    
    public void setEdicao(int edicao)
    {
        this.edicao = edicao;
    }
     
     
    
    
}
