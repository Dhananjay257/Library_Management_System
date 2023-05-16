package com.example.Library_Management_System.dtos.requetsDto;

import jakarta.persistence.Column;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AuthorRequestDto {

    private String name;

    private int age;

    private String email;

}
