package com.library.controller;

import com.library.model.Book;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * LibraryController.java
 *
 * Spring MVC REST Controller for the Online Library System.
 * Demonstrates all required request handling techniques:
 *
 *   @RestController   - marks class as REST controller (returns JSON/text)
 *   @RequestMapping   - base URL mapping for all endpoints
 *   @GetMapping       - handles HTTP GET requests
 *   @PostMapping      - handles HTTP POST requests
 *   @PathVariable     - extracts value from the URL path
 *   @RequestParam     - extracts query parameter from URL
 *   @RequestBody      - converts JSON request body to Java object
 *
 * Base URL: http://localhost:8080/library
 */
@RestController
@RequestMapping("/library")
public class LibraryController {

    // In-memory list to store books (no database needed)
    private List<Book> bookList = new ArrayList<>();

    // Pre-load some books when the app starts
    public LibraryController() {
        bookList.add(new Book(1, "Clean Code",              "Robert C. Martin", 599.00));
        bookList.add(new Book(2, "The Pragmatic Programmer","Andrew Hunt",       749.00));
        bookList.add(new Book(3, "Design Patterns",         "Gang of Four",      899.00));
        bookList.add(new Book(4, "Spring in Action",        "Craig Walls",       649.00));
        bookList.add(new Book(5, "Java: The Complete Guide","Herbert Schildt",   799.00));
    }

    // ==============================================================
    // TASK 2: GET /welcome - Returns a welcome message
    // URL: http://localhost:8080/library/welcome
    // ==============================================================
    @GetMapping("/welcome")
    public String welcome() {
        return "Welcome to the Online Library System!";
    }

    // ==============================================================
    // TASK 3: GET /count - Returns total number of books (integer)
    // URL: http://localhost:8080/library/count
    // ==============================================================
    @GetMapping("/count")
    public int getTotalBooks() {
        return bookList.size();
    }

    // ==============================================================
    // TASK 4: GET /price - Returns a sample book price as double
    // URL: http://localhost:8080/library/price
    // ==============================================================
    @GetMapping("/price")
    public double getSamplePrice() {
        return 599.99;
    }

    // ==============================================================
    // TASK 5: GET /books - Returns list of all book titles
    // URL: http://localhost:8080/library/books
    // ==============================================================
    @GetMapping("/books")
    public List<String> getAllBookTitles() {
        List<String> titles = new ArrayList<>();
        for (Book book : bookList) {
            titles.add(book.getTitle());
        }
        return titles;
    }

    // ==============================================================
    // TASK 6: GET /books/{id} - Returns book details by ID
    // Uses @PathVariable to extract {id} from the URL
    // URL: http://localhost:8080/library/books/1
    // ==============================================================
    @GetMapping("/books/{id}")
    public Book getBookById(@PathVariable int id) {
        for (Book book : bookList) {
            if (book.getId() == id) {
                return book;
            }
        }
        return null; // Returns 200 with null body if not found
    }

    // ==============================================================
    // TASK 7: GET /search?title=Clean - Search by title
    // Uses @RequestParam to get the 'title' query parameter
    // URL: http://localhost:8080/library/search?title=Clean
    // ==============================================================
    @GetMapping("/search")
    public String searchByTitle(@RequestParam String title) {
        for (Book book : bookList) {
            if (book.getTitle().toLowerCase().contains(title.toLowerCase())) {
                return "Book found: '" + book.getTitle() + "' by " + book.getAuthor();
            }
        }
        return "No book found with title containing: " + title;
    }

    // ==============================================================
    // TASK 8: GET /author/{name} - Returns message with author name
    // Uses @PathVariable to extract {name} from URL
    // URL: http://localhost:8080/library/author/Craig Walls
    // ==============================================================
    @GetMapping("/author/{name}")
    public String getByAuthor(@PathVariable String name) {
        return "Fetching books by author: " + name;
    }

    // ==============================================================
    // TASK 9: POST /addbook - Accepts a Book JSON object in body
    // Uses @RequestBody to convert JSON → Book object
    // URL: http://localhost:8080/library/addbook
    // Body (JSON): {"id":6,"title":"Effective Java","author":"Joshua Bloch","price":699.00}
    // ==============================================================
    @PostMapping("/addbook")
    public String addBook(@RequestBody Book book) {
        bookList.add(book);
        return "Book added successfully: " + book.getTitle() + " (Total books: " + bookList.size() + ")";
    }

    // ==============================================================
    // TASK 10: GET /viewbooks - Returns all Book objects as JSON
    // URL: http://localhost:8080/library/viewbooks
    // ==============================================================
    @GetMapping("/viewbooks")
    public List<Book> getAllBooks() {
        return bookList;
    }
}
