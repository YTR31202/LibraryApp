package com.example.dbdemo.service;

import com.example.dbdemo.dto.BookRequestDTO;
import com.example.dbdemo.dto.BookResponseDTO;
import com.example.dbdemo.model.Book;

import java.util.List;

public interface BookService {
    List<BookResponseDTO> getAllBooks();

    BookResponseDTO addBook(BookRequestDTO bookRequestDTO);

    BookResponseDTO getBook(int bookId);

    BookResponseDTO updateBook(int bookId, BookRequestDTO bookRequestDTO);

    BookResponseDTO deleteBookById(int bookId);
}
