# LibraryMVC - Spring MVC Web Request Handling Demo

## Skill 6: Spring Boot REST Controller

---

## Project Structure

```
LibraryMVC/
├── pom.xml
└── src/main/
    ├── java/com/library/
    │   ├── LibraryApplication.java        ← Run this (Spring Boot main)
    │   ├── controller/
    │   │   └── LibraryController.java     ← All REST endpoints
    │   └── model/
    │       └── Book.java                  ← Book model class
    └── resources/
        └── application.properties
```

---

## How to Run in Eclipse

1. File → Import → Maven → Existing Maven Projects → Browse to LibraryMVC → Finish
2. Wait for Maven to download Spring Boot dependencies
3. Right-click `LibraryApplication.java` → Run As → Java Application
4. Open browser and test the URLs below

---

## All Endpoints

| Method | URL | Description |
|--------|-----|-------------|
| GET | /library/welcome | Welcome message |
| GET | /library/count | Total number of books |
| GET | /library/price | Sample book price |
| GET | /library/books | List of all book titles |
| GET | /library/books/{id} | Book details by ID |
| GET | /library/search?title=Clean | Search by title keyword |
| GET | /library/author/{name} | Message with author name |
| GET | /library/viewbooks | All books as JSON |
| POST | /library/addbook | Add a new book (JSON body) |

---

## Test POST /addbook

Use browser extension Talend API Tester or Postman:
- Method: POST
- URL: http://localhost:8080/library/addbook
- Body (raw JSON):
```json
{
  "id": 6,
  "title": "Effective Java",
  "author": "Joshua Bloch",
  "price": 699.00
}
```
