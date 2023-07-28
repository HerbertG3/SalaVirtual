package br.edu.ifpe.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import br.edu.ifpe.model.ProfessorBean;
import br.edu.ifpe.model.TurmaBean;
import br.edu.ifpe.model.entity.Aluno;
import br.edu.ifpe.model.entity.Professor;
import br.edu.ifpe.model.entity.Sala;
import br.edu.ifpe.model.entity.Turma;
import br.edu.ifpe.model.repositorio.ProfessorRepositorio;
import br.edu.ifpe.model.repositorio.SalaRepositorio;
import jakarta.ejb.EJB;
import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Named;

@Named("turmaMB")
@SessionScoped
public class TurmaMB implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@EJB
	private TurmaBean turmaBean;
//	@EJB
//	private ProfessorBean professorBean;
//	@EJB
//	private ProfessorRepositorio professorRepositorio;
//	@EJB
//	private SalaRepositorio salaRepositorio;
	
	private Turma turmaSelecionada = new Turma();
	private List<Turma> turmaEncontrada = new ArrayList<Turma>();
	private String nome;
	private String disciplina;
	private String nomeProfessor;
	private String matriculaProfessor;
	private String nomeSala;
	private List<Aluno>alunos = new ArrayList<Aluno>();
	
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getDisciplina() {
		return disciplina;
	}
	public void setDisciplina(String disciplina) {
		this.disciplina = disciplina;
	}
		
	public String getNomeSala() {
		return nomeSala;
	}
	public void setNomeSala(String nomeSala) {
		this.nomeSala = nomeSala;
	}
	
	public String getNomeProfessor() {
		return nomeProfessor;
	}
	public void setNomeProfessor(String nomeProfessor) {
		this.nomeProfessor = nomeProfessor;
	}
	public List<Aluno> getAlunos() {
		return alunos;
	}
	public void setAlunos(List<Aluno> alunos) {
		this.alunos = alunos;
	}
	
	public List<Turma> getTurmaEncontrada() {
		return turmaEncontrada;
	}
	public void setTurmaEncontrada(List<Turma> turmaEncontrada) {
		this.turmaEncontrada = turmaEncontrada;
	}
	
	public String getMatriculaProfessor() {
		return matriculaProfessor;
	}
	public void setMatriculaProfessor(String matriculaProfessor) {
		this.matriculaProfessor = matriculaProfessor;
	}
	public void criarTurma() {
		Turma t = new Turma();
		t.setNome(nome);
		t.setAlunos(null);
		t.setDisciplina(disciplina);
//		t.setProfessor(professorRepositorio.getProfessorByName(nomeProfessor));
//		t.setSala(salaRepositorio.read(nomeSala));
		turmaBean.criarTurma(t);
		//professorRepositorio.updateTurma(t);
	}
	
	
//	public List<Professor> getProfessores(){
//		return professorRepositorio.readAll();
//	}
	
	public List<Professor> getListarProfessores(){
		return turmaBean.listarProfessor();
	}
	
	public List<Sala> listarSalas(){
		return turmaBean.listarSalas();
	}
	
	public List<Turma> listarTurma(){
		
		return turmaBean.listarTurma();
	}
	
	
	public List<Aluno> buscarAlunos(){
		return null; //turmaBean.buscarAlunos();
	}
	
	public void excluirTurma(Turma t) {
		turmaBean.excluirTurma(t);
	}
	
	public void atualizarTurma() {
		this.turmaSelecionada.setNome(this.nome);
		this.turmaSelecionada.setDisciplina(disciplina);
		this.turmaSelecionada.setNomeProfessor(nomeProfessor);
		this.turmaSelecionada.setNomeSala(nomeSala);
		this.turmaSelecionada.setMatriculaProfessor(matriculaProfessor);
		this.turmaBean.atualizarTurma(this.turmaSelecionada);
	}
	
	public List<Turma> buscarTurma() {
		this.turmaEncontrada = turmaBean.buscarTurma(turmaSelecionada);
		return turmaEncontrada; 
	}
	
	public void editar() {
		if(turmaSelecionada!=null)
		nome = turmaSelecionada.getNome()+ "novo";
	}
	
	public Turma getTurmaSelecionada() {
		return turmaSelecionada;
	}
	public void setTurmaSelecionada(Turma turmaSelecionada) {
		this.turmaSelecionada = turmaSelecionada;
	}

}
