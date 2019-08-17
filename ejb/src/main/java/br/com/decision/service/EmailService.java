package br.com.decision.service;

import java.io.Serializable;

import javax.annotation.Resource;
import javax.ejb.Asynchronous;
import javax.ejb.Stateless;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;


@Stateless
public class EmailService implements Serializable {

	private static final long serialVersionUID = 3926706877846019720L;

	@Resource(lookup = "mail/avaliacao")
	private Session mailSession;

	@Asynchronous
	public void sendMessage(final String to, final String subject, final String message){
		try {
			final Message mimeMessage = new MimeMessage(mailSession);
			mimeMessage.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
			mimeMessage.setSubject(subject);
			mimeMessage.setContent(message, "text/plain");
			Transport.send(mimeMessage);
		} catch (final MessagingException e) {
			e.printStackTrace();
		}
	}


}
