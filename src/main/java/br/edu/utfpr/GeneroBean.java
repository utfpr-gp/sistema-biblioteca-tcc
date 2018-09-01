/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.utfpr;

import br.edu.utfpr.model.Genero;
import br.edu.utfpr.model.service.GeneroService;
import br.edu.utfpr.util.MessageUtil;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author Lucas
 */

@ManagedBean
@ViewScoped
public class GeneroBean implements Serializable{
    
    private Genero genero;
    private GeneroService generoService;
    
    public GeneroBean()
    {
        
    }
    
    @PostConstruct
    public void init()
    {
        genero = new Genero();
        generoService = new GeneroService();
    }
    
    public Genero getGenero()
    {
        return genero;
    }
    
    public void setGenero(Genero genero)
    {
        this.genero = genero;
    }
        
    public GeneroService getGeneroService()
    {
        return generoService;
    }
    
    public void edit(Genero genero)
    {
        this.genero = genero;
    }
    
    public void delete(Genero genero) {
        boolean isSuccess = generoService.delete(genero);
        if (isSuccess) {
            MessageUtil.showMessage("Removido com sucesso", "", FacesMessage.SEVERITY_INFO);
        }
        this.genero = new Genero();
    }
    
    public void persist() {

        if (genero.getId() == null) {
            if (generoService.save(genero)) {
                MessageUtil.showMessage("Persistido com sucesso", "", FacesMessage.SEVERITY_INFO);
            }
        } else {
            generoService.update(genero);
        }

        this.genero = new Genero();
    }

    public List<Genero> findAll() {
        return generoService.findAll();
    }
}
