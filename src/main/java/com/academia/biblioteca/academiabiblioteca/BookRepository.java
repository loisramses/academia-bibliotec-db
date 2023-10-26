package com.academia.biblioteca.academiabiblioteca;

import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Integer> {
    
}
