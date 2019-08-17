package br.com.decision.view;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import org.jboss.logging.Logger;
import org.primefaces.event.SelectEvent;

import br.com.decision.entity.BaseEntity;
import br.com.decision.service.BaseService;

public abstract class CrudBaseBean<E extends BaseEntity, S extends BaseService<E>> implements ICrudBaseBean<E, S> {

	private static final long serialVersionUID = 2252307768924125910L;
	private static final Logger LOGGER = Logger.getLogger(CrudBaseBean.class);

	private E entity;

	public abstract E buildNewInstance();

	public abstract String getModalWidth();
	public abstract String getModalHeight();

	public void preInsert() {

	}

	public boolean isSelectedEntity() {
		return getEntity() != null && getEntity().getId() != null;
	}

	public void insert() {
		preInsert();
		clearInstance();
		posInsert();
	}

	public void posInsert() {

	}

	public void preEdit() {

	}

	public void edit() {
		preEdit();
		loadInformations();
		posEdit();
	}

	public void loadInformations() {

	}

	public void posEdit() {

	}

	@SuppressWarnings("unchecked")
	public void onRowSelect(final SelectEvent event) {
		setEntity((E) event.getObject());
	}

	public void clearInstance() {
		setEntity(buildNewInstance());
		LOGGER.debug("Executando o método clearInstance.");
	}

	@Override
	public void save() {
		try {
			preSave();
			getService().persist(getEntity());
			addSuccessMessage("Registro inserido com sucesso!");
		} catch (final Exception e) {
			e.printStackTrace();
			addErrorMessage("Falha ao salvar registro!");
		} finally {
			clearInstance();
		}
	}

	protected void addSuccessMessage(final String summary) {
	    getFacesContext().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, summary, null));
	}

	protected void addErrorMessage(final String summary) {
		getFacesContext().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, summary, null));
	}

	private FacesContext getFacesContext() {
		return FacesContext.getCurrentInstance();
	}

	public void preSave() {

	}

	@Override
	public void remove() {
		try {
			getService().delete(entity);
			addSuccessMessage("Registro excluído com sucesso!");
		} catch (final Exception e) {
			e.printStackTrace();
			addErrorMessage("Falha ao excluir registro!");
		} finally {
			clearInstance();
		}
	}

	@Override
	public E getEntity() {
		return entity;
	}

	public void setEntity(final E entity) {
		this.entity = entity;
	}

}
