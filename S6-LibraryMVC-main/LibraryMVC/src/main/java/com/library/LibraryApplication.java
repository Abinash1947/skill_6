package com.library;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * LibraryApplication.java
 *
 * Main entry point for the Spring Boot application.
 *
 * @SpringBootApplication combines:
 *   @Configuration     - marks as config class
 *   @EnableAutoConfiguration - Spring Boot auto-configures everything
 *   @ComponentScan     - scans com.library package for @RestController etc.
 *
 * When you run this:
 *   - Embedded Tomcat starts on port 8080
 *   - All @RestController endpoints become available
 *   - No need to deploy to external server!
 */
@SpringBootApplication
public class LibraryApplication {

    public static void main(String[] args) {
        SpringApplication.run(LibraryApplication.class, args);
        System.out.println("\n============================================");
        System.out.println("  Library System Started Successfully!");
        System.out.println("  Open browser and test these URLs:");
        System.out.println("--------------------------------------------");
        System.out.println("  GET  http://localhost:8080/library/welcome");
        System.out.println("  GET  http://localhost:8080/library/count");
        System.out.println("  GET  http://localhost:8080/library/price");
        System.out.println("  GET  http://localhost:8080/library/books");
        System.out.println("  GET  http://localhost:8080/library/books/1");
        System.out.println("  GET  http://localhost:8080/library/search?title=Clean");
        System.out.println("  GET  http://localhost:8080/library/author/Craig Walls");
        System.out.println("  GET  http://localhost:8080/library/viewbooks");
        System.out.println("  POST http://localhost:8080/library/addbook");
        System.out.println("============================================\n");
    }
}
