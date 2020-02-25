package br.com.emersonmorgado.sistemaAcademico.resources;

import br.com.emersonmorgado.sistemaAcademico.domain.Curso;
import br.com.emersonmorgado.sistemaAcademico.services.CursoServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/clientes")
public class CursoResource {

    @Autowired
    private CursoServices cursoServices;

    @GetMapping(value ="/{id}")
    public ResponseEntity<?> find(@PathVariable Integer id){
        Curso curso = cursoServices.buscar(id);

        return ResponseEntity.ok(curso);
    }
}
