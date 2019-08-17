package br.com.decision.dao;

import java.util.Calendar;

import javax.inject.Named;
import javax.persistence.TypedQuery;

import br.com.decision.entity.AlunoAvaliacaoTurma;
import br.com.decision.entity.AvaliacaoResposta;


/**
 * Classe de acesso a dados para a entidade AvaliacaoResposta
 */
@Named
public class AvaliacaoRespostaDAO extends BaseDAO<AvaliacaoResposta> {

	private static final long serialVersionUID = -5232529271919550290L;

	@Override
	public String getSqlFullJoin() {
		final StringBuilder sql = new StringBuilder();
		sql.append(" SELECT avaliacaoResposta FROM AvaliacaoResposta avaliacaoResposta ");
		return sql.toString();
	}

	public void closeAvaliacaoResposta() {
		final StringBuilder sql = new StringBuilder();
		sql.append(" UPDATE AvaliacaoResposta avaliacaoResposta ");
		sql.append("    SET avaliacaoResposta.dtAlteracao = :CURRENT_DATE ");
		sql.append("  WHERE 1=1 ");
		sql.append("    AND avaliacaoResposta.alunoAvaliacaoTurma.concluida = :FALSE ");
		sql.append("    AND avaliacaoResposta.alunoAvaliacaoTurma.turma IN ( ");
		sql.append(" 		SELECT turma FROM Turma turma WHERE 1=1 ");
		sql.append(" 		   AND turma.dtFinalAvaliacao < :CURRENT_DATE ");
		sql.append("    )");

		final TypedQuery<AlunoAvaliacaoTurma> query = getEntityManager().createQuery(sql.toString(), AlunoAvaliacaoTurma.class);
		query.setParameter("FALSE", false);
		query.setParameter("CURRENT_DATE", Calendar.getInstance().getTime());
		query.executeUpdate();
	}

}