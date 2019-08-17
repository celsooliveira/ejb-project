package br.com.decision.service;

import java.io.Serializable;
import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import br.com.decision.criteria.TurmaCriteria;
import br.com.decision.dao.TurmaDAO;
import br.com.decision.entity.Turma;


/**
 * Classe de Servico para a entidade Turma
 */
@Stateless
public class TurmaService extends BaseService<Turma> implements Serializable {

	private static final long serialVersionUID = -7985780653814894377L;

	@Inject
	private TurmaDAO dao;

	/** {@inheritDoc} */
	@Override
	protected TurmaDAO getDAO() {
		return dao;
	}

	public List<Turma> searchSourceByCriteria(final TurmaCriteria criteria) {
		return dao.searchSourceByCriteria(criteria);
	}

	public List<Turma> searchTargetByCriteria(final TurmaCriteria criteria) {
		return dao.searchTargetByCriteria(criteria);
	}

	/**
	 * Busca a lista das turmas que ainda não tiveram seus registros de avaliação gerados
	 * @return List<Turma>
	 */
	public List<Turma> searchTurmasPendentes() {
		return dao.searchTurmasPendentes();
	}

}


