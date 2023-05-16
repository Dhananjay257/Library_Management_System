package com.example.Library_Management_System.service.impl;

import com.example.Library_Management_System.dtos.requetsDto.AuthorRequestDto;
import com.example.Library_Management_System.dtos.requetsDto.BookRequestDto;
import com.example.Library_Management_System.dtos.responseDto.BookResponseDto;
import com.example.Library_Management_System.model.Author;
import com.example.Library_Management_System.model.Book;
import com.example.Library_Management_System.repository.AuthorRepository;
import com.example.Library_Management_System.repository.BookRepository;
import com.example.Library_Management_System.service.BookService;
import com.example.Library_Management_System.transformer.AuthorTransformer;
import com.example.Library_Management_System.transformer.BookTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    AuthorRepository authorRepository;

    @Autowired
    BookRepository bookRepository;

    @Override
    public String addBook(BookRequestDto bookRequestDto) throws Exception {

        Author author;
        Book book= BookTransformer.bookRequestDtoToBook(bookRequestDto);
        try{
            author = authorRepository.findById(book.getAuthor().getId()).get();
        }
        catch (Exception e){
            throw new Exception("Author not present");
        }

        author.getBooks().add(book);
        book.setAuthor(author);

        authorRepository.save(author);
        return "Book added";

    }

    @Override
    public List<BookResponseDto> getAll() {
        List<Book> books = bookRepository.findAll().stream().toList();
        List<BookResponseDto> bookResponseDtos=new ArrayList<>();
        for (Book book: books)
        {
            bookResponseDtos.add(BookTransformer.bookTobookResponseDto(book));
        }
        return bookResponseDtos;
    }

    @Override
    public List<BookResponseDto> getBooksByAuthorId(int id) {
        List<Book> books= bookRepository.findAll().stream().toList();
        List<BookResponseDto> bookResponseDtos = new ArrayList<>();

        for(Book book : books)
        {
            if (book.getAuthor().getId()==id)
            {
                bookResponseDtos.add(BookTransformer.bookTobookResponseDto(book));
            }
        }
            return bookResponseDtos;
    }

    @Override
    public String getNoOfBooksByAuthor(int id) {
         Author author = authorRepository.findById(id).get();
         int count = author.getBooks().size();
         return "No of books written by author: "+count;
    }


}
