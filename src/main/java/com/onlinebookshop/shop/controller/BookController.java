package com.onlinebookshop.shop.controller;
 
import java.util.List;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
 
import com.onlinebookshop.shop.model.Book;
import com.onlinebookshop.shop.service.BookService;
 
//@Controller
@RestController
@RequestMapping("/api/books")
@CrossOrigin(origins = "http://localhost:3000")
public class BookController {
 
    private final BookService bookService;
    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }
 
    @GetMapping
    @ResponseBody
    public ResponseEntity<List<Book>> fetchBooks() {
    	List<Book> books = bookService.getAllBooks();
        return ResponseEntity.ok(books);  //return 200 - ok status
    }
    @GetMapping("/{id}")
    
    public ResponseEntity<Book> fetchBookById(@PathVariable("id") int id) {
        Book book = bookService.getBookById(id);
        return ResponseEntity.ok(book);
 
    }
 
//    @GetMapping("/redirect")
//    public String showBook() {
//        return "redirect:/books.html";
//    }
    @PostMapping
    @ResponseBody
    public ResponseEntity<String> addBook(@RequestBody Book book) {
        bookService.addBook(book);
        return ResponseEntity.ok("Book added successfully");
    }
    @DeleteMapping("/{id}")
    @ResponseBody
    public ResponseEntity<String> deleteBook(@PathVariable int id) {
        try {
            int rowsAffected = bookService.deleteBook(id);
            if (rowsAffected > 0) {
                return ResponseEntity.ok("Book Deleted Successfully");
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Book Not Found");
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error Deleting Book");
        }
    }
 
    @PutMapping("/{id}")
    @ResponseBody
    public ResponseEntity<String> updateBook(@PathVariable int id, @RequestBody Book book) {
        try {
            book.setId(id);
            int rowsAffected = bookService.updateBook(book);
            if (rowsAffected > 0) {
                return ResponseEntity.ok("Book updated successfully");
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Book not found");
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error updating book");
        }
    }
}