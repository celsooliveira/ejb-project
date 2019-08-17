package br.com.decision.dao;

import javax.inject.Named;

import br.com.decision.entity.Resposta;

/**
 * Classe de acesso a dados para a entidade Resposta
 */
@Named
public class RespostaDAO extends BaseDAO<Resposta> {

	private static final long serialVersionUID = 4664718595011177705L;

	@Override
	public String getSqlFullJoin() {
		final StringBuilder sql = new StringBuilder();
		sql.append(" SELECT resposta FROM Resposta resposta");
//		sql.append(" JOIN FETCH resposta.avaliacaoRespostas avaliacaoRespostas ");
		sql.append(" JOIN FETCH resposta.pergunta pergunta ");
		return sql.toString();
	}

}

