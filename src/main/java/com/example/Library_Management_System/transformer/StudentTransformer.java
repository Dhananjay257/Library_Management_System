package com.example.Library_Management_System.transformer;

import com.example.Library_Management_System.dtos.requetsDto.StudentRequestDto;
import com.example.Library_Management_System.dtos.responseDto.StudentResponseDto;
import com.example.Library_Management_System.model.Student;

public class StudentTransformer {

    public static Student studentRequestDtoToStudent(StudentRequestDto studentRequestDto)
    {
        Student student = new Student();
        student.setAge(studentRequestDto.getAge());
        student.setName(studentRequestDto.getName());
        student.setDepartment(studentRequestDto.getDepartment());
        student.setMobNo(studentRequestDto.getMobNo());
        student.setEmail(studentRequestDto.getEmail());
        return student;
    }
    public static StudentResponseDto studentToStudentResponseDto(Student student)
    {
        StudentResponseDto studentResponseDto = new StudentResponseDto();
        studentResponseDto.setId(student.getId());
        studentResponseDto.setName(student.getName());
        studentResponseDto.setAge(student.getAge());
        studentResponseDto.setMobNo(student.getMobNo());
        studentResponseDto.setDepartment(student.getDepartment());
        studentResponseDto.setEmail(student.getEmail());
        return studentResponseDto;
    }
}
