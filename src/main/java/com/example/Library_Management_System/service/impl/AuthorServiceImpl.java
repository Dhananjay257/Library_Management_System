package com.example.Library_Management_System.service.impl;

import com.example.Library_Management_System.dtos.requetsDto.AuthorRequestDto;
import com.example.Library_Management_System.dtos.responseDto.AuthorResponseDto;
import com.example.Library_Management_System.exception.AuthorNotFoundException;
import com.example.Library_Management_System.model.Author;
import com.example.Library_Management_System.repository.AuthorRepository;
import com.example.Library_Management_System.service.AuthorService;
import com.example.Library_Management_System.transformer.AuthorTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Service
public class AuthorServiceImpl implements AuthorService {

    @Autowired
    AuthorRepository authorRepository;

    @Override
    public String addAuthor(AuthorRequestDto authorRequestDto) {
       Author author = AuthorTransformer.authorRequestDtotoAuthor(authorRequestDto);
        authorRepository.save(author);
        return "Author added";
    }

    @Override
    public AuthorResponseDto getByEmail(String email) {

        Author author = authorRepository.findByEmail(email);

        // prepare response Dto
        AuthorResponseDto authorResponseDto = new AuthorResponseDto();
        authorResponseDto.setName(author.getName());
        authorResponseDto.setAge(author.getAge());

        return authorResponseDto;
    }

    @Override
    public ResponseEntity deleteById(int id) throws AuthorNotFoundException {
          try{
              if(authorRepository.findById(id).isPresent())
              {
                  authorRepository.deleteById(id);
                  return new ResponseEntity<>("Author removed",HttpStatus.CREATED);
              }
              else
              {
                  throw new AuthorNotFoundException(HttpStatus.BAD_REQUEST, "Author not found");
              }
          }
          catch (AuthorNotFoundException e)
          {
              return new ResponseEntity<>(e.getMessage(),HttpStatus.NOT_FOUND);
          }
    }
    public ResponseEntity getById(int id)
    {
        try{
            if(authorRepository.findById(id).isPresent())
            {
                Author author = authorRepository.findById(id).get();
                AuthorResponseDto authorResponseDto = new AuthorResponseDto();
                authorResponseDto.setName(author.getName());
                authorResponseDto.setAge(author.getAge());
                return new ResponseEntity<>( authorResponseDto,HttpStatus.CREATED);
            }
            else
            {
                throw new AuthorNotFoundException(HttpStatus.BAD_REQUEST, "Author not found");
            }
        }
        catch (AuthorNotFoundException e)
        {
            return new ResponseEntity<>(e.getMessage(),HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public List<AuthorResponseDto> getAll() {
        List<Author> authors =authorRepository.findAll().stream().toList();
        List<AuthorResponseDto> authorResponseDtos = new ArrayList<>();

        for(Author author : authors)
        {
           authorResponseDtos.add(AuthorTransformer.authorToAuthorResponseDto(author));
        }
        return authorResponseDtos;
    }

    @Override
    public List<AuthorResponseDto> getByAge(int age) {
        List<Author> authors= authorRepository.findAll().stream().toList();
        List<AuthorResponseDto> authorResponseDtos = new ArrayList<>();

        for(Author author : authors)
        {
            if(author.getAge()==age)
            {
                authorResponseDtos.add(AuthorTransformer.authorToAuthorResponseDto(author));
            }
        }
        return authorResponseDtos;
    }


}
