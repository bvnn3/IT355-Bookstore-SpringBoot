package com.bookstore.IT355_Project.controller;

import com.bookstore.IT355_Project.entity.Book;
import com.bookstore.IT355_Project.entity.Publisher;
import com.bookstore.IT355_Project.entity.Writer;
import com.bookstore.IT355_Project.service.BookService;
import com.bookstore.IT355_Project.service.PublisherService;
import com.bookstore.IT355_Project.service.WriterService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Controller
@RequestMapping("/book")
@RequiredArgsConstructor
public class BookController {
    private final BookService bookService;

    @GetMapping("/getAll")
    public ResponseEntity<List<Book>> getAll(){
        return ResponseEntity.ok(bookService.findAll());
    }

    @GetMapping("/{bookId}")
    public ResponseEntity<Book> getById(@PathVariable Integer bookId){
        return ResponseEntity.ok(bookService.findById(bookId).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "bookNotFound")));
    }

    @PostMapping("/addBook")
    public ResponseEntity<Book> save(@RequestBody Book book){
        return ResponseEntity.ok(bookService.save(book));
    }

    @PutMapping("/updateBook")
    public ResponseEntity<Book> update(@RequestBody Book book){
        return ResponseEntity.ok(bookService.update(book));
    }

    @DeleteMapping("/{bookId}")
    public ResponseEntity<Book> deleteById(@PathVariable Integer bookId){
        bookService.deleteById(bookId);
        return ResponseEntity.ok().build();
    }
}
