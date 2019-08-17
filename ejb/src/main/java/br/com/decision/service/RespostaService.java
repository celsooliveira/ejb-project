package br.com.decision.service;

import java.io.Serializable;

import javax.ejb.Stateless;
import javax.inject.Inject;

import br.com.decision.dao.RespostaDAO;
import br.com.decision.entity.Resposta;


/**
 * Classe de Servico para a entidade Resposta
 */
@Stateless
public class RespostaService extends BaseService<Resposta> implements Serializable {

	private static final long serialVersionUID = -2265153085920662096L;

	@Inject
	private RespostaDAO dao;

	/** {@inheritDoc} */
	@Override
	protected RespostaDAO getDAO() {
		return dao;
	}

}
