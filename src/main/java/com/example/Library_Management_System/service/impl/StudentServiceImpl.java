package com.example.Library_Management_System.service.impl;

import com.example.Library_Management_System.dtos.requetsDto.StudentRequestDto;
import com.example.Library_Management_System.dtos.requetsDto.UpdateStudentMobNoRequestDto;
import com.example.Library_Management_System.dtos.responseDto.CardResponseDto;
import com.example.Library_Management_System.dtos.responseDto.StudentResponseDto;
import com.example.Library_Management_System.dtos.responseDto.UpdateStudentMobNoResponseDto;
import com.example.Library_Management_System.enums.Status;
import com.example.Library_Management_System.exception.StudentNotFoundException;
import com.example.Library_Management_System.model.Card;
import com.example.Library_Management_System.model.Student;
import com.example.Library_Management_System.repository.StudentRepository;
import com.example.Library_Management_System.service.StudentService;
import com.example.Library_Management_System.transformer.CardTransformer;
import com.example.Library_Management_System.transformer.StudentTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    StudentRepository studentRepository;

    @Override
    public String addStudent(StudentRequestDto studentRequestDto) {

        Student student = StudentTransformer.studentRequestDtoToStudent(studentRequestDto);
        Card card = new Card();
        card.setCardStatus(Status.ACTIVATED);
        card.setValidTill("2024-01-01");
        card.setStudent(student);
        student.setCard(card);
        studentRepository.save(student);

        return "Student added";
    }

    @Override
    public StudentResponseDto getStudentById(int id) {

        Student student = studentRepository.findById(id).get();

        StudentResponseDto studentResponseDto = StudentTransformer.studentToStudentResponseDto(student);
        CardResponseDto cardResponseDto = CardTransformer.cardToCardResponseDto(student.getCard());

        studentResponseDto.setCardResponseDto(cardResponseDto);
        return studentResponseDto;
    }

    @Override
    public UpdateStudentMobNoResponseDto updateMobNo(UpdateStudentMobNoRequestDto updateStudentMobRequestDto) throws StudentNotFoundException {

        try{
            Student student = studentRepository.findById(updateStudentMobRequestDto.getId()).get();
            student.setMobNo(updateStudentMobRequestDto.getMobNo());
            Student updatedStudent = studentRepository.save(student);

            // prepare response dto
            UpdateStudentMobNoResponseDto updateStudentMobNoResponseDto = new UpdateStudentMobNoResponseDto();
            updateStudentMobNoResponseDto.setName(updatedStudent.getName());
            updateStudentMobNoResponseDto.setMobNo(updateStudentMobRequestDto.getMobNo());
            return updateStudentMobNoResponseDto;
        }
        catch (Exception e){
            throw new StudentNotFoundException("Invalid student id");
        }
    }

    public List<StudentResponseDto> getAll()
    {
        List<Student> students = studentRepository.findAll().stream().toList();
        List<StudentResponseDto> studentResponseDtos = new ArrayList<>();

        for(Student student : students)
        {
            StudentResponseDto studentResponseDto = StudentTransformer.studentToStudentResponseDto(student);
            CardResponseDto cardResponseDto = CardTransformer.cardToCardResponseDto(student.getCard());
            studentResponseDto.setCardResponseDto(cardResponseDto);
            studentResponseDtos.add(studentResponseDto);
        }
        return studentResponseDtos;
    }

    public String updateMob(int id,String mobNo)
    {
        Student student=studentRepository.findById(id).get();
        student.setMobNo(mobNo);
        studentRepository.save(student);
        return "Mobile Number Updated";
    }
    @Override
    public String delete(int id) {
        studentRepository.deleteById(id);
        return "Student Removed";
    }

}