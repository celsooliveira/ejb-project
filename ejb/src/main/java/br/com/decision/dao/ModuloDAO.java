package br.com.decision.dao;

import java.util.List;

import javax.inject.Named;
import javax.persistence.TypedQuery;

import br.com.decision.criteria.ModuloCriteria;
import br.com.decision.entity.Modulo;

/**
 * Classe de acesso a dados para a entidade Modulo
 */
@Named
public class ModuloDAO extends BaseDAO<Modulo> {

	private static final long serialVersionUID = 6041592146929210312L;

	@Override
	public String getSqlFullJoin() {
		final StringBuilder sql = new StringBuilder();
		sql.append(" SELECT modulo FROM Modulo modulo ");
		sql.append(" JOIN FETCH modulo.turmas turmas ");
		return sql.toString();
	}

	public List<Modulo> searchSourceByCriteria(final ModuloCriteria criteria) {
		final StringBuilder sql = new StringBuilder();
		sql.append("SELECT modulo FROM Modulo modulo WHERE 1=1 ");
		if (criteria.getIds() != null && !criteria.getIds().isEmpty()) {
			sql.append("   AND modulo.id NOT IN :modulosId ");
		}
		final TypedQuery<Modulo> query = getEntityManager().createQuery(sql.toString(), Modulo.class);
		if (criteria.getIds() != null && !criteria.getIds().isEmpty()) {
			query.setParameter("modulosId", criteria.getIds());
		}
		return query.getResultList();
	}

	public List<Modulo> searchTargetByCriteria(final ModuloCriteria criteria) {
		final StringBuilder sql = new StringBuilder();
		sql.append("SELECT modulo FROM Modulo modulo WHERE 1=1 ");
		sql.append("   AND modulo.id IN :modulosId ");
		final TypedQuery<Modulo> query = getEntityManager().createQuery(sql.toString(), Modulo.class);
		query.setParameter("modulosId", criteria.getIds());
		return query.getResultList();
	}

}

