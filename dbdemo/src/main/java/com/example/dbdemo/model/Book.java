package com.example.dbdemo.model;

import javax.persistence.*;

@Entity
@Table(name="book_tb")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int bookId; //BOOK_ID
    @Column(name="NAME")
    private String bookName; //BOOK_NAME


    private  int noOfPages; //NO_OF_PAGES
    private String publicationName;//PUBLICATION_NAME
    private String authorName;//AUTHOR_NAME

    public Book() {
    }

    public Book(int bookId, String bookName, int noOfPages, String publicationName, String authorName) {
        this.bookId = bookId;
        this.bookName = bookName;
        this.noOfPages = noOfPages;
        this.publicationName = publicationName;
        this.authorName = authorName;
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public int getNoOfPages() {
        return noOfPages;
    }

    public void setNoOfPages(int noOfPages) {
        this.noOfPages = noOfPages;
    }

    public String getPublicationName() {
        return publicationName;
    }

    public void setPublicationName(String publicationName) {
        this.publicationName = publicationName;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    @Override
    public String toString() {
        return "Book{" +
                "bookId=" + bookId +
                ", bookName='" + bookName + '\'' +
                ", noOfPages=" + noOfPages +
                ", publicationName='" + publicationName + '\'' +
                ", authorName='" + authorName + '\'' +
                '}';
    }
}
