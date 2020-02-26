package br.com.emersonmorgado.sistemaAcademico.domain;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import java.io.Serializable;
import java.util.Objects;

@Entity
public class ResultadoAluno implements Serializable {

    @EmbeddedId //Id de um tipo auxiliar.
    private ResultadoAlunoPK id = new ResultadoAlunoPK();

    private Double notaObtida;

    public ResultadoAluno(){
    }

    public ResultadoAluno(Aluno aluno, Avaliacao avaliacao, Double notaObtida) {
        id.setAluno(aluno);
        id.setAvaliacao(avaliacao);
        this.notaObtida = notaObtida;
    }

    public Aluno getAluno(){
        return id.getAluno();
    }

    public Avaliacao getAvaliacao(){
        return id.getAvaliacao();
    }

    public ResultadoAlunoPK getId() {
        return id;
    }

    public void setId(ResultadoAlunoPK id) {
        this.id = id;
    }

    public Double getNotaObtida() {
        return notaObtida;
    }

    public void setNotaObtida(Double notaObtida) {
        this.notaObtida = notaObtida;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ResultadoAluno that = (ResultadoAluno) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
