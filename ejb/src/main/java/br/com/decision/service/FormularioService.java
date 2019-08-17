package br.com.decision.service;

import java.io.Serializable;

import javax.ejb.Stateless;
import javax.inject.Inject;

import br.com.decision.dao.FormularioDAO;
import br.com.decision.entity.Formulario;


/**
 * Classe de Servico para a entidade Formulario
 */
@Stateless
public class FormularioService extends BaseService<Formulario> implements Serializable {

	private static final long serialVersionUID = 3266444630134549182L;

	@Inject
	private FormularioDAO dao;

	/** {@inheritDoc} */
	@Override
	protected FormularioDAO getDAO() {
		return dao;
	}

}


