package br.com.decision.dao;

import javax.inject.Named;

import br.com.decision.entity.Topico;

/**
 * Classe de acesso a dados para a entidade Topico
 */
@Named
public class TopicoDAO extends BaseDAO<Topico> {

	private static final long serialVersionUID = 9008769859655078524L;

	@Override
	public String getSqlFullJoin() {
		final StringBuilder sql = new StringBuilder();
		sql.append(" SELECT topico FROM Topico topico ");
		sql.append(" JOIN FETCH topico.perguntas perguntas ");
		return sql.toString();
	}

}

