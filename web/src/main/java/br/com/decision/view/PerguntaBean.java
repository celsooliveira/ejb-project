package br.com.decision.view;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.enterprise.inject.Produces;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.decision.entity.Formulario;
import br.com.decision.entity.Pergunta;
import br.com.decision.entity.Topico;
import br.com.decision.service.FormularioService;
import br.com.decision.service.PerguntaService;
import br.com.decision.service.TopicoService;

@Named
@SessionScoped
public class PerguntaBean extends CrudBaseBean<Pergunta, PerguntaService> {

	private static final long serialVersionUID = 5523910844182711129L;

	@Inject
	private PerguntaService perguntaService;

	@Inject
	private TopicoService topicoService;

	@Inject
	private FormularioService formularioService;

	@PostConstruct
	public void init() {
		setEntity(buildNewInstance());
	}

	@Override
	public Pergunta buildNewInstance() {
		final Pergunta pergunta = new Pergunta();
		return pergunta;
	}

	@Produces
	public List<Pergunta> getPerguntas() {
		return perguntaService.findAll();
	}

	@Produces
	public List<Topico> getTopicos() {
		return topicoService.findAll();
	}

	@Produces
	public List<Formulario> getFormularios() {
		return formularioService.findAll();
	}

	@Override
	public PerguntaService getService() {
		return perguntaService;
	}

	@Override
	public String getModalTittle() {
		return "Gerenciar Perguntas";
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
