package br.edu.ifpe.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import br.edu.ifpe.model.entity.Professor;
import br.edu.ifpe.model.entity.Sala;
import br.edu.ifpe.model.entity.Turma;
import br.edu.ifpe.model.repositorio.ProfessorRepositorio;
import br.edu.ifpe.model.repositorio.SalaRepositorio;
import br.edu.ifpe.model.repositorio.TurmaRepositorio;
import jakarta.ejb.EJB;
import jakarta.ejb.Stateful;

@Stateful
public class TurmaBean implements Serializable {

	private static final long serialVersionUID = 3627609090247006343L;

	// private List<Turma> turmas = new ArrayList<Turma>();

	@EJB
	private ProfessorRepositorio professorRepositorio;
	@EJB
	private TurmaRepositorio turmaRepositorio;
	@EJB
	private SalaRepositorio salaRepositorio;

	public void criarTurma(Turma t) {
		// this.turmas.add(t);
		if(t.getProfessor()== null) {
			t.setNomeProfessor("Sem Professor");
		}
		
		if(t.getSala()== null) {
			t.setNomeSala("Não Alocada");
		}
		t.setId(turmaRepositorio.readAll().size()+1);
		turmaRepositorio.create(t);
	}

	public List<Turma> listarTurma() {
		return turmaRepositorio.readAll();
	}

//	private List<String> getListarNomesTurmas() {
//		List<String> nomeTurma = new ArrayList<String>();
//
//		for (Turma turma : this.turmas) {
//			nomeTurma.add(turma.getNome());
//		}
//
//		return nomeTurma;
//	}

	public List<Professor> listarProfessor() {

		List<Professor> professores = new ArrayList<Professor>();
		for (Professor p : professorRepositorio.readAll()) {
			professores.add(p);
		}
		return professores;
	}

	public List<Sala> listarSalas() {

		List<Sala> salas = new ArrayList<Sala>();
		for (Sala s : salaRepositorio.readAll()) {
			salas.add(s);
		}
		return salas;
	}

	public void atualizarTurma(Turma t) {
		this.turmaRepositorio.update(t);
	}

	public void excluirTurma(Turma t) {
		turmaRepositorio.delete(t);
	}

//	public void atribuirProfessor(String matriculaP, String nomeTurma) {
//		Professor professor = new Professor();
//		professor = repositorioProfessor.read(matriculaP);
//	}
//	
	public List<Turma>buscarTurma(Turma t){
		List<Turma>lista = new ArrayList<Turma>();
		lista.addAll(turmaRepositorio.read(t.getNome()));
		return lista;
	}
	
	public List<Turma>listarTurmaComProfessor(){
		List<Turma>lista = new ArrayList<Turma>();
		lista.addAll(turmaRepositorio.readProfessor());
		return lista;
	}
	
	public Turma buscarId(Integer id){
		Turma turma = new Turma();
		turma = turmaRepositorio.buscarId(id);
		return turma;
	}

}
