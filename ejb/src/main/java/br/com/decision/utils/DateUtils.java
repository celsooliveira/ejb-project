package br.com.decision.utils;

import java.util.Calendar;
import java.util.Date;

/**
 * Classe utilitária para manipulação de datas
 */
public class DateUtils {

	/**
	 * Retorna o último horário para determinada data
	 * @param date Data Original
	 * @return Data com horário 23:59:59
	 */
	public static Date buildLastTime(final Date date) {
		final Calendar c = Calendar.getInstance();
		c.setTime(date);
		c.set(Calendar.HOUR_OF_DAY, 23);
		c.set(Calendar.MINUTE, 59);
		c.set(Calendar.SECOND, 59);
		return c.getTime();
	}

}
