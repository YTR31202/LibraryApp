package com.example.dbdemo.controller;

import com.example.dbdemo.dto.BookRequestDTO;
import com.example.dbdemo.dto.BookResponseDTO;
import com.example.dbdemo.model.Book;
import com.example.dbdemo.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class BookController {

    @Autowired
    private BookService bookService;
    @GetMapping("/books")
    public List<BookResponseDTO> getBooks(){
            return bookService.getAllBooks();
    }
    @PostMapping("/postbooks")
    public BookResponseDTO createBook(@RequestBody BookRequestDTO bookRequestDTO){
     return bookService.addBook(bookRequestDTO);
    }
    @GetMapping("/books/{bookId}")
    public BookResponseDTO getBookById(@PathVariable int bookId){
        return bookService.getBook(bookId);
    }
    @PutMapping("/books/{bookId}")
    public BookResponseDTO updateBookById(@PathVariable int bookId,@RequestBody  BookRequestDTO bookRequestDTO){
        return bookService.updateBook(bookId,bookRequestDTO);
    }
    @DeleteMapping("/books/{bookId}")
    public BookResponseDTO deleteBookById(@PathVariable int bookId){
        return bookService.deleteBookById(bookId);
    }
}
