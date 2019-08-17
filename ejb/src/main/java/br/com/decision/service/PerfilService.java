package br.com.decision.service;

import java.io.Serializable;

import javax.ejb.Stateless;
import javax.inject.Inject;

import br.com.decision.dao.PerfilDAO;
import br.com.decision.entity.Perfil;



/**
 * Classe de Servico para a entidade Perfil
 */
@Stateless
public class PerfilService extends BaseService<Perfil> implements Serializable {

	private static final long serialVersionUID = -3179831389551797198L;

	@Inject
	private PerfilDAO dao;

	/** {@inheritDoc} */
	@Override
	protected PerfilDAO getDAO() {
		return dao;
	}

}