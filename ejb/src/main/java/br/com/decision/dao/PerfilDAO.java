package br.com.decision.dao;

import javax.inject.Named;

import br.com.decision.entity.Perfil;

/**
 * Classe de acesso a dados para a entidade Perfil
 */
@Named
public class PerfilDAO extends BaseDAO<Perfil> {

	private static final long serialVersionUID = -8080216446175825993L;

	@Override
	public String getSqlFullJoin() {
		final StringBuilder sql = new StringBuilder();
		sql.append(" SELECT perfil FROM Perfil perfil ");
		sql.append(" JOIN FETCH perfil.usuarios usuarios ");
		return sql.toString();
	}

}

