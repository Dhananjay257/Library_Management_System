package com.example.Library_Management_System.dtos.responseDto;

import com.example.Library_Management_System.enums.Status;
import com.example.Library_Management_System.enums.TransactionStatus;
import com.example.Library_Management_System.model.Student;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CardResponseDto {

    private int id;

    private Date issueDate;

    private Date updatedOn;

    private Status cardStatus;

    private String validTill;

}
