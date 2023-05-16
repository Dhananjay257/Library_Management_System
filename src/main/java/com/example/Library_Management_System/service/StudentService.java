package com.example.Library_Management_System.service;

import com.example.Library_Management_System.dtos.requetsDto.StudentRequestDto;
import com.example.Library_Management_System.dtos.requetsDto.UpdateStudentMobNoRequestDto;
import com.example.Library_Management_System.dtos.responseDto.StudentResponseDto;
import com.example.Library_Management_System.dtos.responseDto.UpdateStudentMobNoResponseDto;
import com.example.Library_Management_System.exception.StudentNotFoundException;

import java.util.List;

public interface StudentService {
    public String addStudent(StudentRequestDto studentRequestDto);
    public StudentResponseDto getStudentById(int id);

    public UpdateStudentMobNoResponseDto updateMobNo(UpdateStudentMobNoRequestDto updateStudentMobNoRequestDto) throws StudentNotFoundException;
    public String delete(int id);
    public List<StudentResponseDto> getAll();
    public String updateMob(int id,String mobNo);
}
