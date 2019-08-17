package br.com.decision.service;

import java.io.Serializable;
import java.util.List;

import br.com.decision.entity.IBaseEntity;

public interface IBaseService<E extends IBaseEntity> {

	E persist(E entity);
	void delete(E entity);
	E findById(Serializable id);
	List<E> findAll();
	E findFirstFullJoin();
	List<E> findFullJoin();
	E findFirst();


}
