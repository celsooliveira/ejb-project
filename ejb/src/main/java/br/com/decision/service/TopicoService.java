package br.com.decision.service;

import java.io.Serializable;

import javax.ejb.Stateless;
import javax.inject.Inject;

import br.com.decision.dao.TopicoDAO;
import br.com.decision.entity.Topico;



/**
 * Classe de Servico para a entidade Topico
 */
@Stateless
public class TopicoService extends BaseService<Topico> implements Serializable {

	private static final long serialVersionUID = -2727335698084409427L;

	@Inject
	private TopicoDAO dao;

	/** {@inheritDoc} */
	@Override
	protected TopicoDAO getDAO() {
		return dao;
	}

}


