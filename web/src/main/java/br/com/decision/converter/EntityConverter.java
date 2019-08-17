package br.com.decision.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import br.com.decision.entity.BaseEntity;

/**
 * Classe de convers„o para entidades
 * @author Celso de Oliveira
 */
@FacesConverter("entityConverter")
public class EntityConverter implements Converter {

	@Override
	public Object getAsObject(final FacesContext ctx, final UIComponent component,
			final String value) {
		if (value != null) {
			return component.getAttributes().get(value);
		}
		return null;
	}

	@Override
	public String getAsString(final FacesContext ctx, final UIComponent component,
			final Object obj) {
		if (obj != null && !"".equals(obj)) {
			String id;

			final BaseEntity entity = (BaseEntity) obj;

			if (entity.getId() == null) {
				id = "";
			} else {
				id = entity.getId().toString();
				id = id.trim();
			}

			component.getAttributes().put(id, getClazz(ctx, component).cast(obj));
			return id;
		}
		return null;
	}

	/**
	 * ObtÈm, via expression language, a classe do objeto
	 *
	 * @param facesContext
	 *            facesContext
	 *
	 * @param component
	 *            component
	 *
	 * @return Class<?>
	 */
	protected Class<?> getClazz(final FacesContext facesContext, final UIComponent component) {
		return component.getValueExpression("value").getType(facesContext.getELContext());
	}

}
