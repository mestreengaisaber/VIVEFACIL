package com.atam.vivefacilv1.application.service;

import java.util.List;

import com.atam.vivefacilv1.application.dto.Book;
import com.atam.vivefacilv1.application.dto.BookAuthorDoBookResponse;
import com.atam.vivefacilv1.application.dto.BookMaxMinResponse;






public interface BookService {

	List<Book> filtrarLibros(int numPag, String FilterTitle);
	List<Book> filtrarLibrosAutor(String writer);
	List<BookAuthorDoBookResponse> ordenarLibrosPorAuthorContarNumLibros();
	//4? //) Convierte publicationTimestamp a a formato AAAA-MM-DD
	BookMaxMinResponse filtrarLibrosMaxMinAvg();
	//6) Añade un campo wordCount 250 palabras por página) y agrupa los libros por autor
	//? modificar el json en codigo?
	//8. (Opcional) Identifica los libros más recientes.


}
