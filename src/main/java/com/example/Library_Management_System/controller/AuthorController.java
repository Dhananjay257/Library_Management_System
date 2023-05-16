package com.example.Library_Management_System.controller;

import com.example.Library_Management_System.dtos.requetsDto.AuthorRequestDto;
import com.example.Library_Management_System.dtos.responseDto.AuthorResponseDto;
import com.example.Library_Management_System.exception.AuthorNotFoundException;
import com.example.Library_Management_System.model.Author;
import com.example.Library_Management_System.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/author")
public class AuthorController {

    @Autowired
    AuthorService authorService;

    @PostMapping("/add")
    public String addAuthor(@RequestBody AuthorRequestDto authorRequestDto){
        return authorService.addAuthor(authorRequestDto);
    }

    @GetMapping("/get_by_email")
    public AuthorResponseDto getAuthorByEmail(@RequestParam("email") String email){

        return authorService.getByEmail(email);
    }

    @DeleteMapping("/delete_by_id")
    public ResponseEntity deleteAuthorById(@RequestParam("id") int id) throws AuthorNotFoundException {
        return authorService.deleteById(id);
    }

    @GetMapping("/get_by_id")
    public ResponseEntity getById(@RequestParam("id") int id) throws AuthorNotFoundException {
        return authorService.getById(id);
    }

    @GetMapping("/get_all")
    public List<AuthorResponseDto> getAll()
    {
        return authorService.getAll();
    }

    // update the student by id

    @GetMapping("/get_by_age/{age}")
    public List<AuthorResponseDto> getByAge(@PathVariable int age)
    {
        return authorService.getByAge(age);
    }

}
