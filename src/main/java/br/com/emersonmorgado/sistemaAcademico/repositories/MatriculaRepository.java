package br.com.emersonmorgado.sistemaAcademico.repositories;


import br.com.emersonmorgado.sistemaAcademico.domain.Matricula;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MatriculaRepository extends JpaRepository<Matricula, Integer> {
}
