package br.com.decision.view;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.enterprise.inject.Produces;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.decision.entity.Topico;
import br.com.decision.service.TopicoService;

@Named
@SessionScoped
public class TopicoBean extends CrudBaseBean<Topico, TopicoService> {

	private static final long serialVersionUID = 5523910844182711129L;

	@Inject
	private TopicoService topicoService;

	@PostConstruct
	public void init() {
		setEntity(buildNewInstance());
	}

	@Override
	public Topico buildNewInstance() {
		return new Topico();
	}

	@Produces
	public List<Topico> getTopicos() {
		return topicoService.findAll();
	}

	@Override
	public TopicoService getService() {
		return topicoService;
	}

	@Override
	public String getModalTittle() {
		return "Gerenciar Topicos";
	}

	@Override
	public String getModalWidth() {
		return "350px;";
	}

	@Override
	public String getModalHeight() {
		return "550px;";
	}

}
