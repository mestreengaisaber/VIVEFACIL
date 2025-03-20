package com.atam.vivefacilv1.application.service;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


@Service
public class UserDetailsServiceImpl implements UserDetailsService {
	
  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
	  
	  //lo podriamos cargar de un repo ahora lo hacemos manualmente 
	var usuario=  Usuario.getById(username);
	
	if (usuario==null) {
		 throw new UsernameNotFoundException(username);
	}
	
	return User
        .withUsername(username)
        .password(usuario.password)
        .roles(usuario.roles.toArray(new String[0]))
        .build();
  }



}
