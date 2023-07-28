package br.edu.ifpe.model.repositorio;

import java.util.ArrayList;
import java.util.List;

import br.edu.ifpe.model.entity.Aluno;
import br.edu.ifpe.model.entity.Professor;
import jakarta.ejb.Singleton;
import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;

@Singleton
public class ProfessorRepositorio {
	
	@PersistenceContext(name = "salavirtual")
	protected EntityManager em;
	
	private List<Professor>professores = new ArrayList<Professor>();
	
	public void create(Professor p) {
		this.em.persist(p);
	}

	public List<Professor> read(String nome) {
		
		List<Professor> professoresEncontrados = new ArrayList<Professor>(); 
		for (Professor aux : this.professores) {
			if (aux.getCpf().equals(nome)) {
				professoresEncontrados.add(aux);
			}
		}
		return professoresEncontrados;
	}
	
public Professor buscarMatricula(String matricula) {
		Professor p = new Professor();
		for (Professor aux : this.professores) {
			if (aux.getMatricula().equals(matricula)) {
				p = aux;
			}
		}
		return p;
	}
	
	public void update(Professor p) {
		for (Professor aux : this.professores) {
			if (aux.getCpf().equals(p.getCpf())) {
				aux.setCpf(p.getCpf());
				aux.setNome(p.getNome());
				aux.setDepartamento(p.getDepartamento());
				aux.setDisciplina(p.getDisciplina());
				aux.setEmail(p.getEmail());
				aux.setMatricula(p.getMatricula());
				aux.setTelefone(p.getTelefone());
				aux.setTipo(p.getTipo());
				return;
			}
		}
	}

	public void delete(Professor p) {
		this.professores.remove(p);
	}

	public List<Professor> readAll() {
		try{
		TypedQuery<Professor> query = em.createQuery("SELECT e FROM Usuario e WHERE e.tipo IN (:prof)",
				Professor.class);
		String tipo = "P";
		this.professores = query.setParameter("prof", tipo).getResultList();
		}catch (NoResultException nre) {
			// TODO: handle exception
		}
		if(professores!=null) {
			return this.professores;
		}
		return null;
	}

	public Professor getProfessorByName(String name) {
		
		Professor p = new Professor();
		return p;
	}

	public Professor nomeProfessor(String nome) {
		Professor p = new Professor();
		return p;
	}
}
