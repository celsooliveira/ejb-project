package br.com.decision.job;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import br.com.decision.utils.SecurityUtils;
import br.com.decision.utils.StringUtils;
import br.com.decision.utils.XStreamUtils;
import br.com.decision.xml.AvaliacaoHash;

public class Tester {

	public static void main(final String[] args) throws UnsupportedEncodingException {
//		final String hash = "u9P0pRy6Qwd7fMyhO32z6HwWipQKa/WLMVChYLr9s/i0U8ZMP+LmHgFGmzRaZMzJ8HlTL0o/gX8cPK/4JX10B2BGOWsz66mMAw7sAJryx1Q=";
//		final String hash = "u9P0pRy6Qwd7fMyhO32z6HwWipQKa/WLMVChYLr9s/i0U8ZMP+LmHgFGmzRaZMzJ8HlTL0o/gX8cPK/4JX10B2BGOWsz66mMAw7sAJryx1Q=";
		final String hash = "u9P0pRy6Qwd7fMyhO32z6HwWipQKa/WLMVChYLr9s/i0U8ZMP LmHgFGmzRaZMzJ8HlTL0o/gX8cPK/4JX10B2BGOWsz66mMAw7sAJryx1Q=";

//		u9P0pRy6Qwd7fMyhO32z6HwWipQKa/WLMVChYLr9s/i0U8ZMP+LmHgFGmzRaZMzJUYTxnppi06N4
//		p0IpwCHg1WBGOWsz66mMAw7sAJryx1Q=

//		p6sTZXyamVu5WcTeak9rs1MQ3lDdvqOBS8H+bSJV0AUlAHLuMk4TvdAyc4F8D6UGnQLk8KxDFQIr
//		nco2h4BXS0O6cLCZKTKTDUpIDHfp+Kk=

		final String avaliacao1 = SecurityUtils.encrypt(StringUtils.trimToBlank(XStreamUtils.toXML(new AvaliacaoHash(6, 12))));
		final String avaliacao2 = SecurityUtils.encrypt(StringUtils.trimToBlank(XStreamUtils.toXML(new AvaliacaoHash(6, 25))));
		final String avaliacao3 = SecurityUtils.encrypt(StringUtils.trimToBlank(XStreamUtils.toXML(new AvaliacaoHash(6, 28))));
		final String avaliacao4 = SecurityUtils.encrypt(StringUtils.trimToBlank(XStreamUtils.toXML(new AvaliacaoHash(6, 29))));

		final String avaliacaoEncoded1 = URLEncoder.encode(avaliacao1, "UTF-8");

		System.out.println(avaliacao1);
		System.out.println(avaliacaoEncoded1);
//
//				u9P0pRy6Qwd7fMyhO32z6HwWipQKa/WLMVChYLr9s/i0U8ZMP+LmHgFGmzRaZMzJ/OhTSNWBJx0O7cJErsAFD2BGOWsz66mMAw7sAJryx1Q=
//				u9P0pRy6Qwd7fMyhO32z6HwWipQKa/WLMVChYLr9s/i0U8ZMP+LmHgFGmzRaZMzJ8HlTL0o/gX8cPK/4JX10B2BGOWsz66mMAw7sAJryx1Q=
//				u9P0pRy6Qwd7fMyhO32z6HwWipQKa/WLMVChYLr9s/i0U8ZMP+LmHgFGmzRaZMzJUYTxnppi06N4p0IpwCHg1WBGOWsz66mMAw7sAJryx1Q=
//				u9P0pRy6Qwd7fMyhO32z6HwWipQKa/WLMVChYLr9s/i0U8ZMP+LmHgFGmzRaZMzJZT3qVXu/jtf222Sjxah3/GBGOWsz66mMAw7sAJryx1Q=


//		String url = "http://example.com/query?q=" + URLEncoder.encode(q, "UTF-8");

//		System.out.println(SecurityUtils.decrypt(hash));
	}

}
