package com.example.demo.controller;

import com.example.demo.entity.Book;
import com.example.demo.services.BookServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")//this is the base url for api.but if you don't want to use this kind of url you can avoid this line
//so this api will be accessible from http://localhost:8080/
public class BookController {

    @Autowired
    private BookServices services;

    @GetMapping("/books")//you can give this any name you want and after adding this string to the end of base url you can use this
    public ResponseEntity<List<Book>> getAllBooks() {
        return ResponseEntity.ok(services.getBookList());
    }

    @GetMapping("/book/{id}")
    public ResponseEntity<Book> getBookById(@PathVariable int id) {
        return ResponseEntity.ok().body(this.services.getBookById(id));
    }

    @PostMapping("/addBook")
    public ResponseEntity<Book> addBook(@RequestBody Book book) {
        return ResponseEntity.ok(this.services.createBook(book));
    }

    @PostMapping("/addBooks")
    public ResponseEntity<List<Book>> addBooks(@RequestBody List<Book> list) {
        return ResponseEntity.ok(this.services.createBookList(list));
    }

    @PutMapping("/updateBooks/")
    public ResponseEntity<Book> updateBook(@RequestBody Book book) {
        return ResponseEntity.ok().body(this.services.updateBookById(book));
    }

    @DeleteMapping("/deleteBooks/{id}")
    public HttpStatus deleteBook(@PathVariable int id) {
        this.services.deleteBookById(id);
        return HttpStatus.OK;
    }
}
