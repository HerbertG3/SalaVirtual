package br.edu.ifpe.controller;

import java.util.ArrayList;
import java.util.List;

import br.edu.ifpe.model.AlunoBean;
import br.edu.ifpe.model.UsuarioBean;
import br.edu.ifpe.model.entity.Aluno;
import br.edu.ifpe.model.entity.Usuario;
import jakarta.ejb.EJB;
import jakarta.enterprise.context.RequestScoped;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import jakarta.inject.Named;

@RequestScoped
@Named
public class AlunoMB {

	@EJB
	private AlunoBean alunoBean;
	
	private String nome;
	private String cpf;
	private String matricula;
	private String msg = "";
	
	private Aluno alunoSelecionado = new Aluno();
	private List<Aluno> alunoEncontrado = new ArrayList<Aluno>();

	private Aluno a = new Aluno();
	
	public void inserirAluno() {
		a.setTipo("A");
		a.setNome(this.nome);
		a.setCpf(this.cpf);
		a.setMatricula(this.matricula);
		a.setTurma(null);
		
		this.alunoBean.adicionarAluno(a);
		mensagem();
	}
	
	public void atualizarAluno() {
		this.alunoSelecionado.setNome(this.nome);
		this.alunoSelecionado.setCpf(this.cpf);
		this.alunoBean.atualizarAluno(this.alunoSelecionado);
	}
	
	public List<Aluno> buscarAluno() {
		
		this.alunoEncontrado = alunoBean.buscarAluno(this.nome);
		for(Aluno aux:alunoEncontrado) {
			if(aux.getMatricula().equals(getMatricula()))
					msg = aux.getNome();					
		}
		return alunoEncontrado; 
	}
	
	public List<Aluno>getBuscarAlunos() {
		return alunoBean.readAll();
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


	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}
	
	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public Aluno getA() {
		return a;
	}

	public void setA(Aluno a) {
		this.a = a;
	}
	
	public List<Aluno> getAlunoEncontrado() {
		return alunoEncontrado;
	}

	public void setAlunoEncontrado(List<Aluno> alunoEncontrado) {
		this.alunoEncontrado = alunoEncontrado;
	}

	public void editar() {
		if(alunoSelecionado!=null)
		nome = alunoSelecionado.getNome()+ "novo";
	}
	public Aluno getAlunoSelecionado() {
		return alunoSelecionado;
	}
	public void setAlunoSelecionado(Aluno alunoSelecionado) {
		this.alunoSelecionado = alunoSelecionado;
	}
	
	public void excluirAluno(Aluno a) {
		alunoBean.excluirAluno(a);
	}
	
	public String nomeTurma() {
		if(alunoSelecionado.getTurma()!= null)
		return alunoSelecionado.getTurma().getNome();
		
		return "Sem turma";
	}
	
	public Aluno lerAluno() {
		return alunoBean.buscarMatriculaAluno(getAlunoSelecionado().getMatricula());
	}
	
	public void mensagem() {
		buscarAluno();
		if(alunoEncontrado!=null)
		FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(msg+" Cadastrado com sucesso!") );
	}
}
