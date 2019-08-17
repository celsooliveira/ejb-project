package br.com.decision.criteria;

import java.io.Serializable;
import java.util.List;

public class BaseCriteria implements Serializable {

	private static final long serialVersionUID = -9113071314386819992L;
	public List<Integer> ids;

	public List<Integer> getIds() {
		return ids;
	}

	public void setIds(final List<Integer> ids) {
		this.ids = ids;
	}

}
