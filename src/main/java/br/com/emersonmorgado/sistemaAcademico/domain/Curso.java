package br.com.emersonmorgado.sistemaAcademico.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
public class Curso implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nome;
    private Integer cargaHoraria;
    private  Double valor;
    private Integer notaPrevista;
    private Integer notaMaxima;

    @JsonIgnore
    @OneToMany(mappedBy = "curso")
    private List<Turma> turmas = new ArrayList<>();

    public Curso(){
    }

    public Curso(Integer id, String nome, Integer cargaHoraria, Double valor, Integer notaPrevista, Integer notaMaxima) {
        this.id = id;
        this.nome = nome;
        this.cargaHoraria = cargaHoraria;
        this.valor = valor;
        this.notaPrevista = notaPrevista;
        this.notaMaxima = notaMaxima;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getCargaHoraria() {
        return cargaHoraria;
    }

    public void setCargaHoraria(Integer cargaHoraria) {
        this.cargaHoraria = cargaHoraria;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public Integer getNotaPrevista() {
        return notaPrevista;
    }

    public void setNotaPrevista(Integer notaPrevista) {
        this.notaPrevista = notaPrevista;
    }

    public Integer getNotaMaxima() {
        return notaMaxima;
    }

    public void setNotaMaxima(Integer notaMaxima) {
        this.notaMaxima = notaMaxima;
    }

    public List<Turma> getTurmas() {
        return turmas;
    }

    public void setTurmas(List<Turma> turmas) {
        this.turmas = turmas;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Curso curso = (Curso) o;
        return Objects.equals(id, curso.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
