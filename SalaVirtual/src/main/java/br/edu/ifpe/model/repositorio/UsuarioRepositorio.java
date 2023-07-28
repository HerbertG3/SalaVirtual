package br.edu.ifpe.model.repositorio;

import java.util.ArrayList;
import java.util.List;

import br.edu.ifpe.model.entity.Usuario;
import jakarta.ejb.Singleton;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Singleton
public class UsuarioRepositorio {
	
	@PersistenceContext(name = "salavirtual")
	protected EntityManager em;
	
	private List<Usuario> usuarios = new ArrayList<Usuario>(); 

	
	public void add(Usuario u) {
		this.em.persist(u);
	}


	public List<Usuario> getUsuarios() {
		return this.usuarios;
	}
}
