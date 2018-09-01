package br.edu.utfpr;

import br.edu.utfpr.model.Aluno;
import br.edu.utfpr.model.Turma;
import br.edu.utfpr.model.service.AlunoService;
import br.edu.utfpr.model.service.TurmaService;
import br.edu.utfpr.util.MessageUtil;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean
@ViewScoped
public class AlunoBean implements Serializable {

    private Long turmaId;
    private Aluno aluno;

    private AlunoService alunoService;
    private TurmaService turmaService;

    public AlunoBean() {

    }

    @PostConstruct
    public void init() {
        aluno = new Aluno();
        alunoService = new AlunoService();
        turmaService = new TurmaService();
    }

    public Long getTurmaId() {
        return turmaId;
    }

    public void setTurmaId(Long turmaId) {
        this.turmaId = turmaId;
    }

    public Aluno getAluno() {
        return aluno;
    }

    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }

    public AlunoService getAlunoService() {
        return alunoService;
    }

    public void edit(Aluno aluno) {
        this.aluno = aluno;
    }

    public void delete(Aluno aluno) {
        boolean isSuccess = alunoService.delete(aluno);
        if (isSuccess) {
            MessageUtil.showMessage("Removido com sucesso", "", FacesMessage.SEVERITY_INFO);
        }
        this.aluno = new Aluno();
    }

    public void persist() {
        System.out.println("Id: " + aluno.getId());

        if (aluno.getId() == null) {
            Turma turma = turmaService.getById(turmaId);
            aluno.setTurma(turma);
            if (alunoService.save(aluno)) {
                MessageUtil.showMessage("Persistido com sucesso", "", FacesMessage.SEVERITY_INFO);
            }
            System.out.println("Salvando aluno **********************");
        } else {
            System.out.println("Atualizando aluno **********************");
            alunoService.update(aluno);
        }

        this.aluno = new Aluno();
    }

    public List<Aluno> findAll() {
        return alunoService.findAll();
    }

}
