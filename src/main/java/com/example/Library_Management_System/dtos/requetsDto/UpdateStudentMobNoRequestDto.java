package com.example.Library_Management_System.dtos.requetsDto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class UpdateStudentMobNoRequestDto {
    private int id;
    private String mobNo;
}
