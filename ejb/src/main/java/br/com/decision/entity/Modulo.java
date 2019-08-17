package br.com.decision.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Classe para mapeamento da tabela "modulo"
 */
@Entity
@Table(name = "modulo")
public class Modulo extends BaseAuditableEntity implements Serializable {

	private static final long serialVersionUID = 1351099804543933142L;
	private Integer id;
	private String nome;
	private List<Curso> cursos;
	private List<Turma> turmas;

	public Modulo() {
		super();
	}

	@Override
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_modulo", unique = true)
	public Integer getId() {
		return this.id;
	}

	public void setId(final Integer id) {
		this.id = id;
	}

	@Column(name = "nome", length = 255)
	public String getNome() {
		return this.nome;
	}

	public void setNome(final String nome) {
		this.nome = nome;
	}

	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "curso_modulo",
			joinColumns = { @JoinColumn(name = "id_curso") },
	 inverseJoinColumns = { @JoinColumn(name = "id_modulo") })
	public List<Curso> getCursos() {
		return this.cursos;
	}

	public void setCursos(final List<Curso> cursos) {
		this.cursos = cursos;
	}

	@OneToMany(mappedBy = "modulo")
	public List<Turma> getTurmas() {
		return this.turmas;
	}

	public void setTurmas(final List<Turma> turmas) {
		this.turmas = turmas;
	}

	@Override
	public String toString() {
		return "Modulo [id=" + id + ", nome=" + nome + ", cursos=" + cursos
				+ ", turmas=" + turmas + "]";
	}

}