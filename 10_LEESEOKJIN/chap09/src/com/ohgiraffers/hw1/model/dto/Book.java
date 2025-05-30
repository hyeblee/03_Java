package com.ohgiraffers.hw1.model.dto;

public class Book {
    private String title;
    private String author;
    private String publisher;

    public Book() {}
    public Book(String title, String author, String publisher) {
        this.title = title;
        this.author = author;
        this.publisher = publisher;
    }

    @Override
    public String toString() {
        return title + " / " + author + " / " + publisher;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getPublisher() {
        return publisher;
    }
}
