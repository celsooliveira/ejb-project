package br.com.decision.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * The persistent class for the formulario_item database table.
 *
 */
@Entity
@Table(name = "formulario_item")
public class FormularioItem extends BaseEntity implements Serializable {

	private static final long serialVersionUID = -2675244788379911097L;
	private Integer id;
	private Formulario formulario;
	private Topico topico;
	private Pergunta pergunta;

	@Override
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_formulario_item", unique = true)
	public Integer getId() {
		return this.id;
	}

	public void setId(final Integer id) {
		this.id = id;
	}

	@ManyToOne
	@JoinColumn(name = "id_formulario")
	public Formulario getFormulario() {
		return this.formulario;
	}

	public void setFormulario(final Formulario formulario) {
		this.formulario = formulario;
	}

	@ManyToOne
	@JoinColumn(name = "id_pergunta")
	public Pergunta getPergunta() {
		return this.pergunta;
	}

	public void setPergunta(final Pergunta pergunta) {
		this.pergunta = pergunta;
	}

	@ManyToOne
	@JoinColumn(name = "id_topico")
	public Topico getTopico() {
		return this.topico;
	}

	public void setTopico(final Topico topico) {
		this.topico = topico;
	}

}