package com.library.model;

/**
 * Book.java
 * Model class representing a Book in the library.
 * Used as request body in @PostMapping for /addbook endpoint.
 * Spring automatically converts JSON → Book object (deserialization)
 * and Book object → JSON (serialization) using Jackson.
 */
public class Book {

    private int id;
    private String title;
    private String author;
    private double price;

    // Default constructor (required for JSON deserialization)
    public Book() {}

    // Parameterized constructor
    public Book(int id, String title, String author, double price) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.price = price;
    }

    // Getters and Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getAuthor() { return author; }
    public void setAuthor(String author) { this.author = author; }

    public double getPrice() { return price; }
    public void setPrice(double price) { this.price = price; }

    @Override
    public String toString() {
        return "Book{id=" + id + ", title='" + title + "', author='" + author + "', price=" + price + "}";
    }
}
