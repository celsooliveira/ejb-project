package br.com.decision.utils;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import br.com.decision.xml.AvaliacaoHash;

public class AvaliacaoHashUtils {

	public static String buildHashFromAvaliacao(final Integer alunoId, final Integer turmaId) {
		try {
			return buildEncodedURL(alunoId, turmaId);
		} catch (final Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public static AvaliacaoHash buildAvaliacaoHashFromURLParameter(final String urlParameter) {
		try {
			return buildAvaliacaoHashFromURL(urlParameter);
		} catch (final Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	private static AvaliacaoHash buildAvaliacaoHashFromURL(final String urlParameter) {
		return (AvaliacaoHash) XStreamUtils.fromXML(decryptURLParameter(urlParameter));
	}

	private static String buildEncodedURL(final Integer alunoId, final Integer turmaId) throws UnsupportedEncodingException {
		return URLEncoder.encode(buildEncryptedXML(alunoId, turmaId), "UTF-8");
	}

	private static String buildEncryptedXML(final Integer alunoId, final Integer turmaId) {
		return SecurityUtils.encrypt(buildXML(alunoId, turmaId));
	}

	private static String decryptURLParameter(final String urlParameter) {
		return SecurityUtils.decrypt(urlParameter);
	}

	private static String buildXML(final Integer alunoId, final Integer turmaId) {
		return XStreamUtils.toXML(new AvaliacaoHash(turmaId, alunoId));
	}

}
