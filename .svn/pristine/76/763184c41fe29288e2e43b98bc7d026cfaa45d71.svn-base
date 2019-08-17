package br.com.decision.view;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.enterprise.inject.Produces;
import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.model.DualListModel;

import br.com.decision.criteria.TurmaCriteria;
import br.com.decision.entity.Formulario;
import br.com.decision.entity.Pergunta;
import br.com.decision.entity.Turma;
import br.com.decision.service.FormularioService;
import br.com.decision.service.TurmaService;

@Named
@SessionScoped
public class FormularioBean extends CrudBaseBean<Formulario, FormularioService> {

	private static final long serialVersionUID = 5523910844182711129L;

	@Inject
	private FormularioService formularioService;

	@Inject
	private TurmaService turmaService;

	private DualListModel<Turma> turmas;
	private DualListModel<Pergunta> perguntas;

	@PostConstruct
	public void init() {
		setEntity(buildNewInstance());
		buildTurmas();
	}

	private void buildTurmas() {
		this.turmas = new DualListModel<Turma>(buildTurmaSource(), buildTurmaTarget());
	}

	private List<Turma> buildTurmaSource() {
		return turmaService.searchSourceByCriteria(buildTurmaCriteria());
	}

	private List<Turma> buildTurmaTarget() {
		if (isSelectedEntity() && !getEntity().getTurmas().isEmpty()) {
			return turmaService.searchTargetByCriteria(buildTurmaCriteria());
		}
		return Collections.emptyList();
	}

	private TurmaCriteria buildTurmaCriteria() {
		final TurmaCriteria criteria = new TurmaCriteria();
		if (isSelectedEntity()) {
			criteria.setIds(buildTurmasId());
		} else {
			criteria.setIds(Arrays.asList(0));
		}
		return criteria;
	}

	private List<Integer> buildTurmasId() {
		final List<Integer> turmaId = new ArrayList<Integer>();
		if (isSelectedEntity()) {
			for (final Turma turma : getEntity().getTurmas()) {
				turmaId.add(turma.getId());
			}
		}
		return turmaId;
	}

	@Override
	public void preEdit() {
		super.preEdit();
		buildTurmas();
	}

	@Override
	public void preInsert() {
		super.preInsert();
		buildTurmas();
	}

	@Override
	public void preSave() {
		super.preSave();
		getEntity().setTurmas(turmas.getTarget());
	}

	@Override
	public Formulario buildNewInstance() {
		final Formulario formulario = new Formulario();
		return formulario;
	}

	@Produces
	public List<Formulario> getFormularios() {
		return formularioService.findAll();
	}

	@Override
	public FormularioService getService() {
		return formularioService;
	}

	@Override
	public String getModalTittle() {
		return "Gerenciar Formularios";
	}

	public DualListModel<Turma> getTurmas() {
		return turmas;
	}

	public void setTurmas(final DualListModel<Turma> turmas) {
		this.turmas = turmas;
	}

	public DualListModel<Pergunta> getPerguntas() {
		return perguntas;
	}

	public void setPerguntas(final DualListModel<Pergunta> perguntas) {
		this.perguntas = perguntas;
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
