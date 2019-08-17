package br.com.decision.dto;

import java.io.Serializable;

import javax.enterprise.context.Dependent;

/**
 * Classe DTO para representação da entidade Avaliacao
 * @author Celso Oliveira
 */
@Dependent
public class AvaliacaoDTO implements Serializable {

	private static final long serialVersionUID = 9017520973023824490L;
	private Integer id;
	private String descricao;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

}
