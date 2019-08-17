package br.com.decision.service;

import java.io.Serializable;

import javax.ejb.Stateless;
import javax.inject.Inject;

import br.com.decision.dao.FormularioItemDAO;
import br.com.decision.entity.FormularioItem;


/**
 * Classe de Servico para a entidade FormularioItem
 */
@Stateless
public class FormularioItemService extends BaseService<FormularioItem> implements Serializable {

	private static final long serialVersionUID = 7832432029225002491L;

	@Inject
	private FormularioItemDAO dao;

	/** {@inheritDoc} */
	@Override
	protected FormularioItemDAO getDAO() {
		return dao;
	}

}


