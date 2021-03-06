package br.com.decision.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

/**
 * Classe para mapeamento da tabela "perfil"
 */
@Entity
@Table(name = "perfil")
public class Perfil extends BaseAuditableEntity implements Serializable {

	private static final long serialVersionUID = 4636609191431545604L;
	private Integer id;
	private Boolean administrador;
	private Boolean aluno;
	private String descricao;
	private Boolean professor;
	private List<Usuario> usuarios;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_perfil", unique = true)
	@Override
	public Integer getId() {
		return id;
	}

	public void setId(final Integer id) {
		this.id = id;
	}

	@Column(name = "administrador")
	public Boolean getAdministrador() {
		return this.administrador;
	}

	public void setAdministrador(final Boolean administrador) {
		this.administrador = administrador;
	}

	@Column(name = "aluno")
	public Boolean getAluno() {
		return this.aluno;
	}

	public void setAluno(final Boolean aluno) {
		this.aluno = aluno;
	}

	@Column(name = "descricao", length = 200)
	public String getDescricao() {
		return this.descricao;
	}

	public void setDescricao(final String descricao) {
		this.descricao = descricao;
	}

	@Column(name = "professor")
	public Boolean getProfessor() {
		return this.professor;
	}

	public void setProfessor(final Boolean professor) {
		this.professor = professor;
	}

	@ManyToMany
	@JoinTable(name = "usuario_perfil",
		       joinColumns = { @JoinColumn(name = "id_perfil") },
		inverseJoinColumns = { @JoinColumn(name = "id_usuario") })
	public List<Usuario> getUsuarios() {
		return this.usuarios;
	}

	public void setUsuarios(final List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}

	@Override
	public String toString() {
		return "Perfil [id=" + id + ", administrador=" + administrador
				+ ", aluno=" + aluno + ", descricao=" + descricao
				+ ", professor=" + professor + ", usuarios=" + usuarios + "]";
	}

}