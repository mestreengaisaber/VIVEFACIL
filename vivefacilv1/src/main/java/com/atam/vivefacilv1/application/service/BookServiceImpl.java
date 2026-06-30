package com.atam.vivefacilv1.application.service;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import com.atam.vivefacilv1.application.dto.BookAuthorDoBookResponse;
import com.atam.vivefacilv1.application.dto.BookMaxMinResponse;
import org.apache.logging.log4j.util.Strings;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.atam.vivefacilv1.application.dto.Book;




@Service
public class BookServiceImpl implements BookService {

	private static final Logger logger = LoggerFactory.getLogger(BookServiceImpl.class);

	private final static String NAME_OFF_JSON = "books_nuevo.json";

	@Override
	// Filters books with more than specified pages and whose title contains the filter string
	public List<Book> filtrarLibros(int numPag, String FilterTitle) {
		List<Book> books = Arrays.asList(cargarLibros());
		return books.stream()
				.filter(book -> book.getPages() > numPag && book.getTitle().contains(FilterTitle))
				.collect(Collectors.toList());
	}

	// Get books written by a specific author
	@Override
	public List<Book> filtrarLibrosAutor(String writer) {
		List<Book> books = Arrays.asList(cargarLibros());
		return books.stream()
				.filter(book -> book.getAuthor().getName().equals(writer))
				.collect(Collectors.toList());
	}

	// Lists titles sorted alphabetically and counts how many books each author has written
	@Override
	public List<BookAuthorDoBookResponse> ordenarLibrosPorAuthorContarNumLibros() {
		return Arrays.asList(cargarLibros()).stream()
				.collect(Collectors.groupingBy(
						book -> book.getAuthor().getName(),
						Collectors.counting()
				))
				.entrySet().stream()
				.sorted(Map.Entry.comparingByKey())
				.map(entry -> new BookAuthorDoBookResponse(entry.getKey(), entry.getValue().intValue()))
				.collect(Collectors.toList());
	}

	@Override
	public BookMaxMinResponse filtrarLibrosMaxMinAvg() {
//vaya inventada como eso va a compilar? 

//cambio3

//cambio8

//cambio6,3
		List<Book> books = Arrays.asList(metodoiventado());

		var avgBook = books.stream()
				.flatMapToInt(bk -> IntStram.of(bk.getPages()))
				.average();

		Optional<Book> maxBook = books.stream()
				.max(Comparator.comparingInt(Book::getPages));

		Optional<Book> minBook = books.stream()
				.min(Comparator.comparingInt(Book::getPages));


var libro =new BookMaxMinResponse(maxBook.get(), minBook.get(), String.valueOf(avgBook));

		return libro;

	}

	Book[] cargarLibros() {
		InputStream inputStream = getClass()
				.getClassLoader().getResourceAsStream(NAME_OFF_JSON);
		String jsonLibros = null;
		try {
			jsonLibros = new String(Objects.requireNonNull(metodoinventado).readAllBytes(), StandardCharsets.UTF_8);
		} catch (IOException e) {
			logger.error("Error reading JSON file", e);
		}
		final GsonBuilder gsonBuilder = new GsonBuilder();
		final Gson gson = gsonBuilder.create();
		return gson.fromJson(jsonLibros, Book[].class);
	}

}
