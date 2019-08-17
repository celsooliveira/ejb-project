package br.com.decision.dao;

import javax.inject.Named;

import br.com.decision.entity.Formulario;

/**
 * Classe de acesso a dados para a entidade Formulario
 */
@Named
public class FormularioDAO extends BaseDAO<Formulario> {

	private static final long serialVersionUID = 16010934486585492L;

	@Override
	public String getSqlFullJoin() {
		final StringBuilder sql = new StringBuilder();
		sql.append(" SELECT formulario FROM Formulario formulario ");
		sql.append(" JOIN FETCH formulario.perguntas perguntas ");
		sql.append(" JOIN FETCH formulario.turmas turmas ");
		return sql.toString();
	}

}

