package com.example.Library_Management_System.transformer;

import com.example.Library_Management_System.dtos.requetsDto.AuthorRequestDto;
import com.example.Library_Management_System.dtos.responseDto.AuthorResponseDto;
import com.example.Library_Management_System.model.Author;

public class AuthorTransformer {
    public static AuthorResponseDto authorToAuthorResponseDto(Author author)
    {
        AuthorResponseDto authorResponseDto = new AuthorResponseDto();
        authorResponseDto.setAge(author.getAge());
        authorResponseDto.setName(author.getName());
        return authorResponseDto;
    }

    public static Author authorRequestDtotoAuthor(AuthorRequestDto authorRequestDto)
    {
        Author author = new Author();
        author.setName(authorRequestDto.getName());
        author.setAge(authorRequestDto.getAge());
        author.setEmail(authorRequestDto.getEmail());
        return author;
    }
}
