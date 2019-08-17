package br.com.decision.view;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.enterprise.inject.Produces;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.decision.entity.Formulario;
import br.com.decision.entity.FormularioItem;
import br.com.decision.entity.Pergunta;
import br.com.decision.entity.Topico;
import br.com.decision.service.FormularioItemService;
import br.com.decision.service.FormularioService;
import br.com.decision.service.PerguntaService;
import br.com.decision.service.TopicoService;

@Named
@SessionScoped
public class FormularioAvaliacaoBean extends CrudBaseBean<FormularioItem, FormularioItemService> {

	private static final long serialVersionUID = -5258087531309812054L;

	@Inject
	private FormularioItemService formularioItemService;

	@Inject
	private FormularioService formularioService;

	@Inject
	private TopicoService topicoService;

	@Inject
	private PerguntaService perguntaService;

	@PostConstruct
	public void init() {
		setEntity(buildNewInstance());
	}

	@Override
	public FormularioItem buildNewInstance() {
		final FormularioItem item = new FormularioItem();
		item.setFormulario(new Formulario());
		item.setPergunta(new Pergunta());
		item.setTopico(new Topico());
		return item;
	}

	@Produces
	public List<FormularioItem> getFormulariosAvaliacao() {
		return getService().findAll();
	}

	@Produces
	public List<Formulario> getFormularios() {
		return formularioService.findAll();
	}

	@Produces
	public List<Topico> getTopicos() {
		return topicoService.findAll();
	}
	@Produces
	public List<Pergunta> getPerguntas() {
		return perguntaService.findAll();
	}

	@Override
	public FormularioItemService getService() {
		return formularioItemService;
	}

	@Override
	public String getModalTittle() {
		return "Gerenciar Formulário de Avaliação";
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
