package com.example.Library_Management_System.dtos.responseDto;

import com.example.Library_Management_System.enums.TransactionStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class IssueBookResponseDto {
    private String transactionNumber;
    private TransactionStatus transactionStatus;
    private String bookName;
}
