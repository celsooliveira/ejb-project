package br.com.decision.view;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.enterprise.inject.Produces;
import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.model.DualListModel;

import br.com.decision.criteria.UsuarioCriteria;
import br.com.decision.entity.AlunoAvaliacaoTurma;
import br.com.decision.entity.Curso;
import br.com.decision.entity.Formulario;
import br.com.decision.entity.Modulo;
import br.com.decision.entity.Turma;
import br.com.decision.entity.Usuario;
import br.com.decision.service.CursoService;
import br.com.decision.service.FormularioService;
import br.com.decision.service.ModuloService;
import br.com.decision.service.TurmaService;
import br.com.decision.service.UsuarioService;

@Named
@SessionScoped
public class TurmaBean extends CrudBaseBean<Turma, TurmaService> {

	private static final long serialVersionUID = 8380115730030681864L;

	@Inject
	private CursoService cursoService;

	@Inject
	private TurmaService turmaService;

	@Inject
	private UsuarioService usuarioService;

	@Inject
	private ModuloService moduloService;

	@Inject
	private FormularioService formularioService;

	private DualListModel<Usuario> alunos;

	@Override
	public void preInsert() {
		super.preInsert();
		loadAlunos();
	}

	@Override
	public void preEdit() {
		super.preEdit();
		loadAlunos();
	}

	private void loadAlunos() {
		this.alunos = new DualListModel<Usuario>(buildSource(), buildTarget());
	}

	@PostConstruct
	public void init() {
		setEntity(buildNewInstance());
		this.alunos = new DualListModel<Usuario>();
	}

	@Override
	public void preSave() {
		super.preSave();
		getEntity().setAlunos(alunos.getTarget());
	}

	@Produces
	public List<Turma> getTurmas() {
		return turmaService.findFullJoin();
	}

	private List<Usuario> buildSource() {
		return usuarioService.searchSourceByCriteria(buildUsuarioCriteria());
	}

	private List<Usuario> buildTarget() {
		return usuarioService.searchTargetByCriteria(buildUsuarioCriteria());
	}

	private UsuarioCriteria buildUsuarioCriteria() {
		final UsuarioCriteria criteria = new UsuarioCriteria();
		if (isSelectedEntity()) {
			criteria.setIds(buildAlunosId());
		} else {
			criteria.setIds(Arrays.asList(0));
		}
		return criteria;
	}

	private List<Integer> buildAlunosId() {
		final List<Integer> alunosId = new ArrayList<Integer>();
		if (isSelectedEntity()) {
			for (final Usuario aluno : getEntity().getAlunos()) {
				alunosId.add(aluno.getId());
			}
		}
		alunosId.add(-1);
		return alunosId;
	}

	public DualListModel<Usuario> getAlunos() {
		return alunos;
	}

	public void setAlunos(final DualListModel<Usuario> alunos) {
		this.alunos = alunos;
	}

	@Override
	public TurmaService getService() {
		return turmaService;
	}

	@Override
	public String getModalTittle() {
		return "Gerenciar Turmas";
	}

	@Override
	public Turma buildNewInstance() {
		final Turma turma = new Turma();
		turma.setAlunos(new ArrayList<Usuario>());
		turma.setFormulario(new Formulario());
		turma.setModulo(new Modulo());
		turma.setProfessor(new Usuario());
		turma.setAlunoAvaliacaoTurmas(new ArrayList<AlunoAvaliacaoTurma>());
		return turma;
	}

	@Produces
	public List<Usuario> getProfessores() {
		return usuarioService.searchProfessores();
	}

	@Produces
	public List<Curso> getCursos() {
		return cursoService.findAll();
	}

	@Produces
	public List<Modulo> getModulos() {
		return moduloService.findAll();
	}

	@Produces
	public List<Formulario> getFormularios() {
		return formularioService.findAll();
	}

	@Override
	public String getModalWidth() {
//		return "750;";
		return "50% !important; ";
	}

	@Override
	public String getModalHeight() {
		return "750;";
	}

}
