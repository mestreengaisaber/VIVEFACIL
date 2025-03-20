package com.atam.vivefacilv1;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.UserDetailsServiceAutoConfiguration;

@SpringBootApplication(exclude = {UserDetailsServiceAutoConfiguration.class})
public class Vivefacilv1Application {

	public static void main(String[] args) {
		SpringApplication.run(Vivefacilv1Application.class, args);
	}

}
