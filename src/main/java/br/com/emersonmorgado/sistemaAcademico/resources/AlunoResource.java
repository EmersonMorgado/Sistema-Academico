package br.com.emersonmorgado.sistemaAcademico.resources;

import br.com.emersonmorgado.sistemaAcademico.domain.Aluno;
import br.com.emersonmorgado.sistemaAcademico.services.AlunoServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/alunos")
public class AlunoResource {

    @Autowired
    private AlunoServices alunoServices;

    @GetMapping(value ="/{id}")
    public ResponseEntity<?> find(@PathVariable Integer id){
        Aluno aluno = alunoServices.buscar(id);
        return ResponseEntity.ok(aluno);
    }
}
