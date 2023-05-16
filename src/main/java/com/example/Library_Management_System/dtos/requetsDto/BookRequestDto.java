package com.example.Library_Management_System.dtos.requetsDto;

import com.example.Library_Management_System.enums.Genre;
import com.example.Library_Management_System.model.Author;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookRequestDto {
    private Author author;

    private String title;

    private Genre genre;

    private int numberOfPages;

    private int price;

    private boolean isIssued;
}
