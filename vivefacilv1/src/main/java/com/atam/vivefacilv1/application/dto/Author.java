package com.atam.vivefacilv1.application.dto;

public class Author {

String name;
String firstSurname;
String bio;
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getFirstSurname() {
	return firstSurname;
}
public void setFirstSurname(String firstSurname) {
	this.firstSurname = firstSurname;
}
public String getBio() {
	return bio;
}
public void setBio(String bio) {
	this.bio = bio;
}
public Author(String name, String firstSurname, String bio) {
	super();
	this.name = name;
	this.firstSurname = firstSurname;
	this.bio = bio;
}



	
	

}
