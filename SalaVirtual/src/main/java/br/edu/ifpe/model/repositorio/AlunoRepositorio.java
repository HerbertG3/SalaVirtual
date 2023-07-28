package br.edu.ifpe.model.repositorio;

import java.util.ArrayList;
import java.util.List;

import br.edu.ifpe.model.entity.Aluno;
import br.edu.ifpe.model.entity.Usuario;
import jakarta.ejb.Singleton;
import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;

@Singleton
public class AlunoRepositorio {
	
	@PersistenceContext(name = "salavirtual")
	protected EntityManager em;
	
	private List<Aluno> alunos = new ArrayList<Aluno>(); 
	
	public void create(Aluno a) {
		this.em.persist(a);
	}
	
	public List<Aluno> read(String nome) {
		List<Aluno> alunosEncontrados = new ArrayList<Aluno>();
		try {
			TypedQuery<Aluno> query = em.createQuery("SELECT u FROM Usuario u WHERE u.nome = :nome AND u.tipo = :tipo",
					Aluno.class);
			String tipo = "A";
			query.setParameter("nome", nome);
			query.setParameter("tipo", tipo);
			alunosEncontrados = query.getResultList();
			}catch (NoResultException nre) {
			// TODO: handle exception
		}
//		for (Aluno aux : this.alunos) {
//			if (aux.getCpf().equals(nome)) {
//				alunosEncontrados.add(aux);
//			}
//		}
		return alunosEncontrados;
	}
	
	public Aluno readAluno(String matricula) {
		Aluno alunoEncontrado = new Aluno();
		
		try{
			TypedQuery<Aluno> query = em.createQuery("SELECT u FROM Usuario u WHERE e.matricula = :matricula",
					Aluno.class);
			//String tipo = "A";
			alunoEncontrado = query.setParameter("matricula", matricula).getSingleResult();
			}catch (NoResultException nre) {
				// TODO: handle exception
			}
		
//		for (Aluno aux : this.alunos) {
//			if (aux.getMatricula().equals(matricula)) {
//				alunoEncontrado = aux;
//			}
//		}
		return alunoEncontrado;
	}

	public void update(Aluno a) {
		for (Aluno aux : this.alunos) {
			if (aux.getCpf().equals(a.getCpf())) {
				aux.setCpf(a.getCpf());
				aux.setNome(a.getNome());
				aux.setTurma(a.getTurma());
				aux.setMatricula(a.getMatricula());
				aux.setTipo(a.getTipo());
				return;
			}
		}
	}
	
	public void delete(Aluno a) {
		try{
			Query query = em.createQuery("DELETE FROM Usuario u WHERE u.id = :id");
			
			query.setParameter("id", a.getId()).executeUpdate();
			}catch (NoResultException nre) {
				// TODO: handle exception
			}
		//this.alunos.remove(a);
	}

	public List<Aluno> readAll() {
//		if(alunos!=null) {
//			return this.alunos;
//		}
		try{
			TypedQuery<Aluno> query = em.createQuery("SELECT e FROM Usuario e WHERE e.tipo IN (:alunos)",
					Aluno.class);
			String tipo = "A";
			this.alunos = query.setParameter("alunos", tipo).getResultList();
			}catch (NoResultException nre) {
				// TODO: handle exception
			}
			if(alunos!=null) {
				return this.alunos;
			}
		return null;
	}
}
