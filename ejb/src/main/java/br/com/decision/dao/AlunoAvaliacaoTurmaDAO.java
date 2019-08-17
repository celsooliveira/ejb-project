package br.com.decision.dao;

import java.util.Calendar;
import java.util.List;

import javax.inject.Named;
import javax.persistence.TypedQuery;

import br.com.decision.entity.AlunoAvaliacaoTurma;
import br.com.decision.utils.DateUtils;


/**
 * Classe de acesso a dados para a entidade AlunoAvaliacaoTurma
 */
@Named
public class AlunoAvaliacaoTurmaDAO extends BaseDAO<AlunoAvaliacaoTurma> {

	private static final long serialVersionUID = -6305912218664545214L;

	@Override
	public String getSqlFullJoin() {
		final StringBuilder sql = new StringBuilder();
		sql.append(" SELECT alunoAvaliacaoTurma FROM AlunoAvaliacaoTurma alunoAvaliacaoTurma ");
		sql.append(" JOIN FETCH alunoAvaliacaoTurma.turma turma ");
		sql.append(" JOIN FETCH alunoAvaliacaoTurma.usuario usuario ");
		return sql.toString();
	}

	/**
	 * Busca determinada avaliação a partir do id da turma e do aluno
	 * @param alunoId Id do Aluno
	 * @param turmaId Id da Turma
	 * @return
	 */
	public AlunoAvaliacaoTurma searchAlunoAvaliacaoTurma(final Integer alunoId, final Integer turmaId) {
		final StringBuilder sql = new StringBuilder();
		sql.append(" SELECT DISTINCT alunoAvaliacaoTurma FROM AlunoAvaliacaoTurma alunoAvaliacaoTurma ");
		sql.append("   JOIN FETCH alunoAvaliacaoTurma.turma turma ");
		sql.append("   JOIN FETCH alunoAvaliacaoTurma.aluno aluno ");
		sql.append("   JOIN FETCH alunoAvaliacaoTurma.avaliacaoRespostas avaliacaoRespostas ");
		sql.append("   JOIN FETCH avaliacaoRespostas.pergunta pergunta ");
		sql.append("   JOIN FETCH pergunta.formularioItems formulariosItems ");
		sql.append("   JOIN FETCH avaliacaoRespostas.resposta resposta ");
		sql.append("  WHERE 1=1 ");
		sql.append("    AND aluno.id = :alunoId ");
		sql.append("    AND turma.id = :turmaId ");

		final TypedQuery<AlunoAvaliacaoTurma> query = getEntityManager().createQuery(sql.toString(), AlunoAvaliacaoTurma.class);
		query.setParameter("alunoId", alunoId);
		query.setParameter("turmaId", turmaId);
		return query.getSingleResult();
	}

	/**
	 * Busca lista de avaliações para exportação
	 * @return List<AlunoAvaliacaoTurma>
	 */
	public List<AlunoAvaliacaoTurma> searchAlunoAvaliacaoTurmaToExport() {
		final StringBuilder sql = new StringBuilder();
		sql.append(" SELECT DISTINCT alunoAvaliacaoTurma FROM AlunoAvaliacaoTurma alunoAvaliacaoTurma ");
		sql.append("   JOIN FETCH alunoAvaliacaoTurma.turma turma ");
		sql.append("   JOIN FETCH alunoAvaliacaoTurma.aluno aluno ");
		sql.append("   JOIN FETCH alunoAvaliacaoTurma.avaliacaoRespostas avaliacaoRespostas ");
		sql.append("   JOIN FETCH avaliacaoRespostas.pergunta pergunta ");
		sql.append("   JOIN FETCH pergunta.formularioItems formulariosItems ");
		sql.append("   JOIN FETCH avaliacaoRespostas.resposta resposta ");
		sql.append("  WHERE 1=1 ");
		sql.append("    AND alunoAvaliacaoTurma.concluida = :TRUE ");
		sql.append("    AND alunoAvaliacaoTurma.transmitida = :FALSE");

		final TypedQuery<AlunoAvaliacaoTurma> query = getEntityManager().createQuery(sql.toString(), AlunoAvaliacaoTurma.class);
		query.setParameter("TRUE", true);
		query.setParameter("FALSE", false);
		return query.getResultList();
	}

	/**
	 * Encerra as avaliações pendentes
	 */
	public void closeAlunoAvaliacaoTurma() {
		final StringBuilder sql = new StringBuilder();
		sql.append(" UPDATE AlunoAvaliacaoTurma alunoAvaliacaoTurma ");
		sql.append("    SET alunoAvaliacaoTurma.concluida = :TRUE ");
		sql.append("  WHERE 1=1 ");
		sql.append("    AND alunoAvaliacaoTurma.concluida = :FALSE ");
		sql.append("    AND alunoAvaliacaoTurma.turma IN ( ");
		sql.append(" 		SELECT turma FROM Turma turma WHERE 1=1 ");
		sql.append(" 		   AND turma.dtFinalAvaliacao < :CURRENT_DATE");
		sql.append("    )");

		final TypedQuery<AlunoAvaliacaoTurma> query = getEntityManager().createQuery(sql.toString(), AlunoAvaliacaoTurma.class);
		query.setParameter("TRUE", true);
		query.setParameter("FALSE", false);
		query.setParameter("CURRENT_DATE", DateUtils.buildLastTime(Calendar.getInstance().getTime()));
		query.executeUpdate();
	}

}

