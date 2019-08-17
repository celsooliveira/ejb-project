package br.com.decision.utils;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

import org.apache.commons.codec.binary.Base64;

public class SecurityUtils {

	private static byte[] key = { 0x22, 0x13, 0x78, 0x56, 0x33, 0x21, 0x77,
		0x23, 0x77, 0x56, 0x29, 0x6a, 0x7c, 0x44, 0x11, 0x50 };

	/**
	 * Constrói a Cifra
	 * @param encryptMode Modo Encriptar/Decriptar
	 * @return Cipher
	 * @throws Exception
	 */
	private static Cipher buildCipher(final int encryptMode) throws Exception {
		final Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
		cipher.init(encryptMode, new SecretKeySpec(key, "AES"));
		return cipher;
	}

	/**
	 * Realiza a encriptação de determinada mensagem
	 * @param message Mensagem
	 * @return String - Mensagem criptografada
	 */
	public static String encrypt(final String message) {
		try {
			return Base64.encodeBase64String(buildCipher(Cipher.ENCRYPT_MODE).doFinal(message.getBytes()));
		} catch (final Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * Realiza a descriptografia de determinada mensagem
	 * @param message Mensagem
	 * @return String - Mensagem descriptografada
	 */
	public static String decrypt(final String message) {
		try {
			return new String(buildCipher(Cipher.DECRYPT_MODE).doFinal(Base64.decodeBase64(message)));
		} catch (final Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
