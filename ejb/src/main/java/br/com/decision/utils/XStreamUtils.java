package br.com.decision.utils;

import java.io.File;

import br.com.decision.xml.AvaliacaoHash;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

/**
 * Classe Helper para gerenciamento dos dados em XML
 */
public final class XStreamUtils {

	private static XStreamUtils instance;
	private XStream xStream;

	/**
	 * Construtor
	 */
	private XStreamUtils() {
		super();
	}

	/**
	 * Retorna a inst�ncia da classe XStreamHelper
	 * @return XStreamHelper
	 */
	private static XStreamUtils getInstance() {
		if (instance == null) {
			instance = new XStreamUtils();
			instance.xStream = buildXStream();
		}
		return instance;
	}

	/**
	 * Instancia XStream
	 * @return XStream
	 */
	private static XStream buildXStream() {
		final XStream xstream = new XStream(new DomDriver("ISO-8859-1"));
		xstream.autodetectAnnotations(true);
		xstream.ignoreUnknownElements();
		xstream.alias("AvaliacaoHash", AvaliacaoHash.class);
		return xstream;
	}

	/**
	 * Retorna a inst�ncia XStream
	 * @return XStream
	 */
	private static XStream getXsStream() {
		return getInstance().xStream;
	}

	public static String toXML(final Object object) {
		return getXsStream().toXML(object);
	}

	public static Object fromXML(final String xml) {
		return getXsStream().fromXML(xml);
	}

	public static Object fromXML(final File file) {
		return getXsStream().fromXML(file);
	}

}
