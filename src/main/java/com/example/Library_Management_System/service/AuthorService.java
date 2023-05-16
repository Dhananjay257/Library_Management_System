package com.example.Library_Management_System.service;

import com.example.Library_Management_System.dtos.requetsDto.AuthorRequestDto;
import com.example.Library_Management_System.dtos.responseDto.AuthorResponseDto;
import com.example.Library_Management_System.exception.AuthorNotFoundException;
import com.example.Library_Management_System.model.Author;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface AuthorService {
    public String addAuthor(AuthorRequestDto authorRequestDto);
    public AuthorResponseDto getByEmail(String email);
    public ResponseEntity deleteById(int id) throws AuthorNotFoundException;
    public ResponseEntity getById(int id) throws AuthorNotFoundException;
    public List<AuthorResponseDto> getAll();
    public List<AuthorResponseDto> getByAge(int age);
}
