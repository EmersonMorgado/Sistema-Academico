package br.com.emersonmorgado.sistemaAcademico;

import br.com.emersonmorgado.sistemaAcademico.domain.*;
import br.com.emersonmorgado.sistemaAcademico.repositories.*;
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

	@Autowired
	AlunoRepository alunoRepository;

	@Autowired
	ResultadoAlunoRepository resultadoAlunoRepository;

	@Autowired
	MatriculaRepository matriculaRepository;

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

		Aluno al1 = new Aluno("123456789-00", "Alfredo", sdf.parse("02/10/1981 00:00"));
		Aluno al2 = new Aluno("123456789-01", "Rafael", sdf.parse("02/11/1985 00:00"));
		alunoRepository.saveAll(Arrays.asList(al1, al2));

		ResultadoAluno r1 = new ResultadoAluno(al1, av1,35.00);
		ResultadoAluno r2 = new ResultadoAluno(al2, av1, 32.5);
		ResultadoAluno r3 = new ResultadoAluno(al2, av2, 55.00);
		ResultadoAluno r4 = new ResultadoAluno(al1, av2, 57.5);

		av1.getNotas().addAll(Arrays.asList(r1,r2));
		av2.getNotas().addAll(Arrays.asList(r3,r4));

		al1.getNotas().addAll(Arrays.asList(r1,r4));
		al2.getNotas().addAll(Arrays.asList(r2,r3));
		resultadoAlunoRepository.saveAll(Arrays.asList(r1, r2, r3, r4));

		Matricula m1 = new Matricula(al1,t1,sdf.parse("20/02/2019 00:00"),36);
		Matricula m2 = new Matricula(al2,t1,sdf.parse("25/02/2019 00:00"),36);

		t1.getMatriculas().addAll(Arrays.asList(m1, m2));

		al1.getMatriculas().addAll(Arrays.asList(m1));
		al2.getMatriculas().addAll(Arrays.asList(m2));

		al1.getTurmas().addAll(Arrays.asList(t1));
		al2.getTurmas().addAll(Arrays.asList(t1));

		t1.getAlunos().addAll(Arrays.asList(al1,al2));
		matriculaRepository.saveAll(Arrays.asList(m1, m2));


	}
}
