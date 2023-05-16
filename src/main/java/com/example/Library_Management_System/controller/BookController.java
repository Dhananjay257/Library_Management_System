package com.example.Library_Management_System.controller;

import com.example.Library_Management_System.dtos.requetsDto.BookRequestDto;
import com.example.Library_Management_System.dtos.responseDto.BookResponseDto;
import com.example.Library_Management_System.model.Book;
import com.example.Library_Management_System.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/book")
public class BookController {

    @Autowired
    BookService bookService;

    @PostMapping("/add")
    public String addBook(@RequestBody BookRequestDto bookRequestDto) throws Exception {

        return bookService.addBook(bookRequestDto);
    }

    @GetMapping("/get_all_books")
    public List<BookResponseDto> getAllBooks()
    {
         return bookService.getAll();
    }

    @GetMapping("/get_books_by_author_id")
    public List<BookResponseDto> getAllBooksByAuthorId(@RequestParam("id") int id)
    {
        return bookService.getBooksByAuthorId(id);
    }

    @GetMapping("/get_no_of_books_by_author")
    public String getBooksWrittenByAuthor(@RequestParam("id") int id)
    {
        return bookService.getNoOfBooksByAuthor(id);
    }
    // // find the number of books written by an author
}
