package br.com.emersonmorgado.sistemaAcademico;

import br.com.emersonmorgado.sistemaAcademico.domain.Curso;
import br.com.emersonmorgado.sistemaAcademico.repositories.CursoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;

@SpringBootApplication
public class SistemaAcademicoApplication implements CommandLineRunner {

	@Autowired
	CursoRepository cursoRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(SistemaAcademicoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		Curso c1 = new Curso(null, "Informática", 80, 800.00,100,70);

		cursoRepository.saveAll(Arrays.asList(c1));
	}
}
