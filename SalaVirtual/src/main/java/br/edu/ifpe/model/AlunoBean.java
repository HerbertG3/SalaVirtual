package br.edu.ifpe.model;

import java.util.ArrayList;
import java.util.List;

import br.edu.ifpe.model.entity.Aluno;
import br.edu.ifpe.model.entity.Usuario;
import br.edu.ifpe.model.repositorio.AlunoRepositorio;
import br.edu.ifpe.model.repositorio.UsuarioRepositorio;
import jakarta.ejb.EJB;
import jakarta.ejb.Stateless;

@Stateless
public class AlunoBean {
	
	@EJB
	private AlunoRepositorio alunoRepositorio;
	
	public void adicionarAluno(Aluno a) {
		if (a != null && a.getNome() != null &&
				!a.getNome().equals("")) {
			this.alunoRepositorio.create(a);
		}
	}
	
	public void atualizarAluno(Aluno a) {
		this.alunoRepositorio.update(a);
	}

	public List<Aluno> readAll() {
		return this.alunoRepositorio.readAll();
	}
	
	public List<Aluno> buscarAluno(String nome) {
		List<Aluno> alunos = new ArrayList<Aluno>();
		alunos = this.alunoRepositorio.read(nome);
		
		return alunos; 
	}
	
	public void excluirAluno(Aluno a) {
		alunoRepositorio.delete(a);
	}
	
	public Aluno buscarMatriculaAluno(String matricula) {
		Aluno aluno = new Aluno();
		aluno = this.alunoRepositorio.readAluno(matricula);
		
		return aluno; 
	}

}
