package br.com.decision.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import org.primefaces.component.picklist.PickList;
import org.primefaces.model.DualListModel;

import br.com.decision.entity.BaseEntity;

@FacesConverter(value = "pickListConverter")
public class PickListConverter implements Converter {

	@Override
	@SuppressWarnings("rawtypes")
	public Object getAsObject(final FacesContext context, final UIComponent component, final String value) {
		Object ret = null;
		if (component instanceof PickList) {
			final Object dualList = ((PickList) component).getValue();
			for (final Object object : ((DualListModel) dualList).getSource()) {
				if (value.equals(buildIdFromObject(object))) {
					ret = object;
					break;
				}
			}
			if (ret == null) {
				for (final Object object : ((DualListModel) dualList).getTarget()) {
					final String id = buildIdFromObject(object);
					if (value.equals(id)) {
						ret = object;
						break;
					}
				}
			}
		}
		return ret;
	}

	private String buildIdFromObject(final Object object) {
		return (new StringBuilder()).append(((BaseEntity) object).getId()).toString();
	}

	@Override
	public String getAsString(final FacesContext context, final UIComponent component, final Object value) {
		if (value instanceof BaseEntity) {
			return ((BaseEntity) value).getId().toString();
		}
		return "";
	}

}
