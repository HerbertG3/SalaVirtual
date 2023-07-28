package br.edu.ifpe.model.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
@DiscriminatorValue("A")
public class Aluno extends Usuario{

	private Turma turma = new Turma();

	@ManyToOne
	@JoinColumn(name="TURMA_ID")
	public Turma getTurma() {
		return turma;
	}

	public void setTurma(Turma turma) {
		this.turma = turma;
	}
	
}
