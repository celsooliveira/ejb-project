package br.com.decision.service;

import java.io.Serializable;
import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import br.com.decision.criteria.ModuloCriteria;
import br.com.decision.dao.ModuloDAO;
import br.com.decision.entity.Modulo;


/**
 * Classe de Servico para a entidade Modulo
 */
@Stateless
public class ModuloService extends BaseService<Modulo> implements Serializable {

	private static final long serialVersionUID = 7605822746717223782L;

	@Inject
	private ModuloDAO dao;

	/** {@inheritDoc} */
	@Override
	protected ModuloDAO getDAO() {
		return dao;
	}

	public List<Modulo> searchSourceByCriteria(final ModuloCriteria criteria) {
		return dao.searchSourceByCriteria(criteria);
	}

	public List<Modulo> searchTargetByCriteria(final ModuloCriteria criteria) {
		return dao.searchTargetByCriteria(criteria);
	}

}


