package br.com.decision.utils;

/**
 * Classe utilit�ria para formata��o de String
 *
 * @author Celso de Oliveira
 */
public final class StringUtils {

	/**
	 * Construtor privado para impossibilitar a instancia��o da classe
	 */
	private StringUtils() {
		super();
	}

	/**
	 * Verifica se o texto est� em branco
	 * @param text Texto
	 * @return Flag indicando se o texto est� em branco
	 */
	public static boolean isBlank(final String text) {
		return "".equals(trimToBlank(text));
	}

	/**
	 * Remove os espa�os em branco repetidos
	 * @param text Texto
	 * @return Texto sem espa�os em branco repetidos
	 */
	public static String trimToBlank(final String text) {
		if (text == null || "".equals(text)) {
			return "";
		}
		String str = text;
		str = str.replaceAll("\\s+", " ");
		return str.trim();
	}

}
