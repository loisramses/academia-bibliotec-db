package com.academia.biblioteca.academiabiblioteca;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class AcademiaDAOService {
    private static List<Book> books = new ArrayList<>();
    private static int booksCount = 3;

    // hard coded book list
    static {
        books.add(new Book(0, "O conto do gatito", "João Ferraz"));
        books.add(new Book(1, "As histórias do Jorge", "Adsdrubal Rodízio"));
        books.add(new Book(2, "O Senhor dos Anéis", "Um gajo qualquer"));
    }

    public List<Book> getAllBooks() {
        return books;
    }

    public Book saveBook(Book book) {
        if (book.getId() == null) book.setId(booksCount);
        booksCount++;
        books.add(book);
        return book;
    }

    public Book findOne(Integer id) {
        for (Book book : books)
            if (book.getId() == id)
                return book;
        return null;
    }

    public Book deleteBookById(Integer id) {
        Iterator<Book> iterator = books.iterator();
        while (iterator.hasNext()) {
            Book book = iterator.next();
            if (book.getId() == id) {
                iterator.remove();
                booksCount--;
                return book;
            }
        }
        return null;
    }
}
