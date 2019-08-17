package br.com.decision.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Classe para mapeamento da tabela "resposta"
 */
@Entity
@Table(name = "resposta")
public class Resposta extends BaseAuditableEntity implements Serializable {

	private static final long serialVersionUID = -8510769462272800113L;
	private Integer id;
	private String texto;
	private Integer resposta;
	private List<AvaliacaoResposta> avaliacaoRespostas;
	private Pergunta pergunta;

	public Resposta() {
		super();
	}

	@Override
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_resposta", unique = true)
	public Integer getId() {
		return this.id;
	}

	public void setId(final Integer id) {
		this.id = id;
	}

	@Column(length = 255)
	public String getTexto() {
		return this.texto;
	}

	public void setTexto(final String texto) {
		this.texto = texto;
	}

	@Column(name = "resposta")
	public Integer getResposta() {
		return this.resposta;
	}

	public void setResposta(final Integer resposta) {
		this.resposta = resposta;
	}

	@OneToMany(mappedBy = "resposta")
	public List<AvaliacaoResposta> getAvaliacaoRespostas() {
		return this.avaliacaoRespostas;
	}

	public void setAvaliacaoRespostas(final List<AvaliacaoResposta> avaliacaoRespostas) {
		this.avaliacaoRespostas = avaliacaoRespostas;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_pergunta")
	public Pergunta getPergunta() {
		return this.pergunta;
	}

	public void setPergunta(final Pergunta pergunta) {
		this.pergunta = pergunta;
	}

	@Override
	public String toString() {
		return "Resposta [id=" + id + ", texto=" + texto + ", resposta="
				+ resposta + ", avaliacaoRespostas=" + avaliacaoRespostas
				+ ", pergunta=" + pergunta + "]";
	}

}