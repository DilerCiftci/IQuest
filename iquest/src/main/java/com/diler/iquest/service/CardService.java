package com.diler.iquest.service;

import org.springframework.stereotype.Service;

import com.diler.iquest.repository.CardRepository;

@Service
public class CardService {

    private final CardRepository cardRepository;

    public CardService(CardRepository cardRepository) {
        this.cardRepository = cardRepository;
    }
}