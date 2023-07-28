package br.edu.ifpe.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import br.edu.ifpe.model.entity.Professor;
import br.edu.ifpe.model.entity.Sala;
import br.edu.ifpe.model.repositorio.SalaRepositorio;
import jakarta.ejb.EJB;
import jakarta.ejb.Stateful;


@Stateful
public class SalaBean implements Serializable {

	private static final long serialVersionUID = 9039977407691885866L;

	private List<Sala> salas = new ArrayList<Sala>();
	
	@EJB
	private SalaRepositorio salaRepositorio;
	
	public void criarSala(Sala s) {
		this.salas.add(s);
		salaRepositorio.create(s);
	}

	public List<String> getListarSalas() {
		List<String> salas = getListarNomesDasSalas();

		if (salas == null) {
			salas = new ArrayList<String>();
		}
		return salas;
	}

	private List<String> getListarNomesDasSalas() {
		List<String> nomeSala = new ArrayList<String>();

		for (Sala sala : this.salas) {
			nomeSala.add(sala.getNome());
		}

		return nomeSala;
	}
	
	public List<Sala>readAll(){
		
		return this.salaRepositorio.readAll();
	}
	
	public void excluirSala(Sala s) {
		salaRepositorio.delete(s);
	}
	
	public void atualizarSala(Sala s) {
		this.salaRepositorio.update(s);
	}
	
}
