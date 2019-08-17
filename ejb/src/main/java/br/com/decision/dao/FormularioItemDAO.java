package br.com.decision.dao;

import javax.inject.Named;

import br.com.decision.entity.FormularioItem;

/**
 * Classe de acesso a dados para a entidade FormularioItem
 */
@Named
public class FormularioItemDAO extends BaseDAO<FormularioItem> {

	private static final long serialVersionUID = 974671696760495689L;

	@Override
	public String getSqlFullJoin() {
		final StringBuilder sql = new StringBuilder();
		sql.append(" SELECT formularioItem FROM FormularioItem formularioItem ");
		sql.append(" JOIN FETCH formularioItem.perguntas perguntas ");
		sql.append(" JOIN FETCH formularioItem.formulario formularios ");
		sql.append(" JOIN FETCH formularioItem.topico topicos ");
		return sql.toString();
	}

}

