/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.utfpr;

import br.edu.utfpr.model.Aluno;
import br.edu.utfpr.model.LivroLiterario;
import br.edu.utfpr.model.service.AlunoService;
import br.edu.utfpr.model.service.LivroLiterarioService;
import br.edu.utfpr.util.MessageUtil;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;

@ManagedBean
@ViewScoped
public class LivroLiterarioBean implements Serializable{
    
    private Long generoId;
    private LivroLiterario livroLiterario;
    private List<LivroLiterario> livroLiterarioList;
    private LivroLiterarioService livroLiterarioService;
    
    
    public LivroLiterarioBean()
    {
        
    }
    
    @PostConstruct
    public void init()
    {
        livroLiterario = new LivroLiterario();
        livroLiterarioList = new ArrayList<>();
        livroLiterarioService = new LivroLiterarioService();
    }

    public Long getGeneroId() 
    {
        return generoId;
    }

    public void setGeneroId(Long generoId) 
    {
        this.generoId = generoId;
    }

    public LivroLiterario getLivroLiterario() 
    {
        return livroLiterario;
    }

    public void setLivroLiterario(LivroLiterario livroLiterario) 
    {
        this.livroLiterario = livroLiterario;
    }

    public List<LivroLiterario> getLivroLiterarioList() {
        return livroLiterarioList;
    }

    public void setLivroLiterarioList(List<LivroLiterario> livroLiterarioList) {
        this.livroLiterarioList = livroLiterarioList;
    }

    public LivroLiterarioService getLivroLiterarioService() {
        return livroLiterarioService;
    }

     public void edit(LivroLiterario livroLiterario) {
        this.livroLiterario = livroLiterario;
    }

    public void delete(LivroLiterario livroLiterario) {
        boolean isSuccess = livroLiterarioService.delete(livroLiterario);
        if (isSuccess) {
            this.livroLiterarioList.remove(livroLiterario);
            MessageUtil.showMessage("Removido com sucesso", "", FacesMessage.SEVERITY_INFO);
        }
        this.livroLiterario = new LivroLiterario();
    }

    public void persist() {

        if (livroLiterario.getId() == null) {
            if (livroLiterarioService.save(livroLiterario)) {
                this.livroLiterarioList.add(livroLiterario);
                MessageUtil.showMessage("Persistido com sucesso", "", FacesMessage.SEVERITY_INFO);
            }
        } else {
            livroLiterarioService.update(livroLiterario);
        }

        this.livroLiterario = new LivroLiterario();
    }

    public List<LivroLiterario> findAll() {
        return livroLiterarioService.findAll();
    }

    
    
}
