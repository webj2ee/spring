package com.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Registration")
public class Registration implements Serializable {
	private Long user_id;
	private String username;
	private String password;

	public Registration() {
	}
	
	@Id
	@GeneratedValue
	@Column(name="user_id")
	public Long getId() {
		return user_id;
	}
	public void setId(Long user_id) {
		this.user_id = user_id;
	}

	@Column(name="username")
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}

	@Column(name="password")
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
}