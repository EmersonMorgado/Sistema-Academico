package br.com.emersonmorgado.sistemaAcademico.domain;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.*;

@Entity
public class Turma implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String numero;

    @JsonFormat(pattern = "dd/MM/yyyy")
    private Date inicio;

    private Integer vagas;

    @ManyToOne
    @JoinColumn(name = "curso_id")
    private Curso curso;

    @JsonIgnore
    @OneToMany(mappedBy = "turma")
    private List<Avaliacao> avaliacoes = new ArrayList<>();

    @JsonIgnore
    @OneToMany(mappedBy = "id.turma")
    private Set<Matricula> matriculas = new HashSet<>();

    public Turma(){
    }

    public Turma(Integer id, String numero, Date inicio, Integer vagas, Curso curso) {
        this.id = id;
        this.numero = numero;
        this.inicio = inicio;
        this.vagas = vagas;
        this.curso = curso;
    }

   //@JsonIgnore
    public List<Aluno> getAlunos(){
        List<Aluno> list = new ArrayList<>();
        for(Matricula x : matriculas){
            list.add(x.getAluno());
        }
        return list;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public Date getInicio() {
        return inicio;
    }

    public void setInicio(Date inicio) {
        this.inicio = inicio;
    }

    public Integer getVagas() {
        return vagas;
    }

    public void setVagas(Integer vagas) {
        this.vagas = vagas;
    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    public List<Avaliacao> getAvaliacoes() {
        return avaliacoes;
    }

    public void setAvaliacoes(List<Avaliacao> avaliacoes) {
        this.avaliacoes = avaliacoes;
    }

    public Set<Matricula> getMatriculas() {
        return matriculas;
    }

    public void setMatriculas(Set<Matricula> matriculas) {
        this.matriculas = matriculas;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Turma turma = (Turma) o;
        return Objects.equals(id, turma.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}
