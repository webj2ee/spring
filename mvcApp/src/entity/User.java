package entity;

import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.*;

public class User {

	private int id;
	
	@NotEmpty(message="Name is required.")
	@Pattern(regexp="[A-Z,a-z]{3}[A-Z,a-z, ]*",
	message="Name can contain only alphabets and space, Min length 3.")
	private String name;
	@NotEmpty(message="MailId is required.")
	@Email(message="MailId should be in proper format.")
	private String mailId;
	@NotEmpty(message="Password is required.")
	private String password;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getMailId() {
		return mailId;
	}
	public void setMailId(String mailId) {
		this.mailId = mailId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
}
