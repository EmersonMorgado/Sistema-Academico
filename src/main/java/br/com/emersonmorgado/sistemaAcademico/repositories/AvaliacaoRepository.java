package br.com.emersonmorgado.sistemaAcademico.repositories;


import br.com.emersonmorgado.sistemaAcademico.domain.Avaliacao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AvaliacaoRepository extends JpaRepository<Avaliacao, Integer> {
}
