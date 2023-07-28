package br.edu.ifpe.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import br.edu.ifpe.model.SalaBean;
import br.edu.ifpe.model.entity.Sala;
import br.edu.ifpe.model.repositorio.SalaRepositorio;
import jakarta.ejb.EJB;
import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Named;

@Named("salaMB")
@SessionScoped
public class SalaMB implements Serializable {

	private static final long serialVersionUID = 1L;

	@EJB
	private SalaBean salaBean;
	
	@EJB
	private SalaRepositorio salaRepositorio;

	private String nome;
	private String local;
	private int codigo;
		
	private Sala salaSelecionada = new Sala();

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}	

	public String getLocal() {
		return local;
	}

	public void setLocal(String local) {
		this.local = local;
	}

	/*
	 * public Sala getSala() { return sala; }
	 * 
	 * public void setSala(Sala s) { this.sala = s; }
	 */

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public void criarSala() {
		Sala sala = new Sala();
		sala.setNome(nome);
		sala.setLocal(local);
		sala.setCodigo(codigo);

		salaBean.criarSala(sala);

	}

	public List<Sala> getSalas() {
		return salaBean.readAll();

	}
	
	public void excluirSala(Sala s) {
		salaRepositorio.delete(s);
	}
	
	public void atualizarSala() {
		this.salaSelecionada.setNome(this.nome);
		this.salaSelecionada.setCodigo(codigo);
		this.salaBean.atualizarSala(this.salaSelecionada);
	}
	
	public Sala getSalaSelecionada() {
		return salaSelecionada;
	}

	public void setSalaSelecionada(Sala salaSelecionada) {
		this.salaSelecionada = salaSelecionada;
	}

}
