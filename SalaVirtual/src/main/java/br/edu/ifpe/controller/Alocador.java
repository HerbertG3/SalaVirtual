package br.edu.ifpe.controller;

import java.util.List;

import br.edu.ifpe.model.ProfessorBean;
import br.edu.ifpe.model.TurmaBean;
import br.edu.ifpe.model.entity.Professor;
import br.edu.ifpe.model.entity.Turma;
import jakarta.ejb.EJB;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Named;

@RequestScoped
@Named("alocadorMB")
public class Alocador {

	@EJB
	ProfessorBean pBean;
	@EJB
	TurmaBean tBean;

	private String matricula;
	private Integer id;
	private Professor p = new Professor();
	private Turma t = new Turma();

	public void alocar() {
		alocarProfessor(matricula, id);
	}

	public void alocarProfessor(String matricula, Integer id_turma) {
		p = pBean.buscarMatricula(matricula);
		t = tBean.buscarId(id_turma);

		if (p != null && t != null) {
			t.setProfessor(p);
			t.setNomeProfessor(t.getProfessor().getNome());
			t.setMatriculaProfessor(t.getProfessor().getMatricula());
			tBean.atualizarTurma(t);
		}
	}

	public List<Turma> listarAlocacoes() {

		return tBean.listarTurmaComProfessor();
	}
	
	public List<Turma> listarTurma() {

		return tBean.listarTurma();
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Professor getP() {
		return p;
	}

	public void setP(Professor p) {
		this.p = p;
	}

	public Turma getT() {
		return t;
	}

	public void setT(Turma t) {
		this.t = t;
	}

}
