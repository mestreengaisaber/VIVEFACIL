package com.atam.vivefacilv1.application.controller;
import com.atam.vivefacilv1.application.dto.Book;
import com.atam.vivefacilv1.application.dto.BookAuthorDoBookResponse;
import com.atam.vivefacilv1.application.dto.BookMaxMinResponse;
import com.atam.vivefacilv1.application.service.BookService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



import java.util.List;


@RestController
@RequestMapping("/vivefacil")
@Tag(name = "ViveFacil API", description = "API for ViveFacil application")
public class ViveLibreRestController  {

	@Autowired
	BookService bookService;

	//. Filtra los libros con más de 400 páginas y aquellos cuyo título contenga"Harry"
	@GetMapping("/filterBooksWithPageAndTitle/{numPag}/{FilterTitle}")
	@Operation(summary = "View a list of available books filter with page and title",
			description = "Provides a list of books filtered by page number and title")

	public ResponseEntity<List<Book>> listarLibrosFiltradosCadena(@PathVariable int numPag, @PathVariable String FilterTitle )
	{
		ResponseEntity<List<Book>> response;
		response = new ResponseEntity<>(bookService.filtrarLibros(numPag, FilterTitle), HttpStatus.OK);
		return response;
	}

	//Obtén los libros escritos por "J.K. Rowling".
	@GetMapping("/filterBooksWriter/{writer}")
	public ResponseEntity<List<Book>> filtrarLibrosAutor(@PathVariable String writer )
	{
		ResponseEntity<List<Book>> response;
		response = new ResponseEntity<>(bookService.filtrarLibrosAutor(writer), HttpStatus.OK);
		return response;
	}

	//Lista los títulos ordenados alfabéticamente y cuenta cuántos libros ha
	//escrito cada autor.

	@GetMapping("/orderBooksWithAuthorCountBooks")
	public ResponseEntity<List<BookAuthorDoBookResponse>> filtrarLibrosAutor()
	{
		ResponseEntity<List<BookAuthorDoBookResponse>> response;
		response = new ResponseEntity<>(bookService.ordenarLibrosPorAuthorContarNumLibros(), HttpStatus.OK);
		return response;
	}

	@GetMapping("/filterBooksMaxMinAvg")
	public ResponseEntity<BookMaxMinResponse> filtrarLibrosMaxMinAvg()
	{
		ResponseEntity <BookMaxMinResponse> response;
		response = new ResponseEntity<BookMaxMinResponse>(bookService.filtrarLibrosMaxMinAvg(), HttpStatus.OK);;
		return response;
	}


}
