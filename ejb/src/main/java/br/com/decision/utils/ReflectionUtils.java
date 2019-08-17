package br.com.decision.utils;

import java.lang.reflect.ParameterizedType;

public class ReflectionUtils {

	public static Class<?> getGenericClassFromClass(final Class<?> clazz, final int genericPosition) {
		if (isWeldProxyClass(clazz)) {
			final Class<?> c = (Class<?>) clazz.getGenericSuperclass();
			final ParameterizedType type = (ParameterizedType) c.getGenericSuperclass();
			return (Class<?>) type.getActualTypeArguments()[genericPosition];
		}

		final ParameterizedType type = (ParameterizedType) clazz.getGenericSuperclass();
		return (Class<?>) type.getActualTypeArguments()[genericPosition];
	}

	/**
	 * M�todo para identificar se a classe � um Weld Proxy.
	 */
	private static boolean isWeldProxyClass(final Class<?> clazz) {
		return clazz.getName().endsWith("$Proxy$_$$_WeldClientProxy");
	}

}
