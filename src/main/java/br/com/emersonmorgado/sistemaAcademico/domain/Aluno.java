package br.com.emersonmorgado.sistemaAcademico.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.*;

@Entity
public class Aluno {

    @Id
    private Integer cpf;

    private String nome;

    @JsonFormat(pattern = "dd/MM/yyyy")
    private Date nascimento;

    @JsonIgnore
    @OneToMany(mappedBy = "id.aluno")
    private Set<ResultadoAluno> notas = new HashSet<>();

    @JsonIgnore
    @OneToMany(mappedBy = "id.aluno")
    private Set<Matricula> matriculas = new HashSet<>();

    public Aluno(){
    }

    public Aluno(Integer cpf, String nome, Date nascimento) {
        this.cpf = cpf;
        this.nome = nome;
        this.nascimento = nascimento;
    }

    @JsonIgnore
    public List<Turma> getTurmas(){
        List<Turma> list = new ArrayList<>();
        for (Matricula x : matriculas){
            list.add(x.getTurma());
        }
        return list;
    }

    public Integer getCpf() {
        return cpf;
    }

    public void setCpf(Integer cpf) {
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Date getNascimento() {
        return nascimento;
    }

    public void setNascimento(Date nascimento) {
        this.nascimento = nascimento;
    }

    public Set<ResultadoAluno> getNotas() {
        return notas;
    }

    public void setNotas(Set<ResultadoAluno> notas) {
        this.notas = notas;
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
        Aluno aluno = (Aluno) o;
        return Objects.equals(cpf, aluno.cpf);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cpf);
    }
}
