package br.com.decision.view;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.decision.entity.Usuario;
import br.com.decision.service.UsuarioService;

@Named
@SessionScoped
public class AlunoBean extends CrudBaseBean<Usuario, UsuarioService> {

	private static final long serialVersionUID = -3640672383619073927L;

	@Inject
	private UsuarioService usuarioService;

	private List<Usuario> alunos;

	@Override
	public Usuario buildNewInstance() {
		return new Usuario();
	}

	@PostConstruct
	public void init() {
		loadAlunos();
	}

	@Override
	public String getModalTittle() {
		return "Gerenciar Alunos";
	}

	private void loadAlunos() {
		this.alunos = usuarioService.findAllAlunos();
	}

	public List<Usuario> getAlunos() {
		return alunos;
	}

	public void setAlunos(final List<Usuario> alunos) {
		this.alunos = alunos;
	}

	@Override
	public UsuarioService getService() {
		return usuarioService;
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
