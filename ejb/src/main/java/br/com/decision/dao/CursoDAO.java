package br.com.decision.dao;

import javax.inject.Named;

import br.com.decision.entity.Curso;


/**
 * Classe de acesso a dados para a entidade Curso
 */
@Named
public class CursoDAO extends BaseDAO<Curso> {

	private static final long serialVersionUID = 6773945474555702394L;

	@Override
	public String getSqlFullJoin() {
		final StringBuilder sql = new StringBuilder();
		sql.append(" SELECT curso FROM Curso curso ");
		sql.append(" JOIN FETCH curso.modulos modulos ");
		return sql.toString();
	}

}

