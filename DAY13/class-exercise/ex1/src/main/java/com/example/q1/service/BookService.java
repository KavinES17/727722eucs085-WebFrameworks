package com.example.q1.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.q1.model.Author;
import com.example.q1.model.Book;
import com.example.q1.repository.AuthorRepository;
import com.example.q1.repository.BookRepository;

@Service
public class BookService {
    @Autowired
    private BookRepository bookRepository;
@Autowired
private AuthorRepository authorRepository;
    public Book saveBook(Long authorId, Book book) {
        Author author = authorRepository.findById(authorId).orElse(null);
        if (author != null) {
            book.setAuthor(author);
            author.getBooks().add(book);
            return bookRepository.save(book);
        }
        return null;
    }

    public Book getBookById(Long id) {
        return bookRepository.findById(id).orElse(null);
    }

    public void deleteBook(Long id) {
        bookRepository.deleteById(id);
    }
}

