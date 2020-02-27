package br.com.emersonmorgado.sistemaAcademico.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

@Entity
public class Matricula implements Serializable {

    @JsonIgnore
    @EmbeddedId
    private MatriculaPK id = new MatriculaPK();

    private Date dataMatricula;
    private Integer prestacoes;

    public Matricula() {
    }


    public Matricula(Aluno aluno, Turma turma, Date dataMatricula, Integer prestacoes) {
        id.setAluno(aluno);
        id.setTurma(turma);
        this.dataMatricula = dataMatricula;
        this.prestacoes = prestacoes;
    }

    public Aluno getAluno(){
        return id.getAluno();
    }

    public Turma getTurma(){
        return id.getTurma();
    }

    public MatriculaPK getId() {
        return id;
    }

    public void setId(MatriculaPK id) {
        this.id = id;
    }

    public Date getDataMatricula() {
        return dataMatricula;
    }

    public void setDataMatricula(Date dataMatricula) {
        this.dataMatricula = dataMatricula;
    }

    public Integer getPrestacoes() {
        return prestacoes;
    }

    public void setPrestacoes(Integer prestacoes) {
        this.prestacoes = prestacoes;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Matricula matricula = (Matricula) o;
        return Objects.equals(id, matricula.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
