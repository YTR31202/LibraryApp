package com.example.dbdemo.dto;

import com.example.dbdemo.model.Book;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Setter
@Getter
public class BookResponseDTO {
    private int bookId;
    private String bookName;
    private  int noOfPages;
    private String publicationName;
    private String authorName;
    public BookResponseDTO(Book book){
        this.setNoOfPages(book.getNoOfPages());
        this.setBookId(book.getBookId());
        this.setPublicationName(book.getPublicationName());
         this.setBookName(book.getBookName());
       this.setAuthorName(book.getAuthorName());
    }
}
