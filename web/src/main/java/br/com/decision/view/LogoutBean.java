package br.com.decision.view;

import java.io.IOException;
import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.inject.Named;

/**
 * Classe responsável pelo logout da aplicação
 */
@Named
@SessionScoped
public class LogoutBean implements Serializable {

	private static final long serialVersionUID = -7442694016230211194L;

	/**
	 * Realiza o logout do sistema
	 * @throws IOException Exceção
	 */
	public void logout() throws IOException {
		final ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
		ec.invalidateSession();
		ec.redirect(ec.getRequestContextPath());
	}

}
