package com.atam.vivefacilv1.application.dto;

public class Book {

	String id ;
	String title;
	String publicationTimestamp;
	int pages ;
	String summary;
	Author author;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public int getPages() {
		return pages;
	}
	public void setPages(int pages) {
		this.pages = pages;
	}

	public String getSummary() {
		return summary;
	}
	public void setSummary(String summary) {
		this.summary = summary;
	}
	public Author getAuthor() {
		return author;
	}
	public void setAuthor(Author author) {
		this.author = author;
	}
	
	public String getPublicationTimestamp() {
		return publicationTimestamp;
	}
	public void setPublicationTimestamp(String publicationTimestamp) {
		this.publicationTimestamp = publicationTimestamp;
	}
	
	public Book(String id, String title, int pages, String summary, Author author) {
		super();
		this.id = id;
		this.title = title;
		this.pages = pages;
		this.summary = summary;
		this.author = author;
	}
	
	
	
	
	

}
