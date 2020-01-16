package pl.emilfrankiewicz.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

public class MailDTO {

	@Email
	private String from;

	@Email
	private String to;

	@NotEmpty
	private String subject;

	public MailDTO() {
	}

	public String getFrom() {
		return from;
	}

	public void setFrom(String from) {
		this.from = from;
	}

	public String getTo() {
		return to;
	}

	public void setTo(String to) {
		this.to = to;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

}
