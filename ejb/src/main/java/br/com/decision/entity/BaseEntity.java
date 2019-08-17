package br.com.decision.entity;

import javax.persistence.MappedSuperclass;

/**
 * Entidade base
 */
@MappedSuperclass
public abstract class BaseEntity implements IBaseEntity {

	private static final long serialVersionUID = -3582181942357728351L;

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ (getId() == null ? 0 : getId().hashCode());
		return result;
	}

	@Override
	public boolean equals(final Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}

		if (obj instanceof BaseEntity) {
			final BaseEntity other = (BaseEntity) obj;
			if (getId() == null) {
				if (other.getId() != null) {
					return false;
				}
			} else if (getId().equals(other.getId())) {
				return true;
			}
		}

		return false;
	}

}
