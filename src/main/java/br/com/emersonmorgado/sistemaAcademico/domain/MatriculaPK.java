package br.com.emersonmorgado.sistemaAcademico.domain;


import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class MatriculaPK implements Serializable {

    @ManyToOne
    @JoinColumn(name = "turma_id")
    private Turma turma;

    @ManyToOne
    @JoinColumn(name = "aluno_id")
    private Aluno aluno;

    public Turma getTurma() {
        return turma;
    }

    public void setTurma(Turma turma) {
        this.turma = turma;
    }

    public Aluno getAluno() {
        return aluno;
    }

    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MatriculaPK that = (MatriculaPK) o;
        return Objects.equals(turma, that.turma) &&
                Objects.equals(aluno, that.aluno);
    }

    @Override
    public int hashCode() {
        return Objects.hash(turma, aluno);
    }
}
