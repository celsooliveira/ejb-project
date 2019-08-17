package br.com.decision.service;

import java.io.Serializable;
import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import br.com.decision.criteria.PerguntaCriteria;
import br.com.decision.dao.PerguntaDAO;
import br.com.decision.entity.Pergunta;


/**
 * Classe de Servico para a entidade Pergunta
 */
@Stateless
public class PerguntaService extends BaseService<Pergunta> implements Serializable {

	private static final long serialVersionUID = -8842642766223472362L;

	@Inject
	private PerguntaDAO dao;

	/** {@inheritDoc} */
	@Override
	protected PerguntaDAO getDAO() {
		return dao;
	}

	public List<Pergunta> searchSourceByCriteria(final PerguntaCriteria criteria) {
		return dao.searchSourceByCriteria(criteria);
	}

	public List<Pergunta> searchTargetByCriteria(final PerguntaCriteria criteria) {
		return dao.searchTargetByCriteria(criteria);
	}


}
