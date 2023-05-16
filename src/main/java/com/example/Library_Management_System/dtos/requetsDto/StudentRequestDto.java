package com.example.Library_Management_System.dtos.requetsDto;

import com.example.Library_Management_System.enums.Department;
import com.example.Library_Management_System.model.Card;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class StudentRequestDto {
    private String name;
    private int age;
    private Department department;
    private String mobNo;
    private String email;
}
