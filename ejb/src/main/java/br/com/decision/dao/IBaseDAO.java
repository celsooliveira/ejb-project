package br.com.decision.dao;

import java.io.Serializable;
import java.util.List;

import br.com.decision.entity.IBaseEntity;

/**
 * Interface para Camada de acesso aos dados - DAO
 * @param <E> Entidade
 */
public interface IBaseDAO<E extends IBaseEntity> {

	E persist(E entity);
	void delete(E entity);
	E findById(Serializable id);
	List<E> findAll();
	List<E> findFullJoin();
	E findFirst();
	E findFirstFullJoin();
	String getSqlFullJoin();
}
