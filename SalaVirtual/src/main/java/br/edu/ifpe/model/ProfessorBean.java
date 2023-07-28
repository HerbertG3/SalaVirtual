package br.edu.ifpe.model;

import java.util.ArrayList;
import java.util.List;

import br.edu.ifpe.model.entity.Professor;
import br.edu.ifpe.model.repositorio.ProfessorRepositorio;
import jakarta.ejb.EJB;
import jakarta.ejb.Stateless;

@Stateless
public class ProfessorBean {
	
	@EJB
	private ProfessorRepositorio professorRepositorio;
	
	public void create(Professor p) {
		if (p != null && p.getNome() != null &&
				!p.getNome().equals("")) {
			this.professorRepositorio.create(p);
		}
	}
	
	public List<Professor>readAll(){
		return this.professorRepositorio.readAll();
	}
	
	public void atualizarProfessor(Professor p) {
		this.professorRepositorio.update(p);
	}

	
	public List<Professor> buscarProfessor(String nome) {
		List<Professor> professores = new ArrayList<Professor>();
		professores = this.professorRepositorio.read(nome);
		
		return professores; 
	}
	
	public Professor buscarMatricula(String matricula) {
		Professor professor = new Professor();
		professor = this.professorRepositorio.buscarMatricula(matricula);
		
		return professor; 
	}
	
	public void excluirProfessor(Professor p) {
		professorRepositorio.delete(p);
	}


}
