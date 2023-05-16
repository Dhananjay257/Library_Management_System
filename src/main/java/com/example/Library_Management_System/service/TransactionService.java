package com.example.Library_Management_System.service;

import com.example.Library_Management_System.dtos.requetsDto.IssueBookRequestDto;
import com.example.Library_Management_System.dtos.responseDto.IssueBookResponseDto;

public interface TransactionService {
    public IssueBookResponseDto issueBook(IssueBookRequestDto issueBookRequestDto) throws Exception;
}
