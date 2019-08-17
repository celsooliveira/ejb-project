package br.com.decision.service;

import java.io.Serializable;

import javax.ejb.Stateless;
import javax.inject.Inject;

import br.com.decision.dao.AvaliacaoRespostaDAO;
import br.com.decision.entity.AvaliacaoResposta;


/**
 * Classe de Servico para a entidade Curso
 */
@Stateless
public class AvaliacaoRespostaService extends BaseService<AvaliacaoResposta> implements Serializable {

	private static final long serialVersionUID = -3669869154240855170L;

	@Inject
	private AvaliacaoRespostaDAO dao;

	/** {@inheritDoc} */
	@Override
	protected AvaliacaoRespostaDAO getDAO() {
		return dao;
	}

	public void closeAvaliacaoResposta() {
		dao.closeAvaliacaoResposta();
	}

}