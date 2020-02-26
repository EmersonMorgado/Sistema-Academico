package br.com.emersonmorgado.sistemaAcademico.repositories;


import br.com.emersonmorgado.sistemaAcademico.domain.Turma;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TurmaRepository extends JpaRepository<Turma, Integer> {
}
