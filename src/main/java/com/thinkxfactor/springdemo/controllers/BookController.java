package com.thinkxfactor.springdemo.controllers;

import java.util.List;

import com.thinkxfactor.springdemo.entity.Book;
import com.thinkxfactor.springdemo.repository.BookRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/book")
public class BookController {

    @Autowired
    BookRepository bookRepository;
    // CRUD operation

    // Create will be POST
    @PostMapping("/addBook")
    public Book addBooks(@RequestBody Book book) {
        return bookRepository.save(book);
    }

    // Read will be GET
    @GetMapping("/getAllBooks")
    public List<Book> getBook() {
        return bookRepository.findAll();
    }

    @GetMapping("/getBook/{isbn}")
    public Book getBook(@PathVariable Long isbn) {
        return bookRepository.findById(isbn).get();
    }

    // Update will be PUT/POST
    @PutMapping("/updateBook")
    public Book updateBooks(@RequestBody Book book) {
        return bookRepository.save(book);
    }

    // Delete will be GET/DELETE
    @DeleteMapping("/deleteBook/{isbn}")
    public void deleteBook(@PathVariable Long bid) {
        bookRepository.deleteById(bid);
    }

}
