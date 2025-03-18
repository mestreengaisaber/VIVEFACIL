package com.atam.vivefacilv1.application.service;

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
		    // "secreto" => [BCrypt] => "$2a$10$56VCAiApLO8NQYeOPiu2De/EBC5RWrTZvLl7uoeC3r7iXinRR1iiq"
		    var password = "$2a$10$56VCAiApLO8NQYeOPiu2De/EBC5RWrTZvLl7uoeC3r7iXinRR1iiq";
		    Usuario authvivelibre1 = new Usuario(
		        "authvivelibre1",
		        password,
		        Set.of("USER")
		    );

		    Usuario authvivelibre2 = new Usuario(
		        "authvivelibre2",
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
