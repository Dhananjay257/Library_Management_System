package com.example.Library_Management_System.exception;

import org.springframework.http.HttpStatus;

public class AuthorNotFoundException extends Exception {
    public AuthorNotFoundException(HttpStatus status,String message)
    {
        super(message);
    }

}
