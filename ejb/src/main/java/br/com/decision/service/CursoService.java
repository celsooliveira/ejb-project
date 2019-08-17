package br.com.decision.service;

import java.io.Serializable;

import javax.ejb.Stateless;
import javax.inject.Inject;

import br.com.decision.dao.CursoDAO;
import br.com.decision.entity.Curso;


/**
 * Classe de Servico para a entidade Curso
 */
@Stateless
public class CursoService extends BaseService<Curso> implements Serializable {

	private static final long serialVersionUID = -7985780653814894377L;

	@Inject
	private CursoDAO dao;

	/** {@inheritDoc} */
	@Override
	protected CursoDAO getDAO() {
		return dao;
	}

}

