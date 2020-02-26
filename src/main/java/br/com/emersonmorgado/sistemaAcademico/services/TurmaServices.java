package br.com.emersonmorgado.sistemaAcademico.services;

import br.com.emersonmorgado.sistemaAcademico.domain.Turma;
import br.com.emersonmorgado.sistemaAcademico.repositories.TurmaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TurmaServices {

    @Autowired
    private TurmaRepository turmaRepository;

    public Turma buscar(Integer id){
        Optional<Turma> turma = turmaRepository.findById(id);
        return turma.orElse(null);
    }
}
