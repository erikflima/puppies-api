package com.redthreadinnovations.puppies.dto;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;


/**
 * Data Transfer Object for login credentials. Used to transfer login data
 * between processes.
 */
public class LoginDTO {

	@NotBlank(message = "Email is mandatory")
	@Email(message = "Email should be valid")
	private String email;

	@NotBlank(message = "Password is mandatory")
	private String password;

	// -------------------------------------------//

	public LoginDTO() {
	}

	// -------------------------------------------//

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}