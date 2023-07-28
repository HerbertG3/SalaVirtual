package br.edu.ifpe.model.repositorio;

import java.util.ArrayList;
import java.util.List;

import br.edu.ifpe.model.entity.Sala;
import br.edu.ifpe.model.entity.Turma;
import jakarta.ejb.Singleton;
import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;

@Singleton
public class TurmaRepositorio {
	
	@PersistenceContext(name = "salavirtual")
	protected EntityManager em;

	private List<Turma> turmas = new ArrayList<Turma>();

	public void create(Turma t) {
		this.em.persist(t);
	}

	public void update(Turma t) {

		for (Turma aux : this.turmas) {
			if (aux.getNome().equals(t.getNome())) {

				aux.setAlunos(t.getAlunos());
				aux.setNome(t.getNome());
				return;

			}
		}

	}

	public List<Turma> read(String nome) {
		List<Turma> turmasEncontradas = new ArrayList<Turma>();
		for(Turma aux:this.turmas) {
			if(aux.getNome().equals(nome)) {
				turmasEncontradas.add(aux);
			}			
		}

		if (turmasEncontradas != null) {
			return turmasEncontradas;
		}
		return null;
	}

	public void delete(Turma t) {
		this.turmas.remove(t);
	}

	public List<Turma> readAll() {
		try{
			TypedQuery<Turma> query = em.createQuery("SELECT e FROM Turma e",
					Turma.class);
			this.turmas = query.getResultList();
			}catch (NoResultException nre) {
				// TODO: handle exception
			}
		if (turmas != null) {
			return this.turmas;
		}
		return null;

	}

	public Turma buscarId(Integer id) {
		Turma turma = new Turma();
		for(Turma aux:this.turmas) {
			if(aux.getId().equals(id)) {
				turma = aux;
			}			
		}
		return turma;
	}
	
	public List<Turma> readProfessor() {
		List<Turma> turma = new ArrayList<Turma>();
		for(Turma aux:this.turmas) {
			if(aux.getNomeProfessor()!= null) {
				turma.add(aux);
			}			
		}
		return turma;
	}

}
