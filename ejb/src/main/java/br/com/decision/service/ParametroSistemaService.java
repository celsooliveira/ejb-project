package br.com.decision.service;

import java.io.Serializable;

import javax.ejb.Stateless;
import javax.inject.Inject;

import br.com.decision.dao.ParametroSistemaDAO;
import br.com.decision.entity.ParametroSistema;


/**
 * Classe de Servico para a entidade ParametroSistema
 */
@Stateless
public class ParametroSistemaService extends BaseService<ParametroSistema> implements Serializable {

	private static final long serialVersionUID = -7985780653814894377L;

	@Inject
	private ParametroSistemaDAO dao;

	/** {@inheritDoc} */
	@Override
	protected ParametroSistemaDAO getDAO() {
		return dao;
	}

	public ParametroSistema searchExportDir() {
		return dao.searchExportDir();
	}

}


