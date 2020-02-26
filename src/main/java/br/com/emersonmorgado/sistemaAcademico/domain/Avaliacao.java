package br.com.emersonmorgado.sistemaAcademico.domain;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.util.*;

@Entity
public class Avaliacao implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Integer nota;

    @JsonFormat(pattern = "dd/MM/yyyy")
    private Date data;

    @ManyToOne
    @JoinColumn(name = "turma_id") //Chave estrangeira na tabela AVALIACAO
    private Turma turma;

    @OneToMany(mappedBy = "id.avaliacao")
    private Set<ResultadoAluno> notas = new HashSet<>();

    public Avaliacao(){

    }

    public Avaliacao(Integer id, Integer nota, Date data, Turma turma) {
        this.id = id;
        this.nota = nota;
        this.data = data;
        this.turma = turma;
    }

    public List<Aluno> getAlunos(){
        List<Aluno> list = new ArrayList<>();
        for(ResultadoAluno x : notas){
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

    public Integer getNota() {
        return nota;
    }

    public void setNota(Integer nota) {
        this.nota = nota;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public Turma getTurma() {
        return turma;
    }

    public void setTurma(Turma turma) {
        this.turma = turma;
    }

    public Set<ResultadoAluno> getNotas() {
        return notas;
    }

    public void setNotas(Set<ResultadoAluno> notas) {
        this.notas = notas;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Avaliacao avaliacao = (Avaliacao) o;
        return Objects.equals(id, avaliacao.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
