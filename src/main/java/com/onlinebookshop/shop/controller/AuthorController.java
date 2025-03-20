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

import com.onlinebookshop.shop.model.Author;
import com.onlinebookshop.shop.service.AuthorService;

@Controller
@RequestMapping("/api/authors")
@CrossOrigin(origins = "http://localhost:3000")
public class AuthorController {

    private final AuthorService authorService;

    @Autowired
    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }

    @GetMapping
    @ResponseBody
    public List<Author> fetchAuthors() {
        return authorService.getAllAuthors();
    }

    @GetMapping("/{id}")
    @ResponseBody
    public Author fetchAuthorById(@PathVariable("id") int id) {
        return authorService.getAuthorById(id);
    }

    @GetMapping("/redirect")
    public String showAuthor() {
        return "redirect:/authors.html";
    }

    @PostMapping
    @ResponseBody
    public ResponseEntity<String> addAuthor(@RequestBody Author author) {
        authorService.addAuthor(author);
        return ResponseEntity.ok("Author added successfully");
    }

    @DeleteMapping("/{id}")
    @ResponseBody
    public ResponseEntity<String> deleteAuthor(@PathVariable int id) {
        try {
            int rowsAffected = authorService.deleteAuthor(id);
            if (rowsAffected > 0) {
                return ResponseEntity.ok("Author deleted successfully");
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Author not found");
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error deleting author");
        }
    }

    @PutMapping("/{id}")
    @ResponseBody
    public ResponseEntity<String> updateAuthor(@PathVariable int id, @RequestBody Author author) {
        try {
            author.setId(id);
            int rowsAffected = authorService.updateAuthor(author);
            if (rowsAffected > 0) {
                return ResponseEntity.ok("Author updated successfully");
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Author not found");
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error updating author");
        }
    }
}
