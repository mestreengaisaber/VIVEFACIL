package com.atam.vivefacilv1.application.service;

import com.atam.vivefacilv1.application.dto.Book;
import com.atam.vivefacilv1.application.dto.BookAuthorDoBookResponse;
import com.atam.vivefacilv1.application.dto.BookMaxMinResponse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BookServiceImplTest {


    private BookServiceImpl bookService;

    @BeforeEach
    void setUp() {
        bookService = new BookServiceImpl();
    }

    @Test
    void testfiltrarLibros() {
        List<Book> result = bookService.filtrarLibros(400, "Harry");
        assertNotNull(result);
        assertTrue(result.stream().allMatch(book -> book.getPages() > 400 && book.getTitle().contains("Harry")));
    }

    @Test
    void testfiltrarLibrosAutor() {
        List<Book> result = bookService.filtrarLibrosAutor("J.K. Rowling");
        assertNotNull(result);
        assertTrue(result.stream().allMatch(book -> book.getAuthor().getName().equals("J.K. Rowling")));
    }

    @Test
    void testordenarLibrosPorAuthorContarNumLibros() {
        List<BookAuthorDoBookResponse> result = bookService.ordenarLibrosPorAuthorContarNumLibros();
        assertNotNull(result);
        assertFalse(result.isEmpty());
    }

    @Test
    void testfiltrarLibrosMaxMinAvg() {
        BookMaxMinResponse result = bookService.filtrarLibrosMaxMinAvg();
        assertNotNull(result);
        assertNotNull(result.bookmax());
        assertNotNull(result.bookmin());
        assertNotNull(result.avg());
    }

    @Test
    void testcargarLibros() {
        Book[] result = bookService.cargarLibros();
        assertNotNull(result);
        assertTrue(result.length > 0);
    }
}