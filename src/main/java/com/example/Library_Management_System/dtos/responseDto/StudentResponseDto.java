package com.example.Library_Management_System.dtos.responseDto;

import com.example.Library_Management_System.enums.Department;
import com.example.Library_Management_System.model.Card;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class StudentResponseDto {
    private int id;

    private String name;

    private int age;

    private Department department;

    private String mobNo;

    private CardResponseDto cardResponseDto;
}
