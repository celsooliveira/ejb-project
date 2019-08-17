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

import br.com.decision.criteria.ModuloCriteria;
import br.com.decision.entity.Curso;
import br.com.decision.entity.Modulo;
import br.com.decision.service.CursoService;
import br.com.decision.service.ModuloService;

@Named
@SessionScoped
public class CursoBean extends CrudBaseBean<Curso, CursoService> {

	private static final long serialVersionUID = 5523910844182711129L;

	@Inject
	private CursoService cursoService;

	@Inject
	private ModuloService moduloService;

	private DualListModel<Modulo> modulos;

	@PostConstruct
	public void init() {
		setEntity(buildNewInstance());
		buildModulos();
	}

	private void buildModulos() {
		this.modulos = new DualListModel<Modulo>(buildSource(), buildTarget());
	}

	private List<Modulo> buildTarget() {
		if (isSelectedEntity() && !getEntity().getModulos().isEmpty()) {
			return moduloService.searchTargetByCriteria(buildModuloCriteria());
		}
		return Collections.emptyList();
	}

	private ModuloCriteria buildModuloCriteria() {
		final ModuloCriteria criteria = new ModuloCriteria();
		if (isSelectedEntity()) {
			criteria.setIds(buildModulosId());
		} else {
			criteria.setIds(Arrays.asList(0));
		}
		return criteria;
	}

	private List<Integer> buildModulosId() {
		final List<Integer> modulosId = new ArrayList<Integer>();
		if (isSelectedEntity()) {
			for (final Modulo modulo : getEntity().getModulos()) {
				modulosId.add(modulo.getId());
			}
		}
		return modulosId;
	}

	@Override
	public void preEdit() {
		super.preEdit();
		buildModulos();
	}

	@Override
	public void preInsert() {
		super.preInsert();
		buildModulos();
	}

	@Override
	public void preSave() {
		super.preSave();
		getEntity().setModulos(modulos.getTarget());
	}

	private List<Modulo> buildSource() {
		return moduloService.searchSourceByCriteria(buildModuloCriteria());
	}

	@Override
	public Curso buildNewInstance() {
		final Curso curso = new Curso();
		return curso;
	}

	@Produces
	public List<Curso> getCursos() {
		return cursoService.findAll();
	}

	@Override
	public CursoService getService() {
		return cursoService;
	}

	@Override
	public String getModalTittle() {
		return "Gerenciar Cursos";
	}

	public DualListModel<Modulo> getModulos() {
		return modulos;
	}

	public void setModulos(final DualListModel<Modulo> modulos) {
		this.modulos = modulos;
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
