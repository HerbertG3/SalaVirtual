package br.edu.ifpe.controller;

import java.util.List;

import br.edu.ifpe.model.UsuarioBean;
import br.edu.ifpe.model.entity.Usuario;
import jakarta.ejb.EJB;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Named;

@RequestScoped
@Named
public class UsuarioMB {

	@EJB
	private UsuarioBean usuarioBean;
	
	private String nome;
	private String cpf;
	private String matricula;
	private String tipo;
	
	public void inserirUsuario() {
		Usuario u = new Usuario();
		u.setNome(this.nome);
		u.setCpf(this.cpf);
		u.setMatricula(this.matricula);
		
		this.usuarioBean.adicionarUsuario(u);
	}
	
	public List<Usuario> buscarUsuarios() {
		return usuarioBean.getUsuarios();
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

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
	
	
}
