package br.edu.ifpe.controller;

import java.util.List;

import br.edu.ifpe.model.ProfessorBean;
import br.edu.ifpe.model.entity.Professor;
import jakarta.ejb.EJB;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Named;

@RequestScoped
@Named
public class ProfessorMB {
	
	@EJB
	private ProfessorBean professorBean;
	
	private String nome;
	private String cpf;
	private String matricula;
	private String departamento;
	private String disciplina;
	private String email;
	private int telefone;
	

	private Professor professorSelecionado = new Professor();
	private Professor p = new Professor();
	
	public void criarProfessor() {
		p.setTipo("P");
		p.setNome(this.nome);
		p.setCpf(this.cpf);
		p.setMatricula(this.matricula);
		p.setDepartamento(departamento);
		//p.setDisciplina(disciplina);
		p.setEmail(email);
		p.setTelefone(telefone);
		
		this.professorBean.create(p);
	}
	
	public void atualizarProfessor() {
		this.professorSelecionado.setNome(this.nome);
		this.professorSelecionado.setCpf(this.cpf);
		this.professorBean.atualizarProfessor(this.professorSelecionado);
	}
	
	public List<Professor>getBuscarProfessores() {
		return professorBean.readAll();
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getDepartamento() {
		return departamento;
	}

	public void setDepartamento(String departamento) {
		this.departamento = departamento;
	}
	
		
	public String getDisciplina() {
		return disciplina;
	}

	public void setDisciplina(String disciplina) {
		this.disciplina = disciplina;
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getTelefone() {
		return telefone;
	}

	public void setTelefone(int telefone) {
		this.telefone = telefone;
	}

	public Professor getP() {
		return p;
	}

	public void setP(Professor p) {
		this.p = p;
	}
	
	public Professor getProfessorSelecionado() {
		return professorSelecionado;
	}

	public void setProfessorSelecionado(Professor professorSelecionado) {
		this.professorSelecionado = professorSelecionado;
	}

	public void excluirProfessor(Professor p) {
		professorBean.excluirProfessor(p);
	}

}
