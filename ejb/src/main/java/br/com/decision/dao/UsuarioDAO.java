package br.com.decision.dao;

import java.util.List;

import javax.inject.Named;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import br.com.decision.criteria.UsuarioCriteria;
import br.com.decision.entity.Usuario;

/**
 * Classe de acesso a dados para a entidade Usuario
 */
@Named
public class UsuarioDAO extends BaseDAO<Usuario> {

	private static final long serialVersionUID = -6393793970513728875L;

	@Override
	public String getSqlFullJoin() {
		final StringBuilder sql = new StringBuilder();
		sql.append(" SELECT usuario FROM Usuario usuario ");
		sql.append(" JOIN FETCH usuario.turmasMinistradas turmasMinistradas ");
		sql.append(" JOIN FETCH usuario.turmas turmas ");
		sql.append(" JOIN FETCH usuario.perfis perfis ");
		return sql.toString();
	}

	/**
	 * Método responsável pela busca dos usuários a partir do login
	 * @param login Usuário
	 * @param password Senha
	 * @return Usuario
	 */
	public Usuario findByLogin(final String login, final String password) {
		final StringBuilder sql = new StringBuilder();
		sql.append(" SELECT usuario FROM Usuario usuario ");
		sql.append(" WHERE 1=1");
		sql.append(" AND usuario.usuario = :login ");
		sql.append(" AND usuario.senha = :password ");

		final Query query = super.entityManager.createQuery(sql.toString());
		query.setParameter("login", login);
		query.setParameter("password", password);
		return (Usuario) query.getSingleResult();
	}

	/**
	 * Método responsável pela busca de todos os usuários e suas respectivas permissões de acesso
	 * @return List<Usuario>
	 */
	@SuppressWarnings("unchecked")
	public List<Usuario> findAllJOIN() {
		final StringBuilder sql = new StringBuilder();
		sql.append(" SELECT DISTINCT usuario FROM Usuario usuario ");
		sql.append(" JOIN FETCH usuario.roles roles");

		final Query query = super.entityManager.createQuery(sql.toString());
		return query.getResultList();
	}

	/**
	 * Método responsável pela busca de todos os usuários e suas respectivas permissões de acesso
	 * @return List<Usuario>
	 */
	public List<Usuario> findAllAlunos() {
		final StringBuilder sql = new StringBuilder();
		sql.append(" SELECT DISTINCT usuario FROM Usuario usuario ");
		sql.append("   JOIN FETCH usuario.perfis perfis ");
		sql.append("  WHERE perfis.aluno = :TRUE ");

		final TypedQuery<Usuario> query = super.entityManager.createQuery(sql.toString(), Usuario.class);
		query.setParameter("TRUE", Boolean.TRUE);
		return query.getResultList();
	}

	/**
	 * Método responsável pela busca de todos os usuários e suas respectivas permissões de acesso
	 * @return List<Usuario>
	 */
	public Usuario findFirstAluno() {
		try {
			final StringBuilder sql = new StringBuilder();
			sql.append(" SELECT DISTINCT usuario FROM Usuario usuario ");
			sql.append("   JOIN FETCH usuario.perfis perfis ");
			sql.append("  WHERE perfis.aluno = :TRUE ");

			final Query query = super.entityManager.createQuery(sql.toString());
			query.setMaxResults(1);
			query.setParameter("TRUE", Boolean.TRUE);
			return (Usuario) query.getSingleResult();
		} catch (final Exception e) {
			return null;
		}
	}

	/**
	 * Método responsável pela busca dos usuário e suas respectivas permissões a partir de determinado ID
	 * @param id Id do Usuário
	 * @return Usuario
	 */
	public Usuario findByIdWithJOIN(final Integer id) {
		final StringBuilder sql = new StringBuilder();
		sql.append(" SELECT DISTINCT usuario FROM Usuario usuario ");
		sql.append(" JOIN FETCH usuario.roles roles ");
		sql.append(" WHERE usuario.id = :id ");

		final Query query = super.entityManager.createQuery(sql.toString());
		query.setParameter("id", id);
		return (Usuario) query.getSingleResult();
	}

	/**
	 * Método responsável pela busca dos professores
	 * @return List<Usuario>
	 */
	public List<Usuario> searchProfessores() {
		final StringBuilder sql = new StringBuilder();
		sql.append(" SELECT professor FROM Usuario professor ");
		sql.append("   JOIN FETCH professor.perfis perfis ");
		sql.append("  WHERE perfis.professor = :TRUE ");

		final TypedQuery<Usuario> query = getEntityManager().createQuery(sql.toString(), Usuario.class);
		query.setParameter("TRUE", Boolean.TRUE);
		return query.getResultList();
	}

	public List<Usuario> searchSourceByCriteria(final UsuarioCriteria criteria) {
		final StringBuilder sql = new StringBuilder();
		sql.append(" SELECT aluno FROM Usuario aluno ");
		sql.append("   JOIN FETCH aluno.perfis perfis ");
		sql.append("  WHERE perfis.aluno = :TRUE ");
		if (criteria.getIds() != null && !criteria.getIds().isEmpty()) {
			sql.append("   AND aluno.id NOT IN :alunosId ");
		}
		final TypedQuery<Usuario> query = getEntityManager().createQuery(sql.toString(), Usuario.class);
		query.setParameter("TRUE", Boolean.TRUE);
		if (criteria.getIds() != null && !criteria.getIds().isEmpty()) {
			query.setParameter("alunosId", criteria.getIds());
		}
		return query.getResultList();
	}

	public List<Usuario> searchTargetByCriteria(final UsuarioCriteria criteria) {
		final StringBuilder sql = new StringBuilder();
		sql.append("SELECT aluno FROM Usuario aluno WHERE 1=1 ");
		sql.append("   AND aluno.id IN :alunosId ");
		final TypedQuery<Usuario> query = getEntityManager().createQuery(sql.toString(), Usuario.class);
		query.setParameter("alunosId", criteria.getIds());
		return query.getResultList();
	}

}
