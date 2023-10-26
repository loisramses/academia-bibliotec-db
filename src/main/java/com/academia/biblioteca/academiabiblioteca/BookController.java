package com.academia.biblioteca.academiabiblioteca;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BookController {

    @Autowired
    private AcademiaDAOService service;

    @GetMapping("/books")
    public List<Book> getBooks() {
        return service.getAllBooks();
    }

    @GetMapping("/books/{id}")
    public Book getBook(@PathVariable Integer id) {
        Book retrievedBook = service.findOne(id);
        if (retrievedBook == null) throw new BookNotFoundException("Não encontrado, Livro ID: " + id);
        return retrievedBook;
    }

    @PostMapping("/books")
    public Book createBook(@RequestBody Book book) {
        return service.saveBook(book);
    }

    @DeleteMapping("/books/{id}")
    public Book deleteBook(@PathVariable Integer id) {
        Book deletedBook = service.deleteBookById(id);
        if (deletedBook == null) throw new BookNotFoundException("Não encontrado, Livro ID: " + id);
        return deletedBook;
    }
}