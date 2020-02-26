package br.com.emersonmorgado.sistemaAcademico;

import br.com.emersonmorgado.sistemaAcademico.domain.Aluno;
import br.com.emersonmorgado.sistemaAcademico.domain.Avaliacao;
import br.com.emersonmorgado.sistemaAcademico.domain.Curso;
import br.com.emersonmorgado.sistemaAcademico.domain.Turma;
import br.com.emersonmorgado.sistemaAcademico.repositories.AlunoRepository;
import br.com.emersonmorgado.sistemaAcademico.repositories.AvaliacaoRepository;
import br.com.emersonmorgado.sistemaAcademico.repositories.CursoRepository;
import br.com.emersonmorgado.sistemaAcademico.repositories.TurmaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.text.SimpleDateFormat;
import java.util.Arrays;

@SpringBootApplication
public class SistemaAcademicoApplication implements CommandLineRunner {

	@Autowired
	CursoRepository cursoRepository;

	@Autowired
	TurmaRepository turmaRepository;

	@Autowired
	AvaliacaoRepository avaliacaoRepository;

	public static void main(String[] args) {
		SpringApplication.run(SistemaAcademicoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy hh:mm");

		Curso c1 = new Curso(null, "Informática", 80, 800.00,100,70);
		cursoRepository.saveAll(Arrays.asList(c1));

		Turma t1 = new Turma(null, "801A",sdf.parse("03/03/2019 00:00"),50,c1);
		turmaRepository.saveAll(Arrays.asList(t1));

		Avaliacao av1 = new Avaliacao(null, 40, sdf.parse("13/05/2019 00:00"),t1);
		Avaliacao av2 = new Avaliacao(null, 60, sdf.parse("20/05/2019 00:00"),t1);
		avaliacaoRepository.saveAll(Arrays.asList(av1,av2));


	}
}
