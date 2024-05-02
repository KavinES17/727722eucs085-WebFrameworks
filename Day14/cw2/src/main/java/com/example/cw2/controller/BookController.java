package com.example.cw2.controller;

import com.example.cw2.model.Book;
import com.example.cw2.service.BookService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/book")
public class BookController {
    private final BookService bookService;

    public BookController(BookService BookService) {
        this.bookService = BookService;
    }

    @PostMapping
    public ResponseEntity<Book> createBook(@RequestBody Book Book) {
        Book createdBook = bookService.createBook(Book);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdBook);
    }

    @GetMapping
    public ResponseEntity<List<Book>> getAllBooks() {
        List<Book> Books = bookService.getAllBooks();
        return ResponseEntity.ok(Books);
    }
    @PutMapping("/{bookId}")
    public Book updateBookById(@PathVariable Long bookId,@RequestBody Book book){
        Book b = bookService.updateBookById(bookId, book);
        return b;
    }
    @GetMapping("/{bookId}")
    public Book getBookById(@PathVariable Long bookId) {
        Book book = bookService.getBookById(bookId);
        return book;
    }
}
