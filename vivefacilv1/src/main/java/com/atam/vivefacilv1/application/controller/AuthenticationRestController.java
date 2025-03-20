package com.atam.vivefacilv1.application.controller;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import com.atam.vivefacilv1.application.dto.Authentication;
import com.atam.vivefacilv1.application.dto.RespuestaToken;
import com.atam.vivefacilv1.application.security.JWTAuthtenticationConfig;
import com.atam.vivefacilv1.application.service.ExternalServiceClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping
public class AuthenticationRestController {

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	UserDetailsService usuarioDetailsService;

	@Autowired
	ExternalServiceClient externalServiceClient;


	@Autowired
	JWTAuthtenticationConfig jwtAuthtenticationConfig;

	@PostMapping("tokenInt")
	public ResponseEntity<RespuestaToken> authenticateInt(@RequestBody Authentication authenticationReq) {

		authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(authenticationReq.username(),
						authenticationReq.password()));

		final UserDetails userDetails = usuarioDetailsService.loadUserByUsername(
				authenticationReq.username());

		// logger.info("Autenticando al usuario {}", authenticationReq.getUsuario());
		String token = jwtAuthtenticationConfig.getJWTToken(authenticationReq.username());
		//return new User(authenticationReq.getUsuario(), authenticationReq.getClave(),token);

		LocalDateTime now = LocalDateTime.now();
		DateTimeFormatter formatter = DateTimeFormatter.ISO_DATE_TIME;
		String timestamp = now.format(formatter);

		return ResponseEntity.ok(new RespuestaToken(token, timestamp));


	}

	@PostMapping("tokenExt")
	public ResponseEntity<RespuestaToken> authenticateExt(@RequestBody Authentication authenticationReq) {

		authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(authenticationReq.username(),
						authenticationReq.password()));

		final UserDetails userDetails = usuarioDetailsService.loadUserByUsername(
				authenticationReq.username());

		//el token lo recuperamos del servicio externo si es que esta levantado
		String token =externalServiceClient.getResponse(authenticationReq);


		LocalDateTime now = LocalDateTime.now();
		DateTimeFormatter formatter = DateTimeFormatter.ISO_DATE_TIME;
		String timestamp = now.format(formatter);

		return ResponseEntity.ok(new RespuestaToken(token, timestamp));


	}


}
