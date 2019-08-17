package br.com.decision.entity;

import java.io.Serializable;
import java.util.Date;

public interface IBaseAuditableEntity extends IBaseEntity, Serializable {

	Integer getUsuarioInc();

	void setUsuarioInc(Integer usuarioInc);

	Integer getUsuarioAlt();

	void setUsuarioAlt(Integer usuarioAlt);

	Date getDtInclusao();

	void setDtInclusao(Date dtInclusao);

	Date getDtAlteracao();

	void setDtAlteracao(Date dtAlteracao);

	Integer getNrVersao();

	void setNrVersao(Integer nrVersao);

}
