package net.santosh.springboot.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Table;
import javax.persistence.CascadeType;
import javax.persistence.Column;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;


@Entity
@Table(name="userl")

public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private String userId;
	
	@Column(name = "password")
	private String password;
	
	@Column(name = "role")
	private String role;
	
	
	
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	public User(String password, String role) {
		super();
		this.password = password;
		this.role = role;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
}
