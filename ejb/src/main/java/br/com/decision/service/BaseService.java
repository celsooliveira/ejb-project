package br.com.decision.service;

import java.io.Serializable;
import java.util.List;

import br.com.decision.dao.BaseDAO;
import br.com.decision.entity.IBaseEntity;

public abstract class BaseService<E extends IBaseEntity> implements IBaseService<E> {

	/**
	 * {@inheritDoc}
	 */
	protected abstract BaseDAO<E> getDAO();

	@Override
	public E persist(final E entity) {
		return getDAO().persist(entity);
	}

	@Override
	public void delete(final E entity) {
		getDAO().delete(entity);
	}

	@Override
	public E findById(final Serializable id) {
		return getDAO().findById(id);
	}

	@Override
	public List<E> findAll() {
		return getDAO().findAll();
	}

	@Override
	public E findFirst() {
		return getDAO().findFirst();
	}

	@Override
	public List<E> findFullJoin() {
		return getDAO().findFullJoin();
	}

	@Override
	public E findFirstFullJoin() {
		return getDAO().findFirstFullJoin();
	}
}
