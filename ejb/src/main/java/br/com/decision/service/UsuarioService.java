package br.com.decision.service;

import java.io.Serializable;
import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import br.com.decision.criteria.UsuarioCriteria;
import br.com.decision.dao.UsuarioDAO;
import br.com.decision.entity.Usuario;


/**
 * Classe de Servico para a entidade Usuario
 */
@Stateless
public class UsuarioService extends BaseService<Usuario> implements Serializable {

	private static final long serialVersionUID = 8185969065974193019L;

	@Inject
	private UsuarioDAO dao;

	/** {@inheritDoc} */
	@Override
	protected UsuarioDAO getDAO() {
		return dao;
	}

	/**
	 * Método responsável pela busca dos usuários a partir do login
	 * @param login Usuario
	 * @param password Senha
	 * @return Usuario
	 */
	public Usuario findByLogin(final String login, final String password) {
		return dao.findByLogin(login, password);
	}

	/**
	 * Método responsável pela busca de todos os usuários e suas respectivas permissões de acesso
	 * @return List<Usuario>
	 */
	public List<Usuario> findAllJOIN() {
		return dao.findAllJOIN();
	}

	/**
	 * Método responsável pela busca dos usuário e suas respectivas permissões a partir de determinado ID
	 * @param id Id do Usuário
	 * @return Usuario
	 */
	public Usuario findByIdWithJOIN(final Integer id) {
		return dao.findByIdWithJOIN(id);
	}

	public List<Usuario> findAllAlunos() {
		return dao.findAllAlunos();
	}

	public List<Usuario> searchSourceByCriteria(final UsuarioCriteria criteria) {
		return dao.searchSourceByCriteria(criteria);
	}

	public List<Usuario> searchTargetByCriteria(final UsuarioCriteria criteria) {
		return dao.searchTargetByCriteria(criteria);
	}

	public Usuario findFirstAluno() {
		return dao.findFirstAluno();
	}

	/**
	 * Método responsável pela busca dos professores
	 * @return List<Usuario>
	 */
	public List<Usuario> searchProfessores() {
		return dao.searchProfessores();
	}

}
