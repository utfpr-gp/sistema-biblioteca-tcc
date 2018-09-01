/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.utfpr;

import br.edu.utfpr.model.Aluno;
import br.edu.utfpr.model.LivroDidatico;
import br.edu.utfpr.model.service.AlunoService;
import br.edu.utfpr.model.service.LivroDidaticoService;
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
public class LivroDidaticoBean implements Serializable
{
    private Long alunoId;
    private LivroDidatico livroDidatico;
    private List<LivroDidatico> livroDidaticoList;
    private LivroDidaticoService livroDidaticoService;
    
    public LivroDidaticoBean()
    {
        
    }
    
    @PostConstruct
    public void init()
    {
        livroDidatico = new LivroDidatico();
        livroDidaticoList = new ArrayList<>();
        livroDidaticoService = new LivroDidaticoService();
    }

    public Long getAlunoId() {
        return alunoId;
    }

    public void setAlunoId(Long alunoId) {
        this.alunoId = alunoId;
    }

    public LivroDidatico getLivroDidatico() {
        return livroDidatico;
    }

    public void setLivroDidatico(LivroDidatico livroDidatico) {
        this.livroDidatico = livroDidatico;
    }

    public List<LivroDidatico> getLivroDidaticoList() {
        return livroDidaticoList;
    }

    public void setLivroDidaticoList(List<LivroDidatico> livroDidaticoList) {
        this.livroDidaticoList = livroDidaticoList;
    }

    public LivroDidaticoService getLivroDidaticoService() {
        return livroDidaticoService;
    }

     public void edit(LivroDidatico livroDidatico) {
        this.livroDidatico = livroDidatico;
    }

    public void delete(LivroDidatico livroDidatico) {
        boolean isSuccess = livroDidaticoService.delete(livroDidatico);
        if (isSuccess) {
            MessageUtil.showMessage("Removido com sucesso", "", FacesMessage.SEVERITY_INFO);
        }
        this.livroDidatico = new LivroDidatico();
    }

    public void persist() {
        System.out.println("Id: " + livroDidatico.getId());
        if (livroDidatico.getId() == null) {
            if (livroDidaticoService.save(livroDidatico)) {            
                MessageUtil.showMessage("Persistido com sucesso", "", FacesMessage.SEVERITY_INFO);
            }
            System.out.println("Salvando aluno **********************");
        } else {
            System.out.println("Atualizando aluno **********************");
            livroDidaticoService.update(livroDidatico);
        }

        this.livroDidatico = new LivroDidatico();
    }

    public List<LivroDidatico> findAll() {
        return livroDidaticoService.findAll();
    }

    
    
    
}
