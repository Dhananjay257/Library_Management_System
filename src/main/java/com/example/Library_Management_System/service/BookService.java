package com.example.Library_Management_System.service;

import com.example.Library_Management_System.dtos.requetsDto.BookRequestDto;
import com.example.Library_Management_System.dtos.responseDto.BookResponseDto;
import com.example.Library_Management_System.model.Book;

import java.util.List;

public interface BookService {
    public String addBook(BookRequestDto bookRequestDto) throws Exception;
    public List<BookResponseDto> getAll();

    public List<BookResponseDto> getBooksByAuthorId(int id);

    public String getNoOfBooksByAuthor(int id);
}
