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
 * Classe para mapeamento da tabela "pergunta"
 */
@Entity
@Table(name = "pergunta")
public class Pergunta extends BaseAuditableEntity implements Serializable {

	private static final long serialVersionUID = 9033284747444941543L;
	private Integer id;
	private boolean justificativa;
	private boolean objetiva;
	private String dsPergunta;
	private List<AvaliacaoResposta> avaliacaoRespostas;
//	private Formulario formulario;
//	private Topico topico;
	private List<FormularioItem> formularioItems;
	private List<Resposta> respostas;

	@Override
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_pergunta", unique = true)
	public Integer getId() {
		return this.id;
	}

	public void setId(final Integer id) {
		this.id = id;
	}

	@Column(name = "justificativa")
	public boolean getJustificativa() {
		return this.justificativa;
	}

	public void setJustificativa(final boolean justificativa) {
		this.justificativa = justificativa;
	}

	@Column(name = "objetiva")
	public boolean getObjetiva() {
		return this.objetiva;
	}

	public void setObjetiva(final boolean objetiva) {
		this.objetiva = objetiva;
	}

	@Column(name = "pergunta", length = 255)
	public String getDsPergunta() {
		return this.dsPergunta;
	}

	public void setDsPergunta(final String dsPergunta) {
		this.dsPergunta = dsPergunta;
	}

	@OneToMany(mappedBy = "pergunta")
	public List<AvaliacaoResposta> getAvaliacaoRespostas() {
		return this.avaliacaoRespostas;
	}

	public void setAvaliacaoRespostas(final List<AvaliacaoResposta> avaliacaoRespostas) {
		this.avaliacaoRespostas = avaliacaoRespostas;
	}

//	@ManyToOne(fetch = FetchType.LAZY)
//	@JoinColumn(name = "id_formulario")
//	public Formulario getFormulario() {
//		return this.formulario;
//	}
//
//	public void setFormulario(final Formulario formulario) {
//		this.formulario = formulario;
//	}
//
//	@ManyToOne(fetch = FetchType.LAZY)
//	@JoinColumn(name = "id_topico")
//	public Topico getTopico() {
//		return this.topico;
//	}
//
//	public void setTopico(final Topico topico) {
//		this.topico = topico;
//	}

	@OneToMany(mappedBy = "pergunta")
	public List<FormularioItem> getFormularioItems() {
		return formularioItems;
	}

	public void setFormularioItems(final List<FormularioItem> formularioItems) {
		this.formularioItems = formularioItems;
	}

	@OneToMany(mappedBy = "pergunta")
	public List<Resposta> getRespostas() {
		return this.respostas;
	}

	public void setRespostas(final List<Resposta> respostas) {
		this.respostas = respostas;
	}

//	@Override
//	public String toString() {
//		return "Pergunta [id=" + id + ", justificativa=" + justificativa
//				+ ", objetiva=" + objetiva + ", pergunta=" + dsPergunta
//				+ ", peso=" + peso + ", avaliacaoRespostas="
//				+ avaliacaoRespostas + ", formulario=" + formulario
//				+ ", topico=" + topico + ", respostas=" + respostas + "]";
//	}

}