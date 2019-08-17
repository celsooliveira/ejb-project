package br.com.decision.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.Table;

/**
 * Classe para mapeamento da tabela "parametro_sistema"
 *
 */
@Entity
@Table(name = "parametro_sistema")
public class ParametroSistema extends BaseAuditableEntity implements Serializable {

	private static final long serialVersionUID = 5599753574536609328L;
	private Integer id;
	private String nmParametro;
	private String vlParametro;

	public ParametroSistema() {
		super();
	}

	@Override
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_parametro", unique = true)
	@JoinTable
	public Integer getId() {
		return this.id;
	}

	public void setId(final Integer id) {
		this.id = id;
	}

	@Column(name = "nm_parametro", length = 255)
	public String getNmParametro() {
		return nmParametro;
	}

	public void setNmParametro(final String nmParametro) {
		this.nmParametro = nmParametro;
	}

	@Column(name = "vl_parametro", length = 255)
	public String getVlParametro() {
		return vlParametro;
	}

	public void setVlParametro(final String vlParametro) {
		this.vlParametro = vlParametro;
	}

}