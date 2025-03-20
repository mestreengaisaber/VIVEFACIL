package com.atam.vivefacilv1.application.service;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.List;
import java.util.Set;

public class Usuario {
	//representa un usuario 
	
	String username;
	String password;
	Set<String> roles;
	
	
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
	public Set<String> getRoles() {
		return roles;
	}
	public void setRoles(Set<String> roles) {
		this.roles = roles;
	}
	public Usuario(String username, String password, Set<String> roles) {
		super();
		this.username = username;
		this.password = password;
		this.roles = roles;
	}
	
	public Usuario() {
	}
	
	//si estuviera en bd lo recuperariamos con algo asi:
	
	  public static Usuario getById(String username) {

		//TODO ese password lo podrimaos tener en el fichero de propiedades de spring
		  String originalPassword = "password";
		  BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		  String hashedPassword = passwordEncoder.encode(originalPassword);

		  var password = hashedPassword;
		    Usuario authvivelibre1 = new Usuario(
					"auth-vivelibre",
		        password,
		        Set.of("USER")
		    );

		    Usuario authvivelibre2 = new Usuario(
					"auth-vivelibre2",
		        password,
		        Set.of("ADMIN")
		    );
		    var usuarios = List.of(authvivelibre1, authvivelibre2);

		    return usuarios
		        .stream()
		        .filter(e -> e.username.equals(username))
		        .findFirst()
		        .orElse(null);
		  }
	

}
