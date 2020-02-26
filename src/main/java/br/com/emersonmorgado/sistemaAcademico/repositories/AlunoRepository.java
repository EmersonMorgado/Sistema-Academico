package br.com.emersonmorgado.sistemaAcademico.repositories;


import br.com.emersonmorgado.sistemaAcademico.domain.Aluno;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AlunoRepository extends JpaRepository<Aluno, Integer> {
}
