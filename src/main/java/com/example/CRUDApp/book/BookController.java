package com.example.CRUDApp.book;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "api/v1/books")
public class BookController {

    @Autowired
    private BookRepository repository;

    @Autowired
    private BookService bookService;

    @GetMapping("/")
    public List<Book> getAllBooks(){
        return bookService.getBooks();
    }

    @GetMapping("/{id}")
    public Book getBookByID(@PathVariable Long id){
        return bookService.getBookById(id);

    }

    @PostMapping("/")
    public void addBook(@RequestBody Book book){
        bookService.addBook(book);
    }

    @PutMapping("/{id}")
    public void updateBookByID(
            @PathVariable("id") Long id,
            @RequestParam String title,
            @RequestParam String author) {

        bookService.updateBook(id,author, title);
    }




    @DeleteMapping("/{id}")
    public void deleteBookByID(@PathVariable("id") Long id){

        bookService.deleteByID(id);
    }
}
