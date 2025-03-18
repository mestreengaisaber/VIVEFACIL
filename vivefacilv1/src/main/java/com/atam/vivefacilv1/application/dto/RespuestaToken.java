package com.atam.vivefacilv1.application.dto;

public class RespuestaToken {
	
	String authvivelibretoken;
	String date;
	
	
	
	
	
	public String getAuthvivelibretoken() {
		return authvivelibretoken;
	}





	public void setAuthvivelibretoken(String authvivelibretoken) {
		this.authvivelibretoken = authvivelibretoken;
	}





	public String getDate() {
		return date;
	}





	public void setDate(String date) {
		this.date = date;
	}





	public RespuestaToken(String authvivelibretoken, String date) {
		super();
		this.authvivelibretoken = authvivelibretoken;
		this.date = date;
	}
	
	
	

}
