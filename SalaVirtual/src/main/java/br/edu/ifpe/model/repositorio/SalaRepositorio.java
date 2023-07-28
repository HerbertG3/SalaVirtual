package br.edu.ifpe.model.repositorio;

import java.util.ArrayList;
import java.util.List;

import br.edu.ifpe.model.entity.Professor;
import br.edu.ifpe.model.entity.Sala;
import jakarta.ejb.Singleton;
import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;

@Singleton
public class SalaRepositorio {
	
	@PersistenceContext(name = "salavirtual")
	protected EntityManager em;

	private List<Sala> salas = new ArrayList<Sala>();

	public void create(Sala s) {
		this.em.persist(s);
	}

	public void update(Sala s) {
		for (Sala aux : this.salas) {
			if (aux.getCodigo() == (s.getCodigo())) {
				aux.setNome(s.getNome());
				aux.setLocal(s.getLocal());
				return;
			}
		}

	}

	public Sala read(String nomeSala) {
		for (Sala aux : this.salas) {
			if (aux.getNome().equals(nomeSala))
				return aux;
		}
		return null;
	}

	public void delete(Sala s) {
		this.salas.remove(s);
	}

	public List<Sala> readAll() {
		try{
			TypedQuery<Sala> query = em.createQuery("SELECT e FROM Sala e", Sala.class);
			this.salas = query.getResultList();
			}catch (NoResultException nre) {
				// TODO: handle exception
			}
		if(salas!=null) {
			return this.salas;
		}
		return null;
	}
}
