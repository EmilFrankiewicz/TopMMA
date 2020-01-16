package pl.emilfrankiewicz.fighterdatabase.service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import pl.emilfrankiewicz.model.Mail;

@Service
public class MailService {

	private JavaMailSender javaMailSender;

	@Autowired
	public MailService(JavaMailSender javaMailSender) {
		this.javaMailSender = javaMailSender;
	}

	public void sendMail(Mail mail) throws MessagingException {
		MimeMessage mimeMessage = javaMailSender.createMimeMessage();
		MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);
		mimeMessageHelper.setTo(mail.getTo());
		mimeMessageHelper.setFrom(mail.getFrom());
		mimeMessageHelper.setSubject(mail.getSubject());
		mimeMessageHelper.setText(mail.getContent());
		javaMailSender.send(mimeMessage);
	}
}
