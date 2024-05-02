package com.example.cw2.service;

import com.example.cw2.model.Book;
import com.example.cw2.repository.BookRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {
    private final BookRepo bookRepo;

    public BookService(BookRepo bookRepo) {
        this.bookRepo = bookRepo;
    }

    public Book createBook(Book Book) {
        return bookRepo.save(Book);
    }
    public List<Book> getAllBooks() {
        return bookRepo.findAll();
    }
    public Book getBookById(Long id) {
        return bookRepo.findById(id).orElse(null);
    }
    public Book updateBookById(Long id,Book book){
        Book b = bookRepo.findById(id).orElse(null);
        if(b!=null){
            b.setAuthor(book.getAuthor());
            b.setAvailableCopies(book.getAvailableCopies());
            b.setTitle(book.getTitle());
            b.setTotalCopies(book.getTotalCopies());
            bookRepo.save(b);
        }
        return b;
    }
}
