package br.com.decision.dao;

import java.util.List;

import javax.inject.Named;
import javax.persistence.TypedQuery;

import br.com.decision.criteria.PerguntaCriteria;
import br.com.decision.entity.Pergunta;

/**
 * Classe de acesso a dados para a entidade Pergunta
 */
@Named
public class PerguntaDAO extends BaseDAO<Pergunta> {

	private static final long serialVersionUID = -7931045838816071471L;

	@Override
	public String getSqlFullJoin() {
		final StringBuilder sql = new StringBuilder();
		sql.append(" SELECT pergunta FROM Pergunta pergunta ");
//		sql.append(" JOIN FETCH pergunta.avaliacaoRespostas avaliacaoRespostas ");
		sql.append(" JOIN FETCH pergunta.formulario formulario ");
		sql.append(" JOIN FETCH pergunta.topico topico ");
//		sql.append(" JOIN FETCH pergunta.respostas respostas ");
		return sql.toString();
	}

	public List<Pergunta> searchSourceByCriteria(final PerguntaCriteria criteria) {
		final StringBuilder sql = new StringBuilder();
		sql.append("SELECT pergunta FROM Pergunta pergunta WHERE 1=1 ");
		if (criteria.getIds() != null && !criteria.getIds().isEmpty()) {
			sql.append("   AND pergunta.id NOT IN :perguntasId ");
		}
		final TypedQuery<Pergunta> query = getEntityManager().createQuery(sql.toString(), Pergunta.class);
		if (criteria.getIds() != null && !criteria.getIds().isEmpty()) {
			query.setParameter("perguntasId", criteria.getIds());
		}
		return query.getResultList();
	}

	public List<Pergunta> searchTargetByCriteria(final PerguntaCriteria criteria) {
		final StringBuilder sql = new StringBuilder();
		sql.append("SELECT pergunta FROM Pergunta pergunta WHERE 1=1 ");
		sql.append("   AND pergunta.id IN :perguntasId ");
		final TypedQuery<Pergunta> query = getEntityManager().createQuery(sql.toString(), Pergunta.class);
		query.setParameter("perguntasId", criteria.getIds());
		return query.getResultList();
	}

}

