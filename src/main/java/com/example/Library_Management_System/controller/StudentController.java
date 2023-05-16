package com.example.Library_Management_System.controller;

import com.example.Library_Management_System.dtos.requetsDto.StudentRequestDto;
import com.example.Library_Management_System.dtos.requetsDto.UpdateStudentMobNoRequestDto;
import com.example.Library_Management_System.dtos.responseDto.StudentResponseDto;
import com.example.Library_Management_System.dtos.responseDto.UpdateStudentMobNoResponseDto;
import com.example.Library_Management_System.exception.StudentNotFoundException;
import com.example.Library_Management_System.repository.StudentRepository;
import com.example.Library_Management_System.service.StudentService;
import com.example.Library_Management_System.service.impl.StudentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    StudentServiceImpl studentService;


    @PostMapping("/add")
    public String addStudent(@RequestBody StudentRequestDto studentRequestDto){

        return studentService.addStudent(studentRequestDto);
    }

    @PutMapping("/update_mobile")
    public UpdateStudentMobNoResponseDto updateMobNo(@RequestBody UpdateStudentMobNoRequestDto updateStudentMobRequestDto) throws StudentNotFoundException {

        return studentService.updateMobNo(updateStudentMobRequestDto);
    }

    @DeleteMapping("/delete")
    public String delete(@RequestParam("id") int id)
    {
        return studentService.delete(id);
    }


    @GetMapping("/get_student")
    public StudentResponseDto getStudent(@RequestParam("id") int id){
        return studentService.getStudentById(id);
    }

    @GetMapping("/get_all")
    public List<StudentResponseDto> findAll()
    {
        return studentService.getAll();
    }

    @PutMapping("/update_mob_no")
    public String updateMobNo(@RequestParam("id")int id , @RequestParam("mobNo") String mobNo)
    {
        return studentService.updateMob(id,mobNo);
    }

}
