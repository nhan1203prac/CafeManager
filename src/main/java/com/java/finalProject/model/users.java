package com.java.finalProject.model;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.*;

@Entity
@Table(name = "users")
public class users {
	@Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
   private long Id;
	
	@NotEmpty(message = "The username is required")
   private String username;
	
    @NotEmpty(message = "The password is required")
    @Size(min = 6, message = "The password must be at least 6 characters long")
   private String password;
    
   private String role;
   @NotEmpty(message = "The email is required")
   @Email(message = "Invalid email format")
   private String email;
   // Không cần lưu trữ confirmPassword
   @NotEmpty(message = "The confirm password is required")
   private transient String confirmPassword;
   
public String getConfirmPassword() {
	return confirmPassword;
}
public void setConfirmPassword(String confirmPassword) {
	this.confirmPassword = confirmPassword;
}
public long getId() {
	return Id;
}
public void setId(long id) {
	Id = id;
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
public String getRole() {
	return role;
}
public void setRole(String role) {
	this.role = role;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
   
   
}
