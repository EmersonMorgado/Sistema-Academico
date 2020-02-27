package br.com.emersonmorgado.sistemaAcademico.services;

import br.com.emersonmorgado.sistemaAcademico.domain.Aluno;
import br.com.emersonmorgado.sistemaAcademico.repositories.AlunoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AlunoServices {

    @Autowired
    private AlunoRepository alunoRepository;

    public Aluno buscar(Integer id){
        Optional<Aluno> aluno = alunoRepository.findById(id);
        return aluno.orElse(null);
    }
}
