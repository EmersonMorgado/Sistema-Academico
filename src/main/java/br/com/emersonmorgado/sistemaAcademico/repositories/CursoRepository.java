package br.com.emersonmorgado.sistemaAcademico.repositories;


import br.com.emersonmorgado.sistemaAcademico.domain.Curso;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CursoRepository extends JpaRepository<Curso, Integer> {
}
