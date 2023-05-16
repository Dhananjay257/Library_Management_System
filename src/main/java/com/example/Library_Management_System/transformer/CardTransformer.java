package com.example.Library_Management_System.transformer;

import com.example.Library_Management_System.dtos.responseDto.CardResponseDto;
import com.example.Library_Management_System.model.Card;

public class CardTransformer {
    public static CardResponseDto cardToCardResponseDto(Card card)
    {
        CardResponseDto cardResponseDto = new CardResponseDto();
        cardResponseDto.setCardStatus(card.getCardStatus());
        cardResponseDto.setUpdatedOn(card.getUpdatedOn());
        cardResponseDto.setValidTill(card.getValidTill());
        cardResponseDto.setIssueDate(card.getIssueDate());
        cardResponseDto.setId(card.getId());

        return cardResponseDto;
    }
}
