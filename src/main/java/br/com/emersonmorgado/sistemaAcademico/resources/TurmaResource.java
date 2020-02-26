package br.com.emersonmorgado.sistemaAcademico.resources;

import br.com.emersonmorgado.sistemaAcademico.domain.Turma;
import br.com.emersonmorgado.sistemaAcademico.services.TurmaServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/turmas")
public class TurmaResource {

    @Autowired
    private TurmaServices turmaServices;

    @GetMapping(value ="/{id}")
    public ResponseEntity<?> find(@PathVariable Integer id){
        Turma turma = turmaServices.buscar(id);

        return ResponseEntity.ok(turma);
    }
}
