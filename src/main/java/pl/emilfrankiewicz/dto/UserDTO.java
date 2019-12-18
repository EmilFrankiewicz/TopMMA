package pl.emilfrankiewicz.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

public class UserDTO {
	@NotEmpty
	@Length(min = 2, max = 15)
	private String username;

	@NotEmpty
	@Length(min = 6)
	private String password;

	@Email
	private String email;

	public UserDTO() {
	}

	public UserDTO(String username, String password, String email) {
		this.username = username;
		this.password = password;
		this.email = email;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
