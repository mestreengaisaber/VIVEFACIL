package com.atam.vivefacilv1.application.service;

import com.atam.vivefacilv1.application.dto.Authentication;
import com.fasterxml.jackson.core.util.RequestPayload;
import org.springframework.web.client.RestTemplate;

public class ExternalServiceClient {

    private final String URL_TOKEN="http://localhost:8080/token";

    private final RestTemplate restTemplate;


    public ExternalServiceClient(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    /*
    return this token

    /*{
        "token": "eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJhdXRoLXZpdmVsaWJyZSIsImV4cCI6MTc0MjQ4NzU3NiwiaWF0IjoxNzQyNDY5NTc2fQ.tM6yhwO4nSaTxRZKLs_FAUICt8TY4wWE94n0MI8mf3EBHfx_fTFitoYLhOQd6P7OuvrVohL8mrZzx4UxJQ3gKg"
    }
    */

    public String getResponse(Authentication request) {
        String url = URL_TOKEN;
        return restTemplate.postForObject(URL_TOKEN, request, String.class);
    }
}
