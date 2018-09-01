/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.utfpr;

import br.edu.utfpr.model.Emprestimo;
import br.edu.utfpr.model.service.EmprestimoService;
import br.edu.utfpr.util.MessageUtil;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean
public class EmprestimoBean implements Serializable{
    
    private Long alunoId;
    private Long livroLiterarioId;
    private Emprestimo emprestimo;
    private List<Emprestimo> emprestimoList;
    private EmprestimoService emprestimoService;
    
    public EmprestimoBean()
    {
        
    }
    
    @PostConstruct
    public void init()
    {
        emprestimo = new Emprestimo();
        emprestimoList = new ArrayList<>();
        emprestimoService = new EmprestimoService();
        
    }

    public Long getAlunoId() {
        return alunoId;
    }

    public void setAlunoId(Long alunoId) {
        this.alunoId = alunoId;
    }

    public Long getLivroLiterarioId() {
        return livroLiterarioId;
    }

    public void setLivroLiterarioId(Long livroLiterarioId) {
        this.livroLiterarioId = livroLiterarioId;
    }

    public Emprestimo getEmprestimo() {
        return emprestimo;
    }

    public void setEmprestimo(Emprestimo emprestimo) {
        this.emprestimo = emprestimo;
    }

    public List<Emprestimo> getEmprestimoList() {
        return emprestimoList;
    }

    public void setEmprestimoList(List<Emprestimo> emprestimoList) {
        this.emprestimoList = emprestimoList;
    }

    public EmprestimoService getEmprestimoService() {
        return emprestimoService;
    }

    public void edit(Emprestimo emprestimo) 
    {
        this.emprestimo = emprestimo;
    }
    
    
    public void delete(Emprestimo emprestimo) {
        boolean isSuccess = emprestimoService.delete(emprestimo);
        if (isSuccess) {
            this.emprestimoList.remove(emprestimo);
            MessageUtil.showMessage("Removido com sucesso", "", FacesMessage.SEVERITY_INFO);
        }
        this.emprestimo = new Emprestimo();
    }

    public void persist() {

        if (emprestimo.getId() == null) {
            if (emprestimoService.save(emprestimo)) {
                this.emprestimoList.add(emprestimo);
                MessageUtil.showMessage("Persistido com sucesso", "", FacesMessage.SEVERITY_INFO);
            }
        } else {
            emprestimoService.update(emprestimo);
        }

        this.emprestimo = new Emprestimo();
    }

    public List<Emprestimo> findAll() {
        return emprestimoService.findAll();
    }

    
    
    
}
