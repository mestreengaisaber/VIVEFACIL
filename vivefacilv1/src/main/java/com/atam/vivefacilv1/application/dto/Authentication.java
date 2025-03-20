package com.atam.vivefacilv1.application.dto;

import java.io.Serializable;

public record Authentication(String username, String password) implements Serializable {
  private static final long serialVersionUID = 1L;
}
