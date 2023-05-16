package com.example.Library_Management_System.transformer;

import com.example.Library_Management_System.dtos.requetsDto.BookRequestDto;
import com.example.Library_Management_System.dtos.responseDto.AuthorResponseDto;
import com.example.Library_Management_System.dtos.responseDto.BookResponseDto;
import com.example.Library_Management_System.model.Author;
import com.example.Library_Management_System.model.Book;

public class BookTransformer {

    public static BookResponseDto bookTobookResponseDto(Book book)
    {
        BookResponseDto bookResponseDto = new BookResponseDto();
        bookResponseDto.setBookName(book.getTitle());
        return bookResponseDto;

    }
    public static Book bookRequestDtoToBook(BookRequestDto bookRequestDto)
    {
        Book book=new Book();
        book.setTitle(bookRequestDto.getTitle());
        book.setIssued(bookRequestDto.isIssued());
        book.setNumberOfPages(bookRequestDto.getNumberOfPages());
        book.setGenre(bookRequestDto.getGenre());
        book.setPrice(bookRequestDto.getPrice());
        book.setAuthor(bookRequestDto.getAuthor());

        return book;
    }
}
