package com.example.dbdemo.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@Getter
@Setter
@ToString
public class BookRequestDTO {
    private String bookName;
    private  int noOfPages;
    private String publicationName;
    private String authorName;
}
