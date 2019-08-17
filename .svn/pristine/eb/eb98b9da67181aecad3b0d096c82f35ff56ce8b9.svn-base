package br.com.decision.view;

import java.io.Serializable;

import br.com.decision.entity.BaseEntity;
import br.com.decision.service.BaseService;

public interface ICrudBaseBean<E extends BaseEntity, S extends BaseService<E>> extends Serializable {

	void save();
	void remove();
	S getService();
	E getEntity();
	String getModalTittle();

}
