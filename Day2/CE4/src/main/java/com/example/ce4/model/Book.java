package com.example.ce4.model;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class Book {
    public String name;
    public String author;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    public Date publicationDate;

    public Book(String name, String author) {
        this.name = name;
        this.author = author;
        this.publicationDate = new Date();
    }

    
}
