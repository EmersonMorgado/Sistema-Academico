package br.com.emersonmorgado.sistemaAcademico.resources;

import br.com.emersonmorgado.sistemaAcademico.domain.Curso;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/clientes")
public class CursoResoure {

    @GetMapping
    public List<Curso> listar(){

        Curso c1 = new Curso(001,"Engenharia Elétrica",3600,4500.00,10,7);

        List<Curso> list = new ArrayList<>();
        list.add(c1);

        return list;
    }
}
