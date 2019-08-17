package br.com.decision.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Classe para mapeamento da tabela "usuario"
 */
@Entity
@Table(name = "usuario")
public class Usuario extends BaseAuditableEntity implements Serializable {

	private static final long serialVersionUID = 5170387907402657476L;
	private Integer id;
	private Date dtNascimento;
	private String email;
	private String nome;
	private String senha;
	private String sobrenome;
	private List<Turma> turmasMinistradas;
	private List<Turma> turmas;
	private List<Perfil> perfis;

	public Usuario() {
		super();
	}

	@Override
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_usuario", unique = true)
	public Integer getId() {
		return this.id;
	}

	public void setId(final Integer id) {
		this.id = id;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "dt_nascimento")
	public Date getDtNascimento() {
		return this.dtNascimento;
	}

	public void setDtNascimento(final Date dtNascimento) {
		this.dtNascimento = dtNascimento;
	}

	@Column(name = "email", length = 100)
	public String getEmail() {
		return this.email;
	}

	public void setEmail(final String email) {
		this.email = email;
	}

	@Column(name = "nome", length = 255)
	public String getNome() {
		return this.nome;
	}

	public void setNome(final String nome) {
		this.nome = nome;
	}

	@Column(name = "senha", length = 45)
	public String getSenha() {
		return this.senha;
	}

	public void setSenha(final String senha) {
		this.senha = senha;
	}

	@Column(name="sobrenome", length = 255)
	public String getSobrenome() {
		return this.sobrenome;
	}

	public void setSobrenome(final String sobrenome) {
		this.sobrenome = sobrenome;
	}

	@OneToMany(mappedBy = "professor")
	public List<Turma> getTurmasMinistradas() {
		return turmasMinistradas;
	}

	public void setTurmasMinistradas(final List<Turma> turmasMinistradas) {
		this.turmasMinistradas = turmasMinistradas;
	}

	@ManyToMany(mappedBy = "alunos", cascade = CascadeType.ALL)
	public List<Turma> getTurmas() {
		return this.turmas;
	}

	public void setTurmas(final List<Turma> turmas) {
		this.turmas = turmas;
	}

	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "usuario_perfil",
	       	      joinColumns = { @JoinColumn(name = "id_usuario") },
	       inverseJoinColumns = { @JoinColumn(name = "id_perfil") })
	public List<Perfil> getPerfis() {
		return this.perfis;
	}

	public void setPerfis(final List<Perfil> perfis) {
		this.perfis = perfis;
	}

	@Override
	public String toString() {
		return "Usuario [id=" + id + ", "
				+ ", dtNascimento="
				+ dtNascimento + ", email=" + email + ", nome=" + nome
				+ ", senha=" + senha + ", sobrenome=" + sobrenome
				+ ", turmas=" + turmas + ", perfis=" + perfis + "]";
	}

}