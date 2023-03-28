package com.example.dbdemo.service;

import com.example.dbdemo.dto.BookRequestDTO;
import com.example.dbdemo.dto.BookResponseDTO;
import com.example.dbdemo.exception.BookNotFoundException;
import com.example.dbdemo.model.Book;
import com.example.dbdemo.repo.BookRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class BookServiceImpl implements BookService{
    @Autowired
    private BookRepo bookRepo;
    @Override
    public List<BookResponseDTO> getAllBooks() {
        List<Book> bookList = bookRepo.findAll();
        List<BookResponseDTO> bookResponseDTOList = new ArrayList<BookResponseDTO>();
        bookResponseDTOList =  bookList.stream().map((book)->{
            BookResponseDTO bookResponseDTO = new BookResponseDTO();
            bookResponseDTO.setBookId(book.getBookId());
            bookResponseDTO.setBookName(book.getBookName());
            bookResponseDTO.setAuthorName(book.getAuthorName());
            bookResponseDTO.setPublicationName(book.getPublicationName());
            bookResponseDTO.setNoOfPages(book.getNoOfPages());
            return bookResponseDTO;
        }).collect(Collectors.toList());
        return bookResponseDTOList;
    }

    @Override
    public BookResponseDTO addBook(BookRequestDTO bookRequestDTO) {
        Book book = new Book();
        book.setBookName(bookRequestDTO.getBookName());
        book.setAuthorName(bookRequestDTO.getAuthorName());
        book.setNoOfPages(bookRequestDTO.getNoOfPages());
        book.setPublicationName(bookRequestDTO.getPublicationName());
        Book savedBook =  bookRepo.save(book);
        BookResponseDTO bookResponseDTO = new BookResponseDTO();
        bookResponseDTO.setBookId(savedBook.getBookId());
        bookResponseDTO.setBookName(savedBook.getBookName());
        bookResponseDTO.setNoOfPages(savedBook.getNoOfPages());
        bookResponseDTO.setPublicationName(savedBook.getPublicationName());
        bookResponseDTO.setAuthorName(savedBook.getAuthorName());
        return bookResponseDTO;
    }

    @Override
    public BookResponseDTO getBook(int bookId) {
        Optional<Book> bookOptional = bookRepo.findById(bookId);

        if(bookOptional.isPresent()){
            Book searchedBook =  bookOptional.get();
            BookResponseDTO bookResponseDTO = new BookResponseDTO();
            bookResponseDTO.setBookId(searchedBook.getBookId());
            bookResponseDTO.setBookName(searchedBook.getBookName());
            bookResponseDTO.setNoOfPages(searchedBook.getNoOfPages());
            bookResponseDTO.setPublicationName(searchedBook.getPublicationName());
            bookResponseDTO.setAuthorName(searchedBook.getAuthorName());
            return bookResponseDTO;
        }else{
            throw new BookNotFoundException("The Book with ID : "+bookId + " is not present.");
        }

    }

    @Override
    public BookResponseDTO updateBook(int bookId, BookRequestDTO bookRequestDTO) {
        Optional<Book> bookOptional = bookRepo.findById(bookId);
        if(bookOptional.isPresent()){
            //If present then updation will happen
            Book searchedBook = bookOptional.get();
            searchedBook.setBookName(bookRequestDTO.getBookName());
            searchedBook.setAuthorName(bookRequestDTO.getAuthorName());
            searchedBook.setPublicationName(bookRequestDTO.getPublicationName());
            searchedBook.setNoOfPages(bookRequestDTO.getNoOfPages());
            bookRepo.flush();
            BookResponseDTO bookResponseDTO = new BookResponseDTO();
            bookResponseDTO.setBookId(searchedBook.getBookId());
            bookResponseDTO.setBookName(searchedBook.getBookName());
            bookResponseDTO.setNoOfPages(searchedBook.getNoOfPages());
            bookResponseDTO.setPublicationName(searchedBook.getPublicationName());
            bookResponseDTO.setAuthorName(searchedBook.getAuthorName());
            return bookResponseDTO;
        }else{
            //A new book will be created
            Book newBook = new Book();
            newBook.setBookName(bookRequestDTO.getBookName());
            newBook.setAuthorName(bookRequestDTO.getAuthorName());
            newBook.setPublicationName(bookRequestDTO.getPublicationName());
            newBook.setNoOfPages(bookRequestDTO.getNoOfPages());
            Book savedBook = bookRepo.save(newBook);
            BookResponseDTO bookResponseDTO = new BookResponseDTO();
            bookResponseDTO.setBookId(savedBook.getBookId());
            bookResponseDTO.setBookName(savedBook.getBookName());
            bookResponseDTO.setNoOfPages(savedBook.getNoOfPages());
            bookResponseDTO.setPublicationName(savedBook.getPublicationName());
            bookResponseDTO.setAuthorName(savedBook.getAuthorName());
            return bookResponseDTO;
        }

    }

    @Override
    public BookResponseDTO deleteBookById(int bookId) {
        Optional<Book> bookOptional = bookRepo.findById(bookId);
        if(bookOptional.isPresent()){
            Book deletedBook = bookOptional.get();
            bookRepo.delete(deletedBook);
            BookResponseDTO bookResponseDTO = new BookResponseDTO(deletedBook);
            return bookResponseDTO;
        }else{
            throw new BookNotFoundException("Book having ID : "+bookId+ " not present in DB");
        }

    }
}
