package br.com.emersonmorgado.sistemaAcademico.services;

import br.com.emersonmorgado.sistemaAcademico.domain.Curso;
import br.com.emersonmorgado.sistemaAcademico.repositories.CursoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CursoServices {

    @Autowired
    private CursoRepository cursoRepository;

    public Curso buscar(Integer id){
        Optional<Curso> curso = cursoRepository.findById(id);
        return curso.orElse(null);
    }
}
