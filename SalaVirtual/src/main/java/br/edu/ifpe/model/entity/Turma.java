package br.edu.ifpe.model.entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;


@Entity
public class Turma {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private String nome;
	
	@OneToMany
	private List<Aluno>alunos = new ArrayList<Aluno>();
	
	@ManyToOne
	@JoinColumn(name = "SALA_ID")
	private Sala sala;
	
	@OneToOne
	@JoinColumn(name = "PROFESSOR_ID")
	private Professor professor;
	private String disciplina;
	private String nomeProfessor;
	private String nomeSala;
	private String matriculaProfessor;
	
	public String getNomeProfessor() {
		return nomeProfessor;
	}
	public void setNomeProfessor(String nomeProfessor) {
		this.nomeProfessor = nomeProfessor;
	}
	public String getNomeSala() {
		return nomeSala;
	}
	public void setNomeSala(String nomeSala) {
		this.nomeSala = nomeSala;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getDisciplina() {
		return disciplina;
	}
	public void setDisciplina(String disciplina) {
		this.disciplina = disciplina;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getMatriculaProfessor() {
		return matriculaProfessor;
	}
	public void setMatriculaProfessor(String matriculaProfessor) {
		this.matriculaProfessor = matriculaProfessor;
	}
	public List<Aluno> getAlunos() {
		return alunos;
	}
	
	
	public void setAlunos(List<Aluno> alunos) {
		this.alunos = alunos;
	}
	
	
	public Professor getProfessor() {
		return professor;
	}
	public void setProfessor(Professor professor) {
		this.professor = professor;
	}
	
	public Sala getSala() {
		return sala;
	}
	public void setSala(Sala sala) {
		this.sala = sala;
	}
	
	
}
