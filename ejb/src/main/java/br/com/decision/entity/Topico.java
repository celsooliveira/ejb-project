package br.com.decision.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Classe para mapeamento da tabela "topico"
 */
@Entity
@Table(name = "topico")
public class Topico extends BaseAuditableEntity implements Serializable {

	private static final long serialVersionUID = 3094323784750298368L;
	private Integer id;
	private String descricao;
//	private List<Pergunta> perguntas;
	private List<FormularioItem> formularioItems;

	public Topico() {
		super();
	}

	@Override
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_topico", unique = true)
	public Integer getId() {
		return this.id;
	}

	public void setId(final Integer id) {
		this.id = id;
	}

	@Column(name = "descricao", length = 45)
	public String getDescricao() {
		return this.descricao;
	}

	public void setDescricao(final String descricao) {
		this.descricao = descricao;
	}

	@OneToMany(mappedBy="topico")
	public List<FormularioItem> getFormularioItems() {
		return formularioItems;
	}

	public void setFormularioItems(final List<FormularioItem> formularioItems) {
		this.formularioItems = formularioItems;
	}

//	@OneToMany(mappedBy = "topico")
//	public List<Pergunta> getPerguntas() {
//		return this.perguntas;
//	}
//
//	public void setPerguntas(final List<Pergunta> perguntas) {
//		this.perguntas = perguntas;
//	}

	@Override
	public String toString() {
		return "Topico [id=" + id + ", descricao=" + descricao
//				+ ", perguntas=" + perguntas
				+ "]";
	}

}