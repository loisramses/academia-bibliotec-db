package com.academia.biblioteca.academiabiblioteca;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BookDbController {
    @Autowired
    private BookRepository bookRepository;

    @GetMapping("/db/books")
    public List<Book> getBooks() {
        return bookRepository.findAll();
    }

    @GetMapping("/db/books/{id}")
    public Optional<Book> getBook(@PathVariable Integer id) {
        Optional<Book> retrievedBook = bookRepository.findById(id);
        if (!retrievedBook.isPresent()) throw new BookNotFoundException("Não encontrado, Livro ID: " + id);
        return retrievedBook;
    }

    @PostMapping("/db/books")
    public Book createBook(@RequestBody Book book) {
        return bookRepository.save(book);
    }

    @DeleteMapping("/db/books/{id}")
    public void deleteBook(@PathVariable Integer id) {
        bookRepository.deleteById(id);
    }
}