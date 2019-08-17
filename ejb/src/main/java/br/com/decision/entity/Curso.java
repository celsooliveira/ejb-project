package br.com.decision.entity;

import java.io.Serializable;
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
import javax.persistence.Table;

/**
 * Classe para mapeamento da tabela "curso"
 */
@Entity
@Table(name = "curso")
public class Curso extends BaseAuditableEntity implements Serializable {

	private static final long serialVersionUID = -716108935725180024L;
	private Integer id;
	private String nomeCurso;
	private List<Modulo> modulos;

	public Curso() {
		super();
	}

	@Override
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_curso", unique = true)
	@JoinTable
	public Integer getId() {
		return this.id;
	}

	public void setId(final Integer id) {
		this.id = id;
	}

	@Column(name = "nomeCurso",length = 255)
	public String getNomeCurso() {
		return this.nomeCurso;
	}

	public void setNomeCurso(final String nomeCurso) {
		this.nomeCurso = nomeCurso;
	}

	@ManyToMany(cascade = CascadeType.MERGE)
	@JoinTable(name = "curso_modulo",
	       	      joinColumns = { @JoinColumn(name = "id_curso") },
	       inverseJoinColumns = { @JoinColumn(name = "id_modulo") })
	public List<Modulo> getModulos() {
		return this.modulos;
	}

	public void setModulos(final List<Modulo> modulos) {
		this.modulos = modulos;
	}

	@Override
	public String toString() {
		return "Curso [id=" + id + ", nomeCurso=" + nomeCurso + ", modulos="
				+ modulos + "]";
	}

}