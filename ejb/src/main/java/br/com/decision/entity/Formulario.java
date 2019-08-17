package br.com.decision.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Classe para mapeamento da tabela "formulario"
 */
@Entity
@Table(name = "formulario")
public class Formulario extends BaseAuditableEntity implements Serializable {

	private static final long serialVersionUID = 6186688700163888362L;
	private Integer id;
	private String descricao;
//	private List<Pergunta> perguntas;
	private List<FormularioItem> formularioItems;
	private List<Turma> turmas;

	public Formulario() {
		super();
	}

	@Override
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_formulario", unique = true)
	public Integer getId() {
		return this.id;
	}

	public void setId(final Integer id) {
		this.id = id;
	}

	@Lob
	@Column(name = "descricao")
	public String getDescricao() {
		return this.descricao;
	}

	public void setDescricao(final String descricao) {
		this.descricao = descricao;
	}

//	@OneToMany(mappedBy = "formulario")
//	public List<Pergunta> getPerguntas() {
//		return this.perguntas;
//	}
//
//	public void setPerguntas(final List<Pergunta> perguntas) {
//		this.perguntas = perguntas;
//	}

	@OneToMany(mappedBy="formulario")
	public List<FormularioItem> getFormularioItems() {
		return formularioItems;
	}

	public void setFormularioItems(final List<FormularioItem> formularioItems) {
		this.formularioItems = formularioItems;
	}

	@OneToMany(mappedBy = "formulario")
	public List<Turma> getTurmas() {
		return this.turmas;
	}

	public void setTurmas(final List<Turma> turmas) {
		this.turmas = turmas;
	}

	@Override
	public String toString() {
		return "Formulario [id=" + id + ", descricao=" + descricao
//				+ ", perguntas=" + perguntas
				+ ", turmas=" + turmas + "]";
	}

}