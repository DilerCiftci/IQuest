package com.diler.iquest.service;

import org.springframework.stereotype.Service;

import com.diler.iquest.repository.DeckRepository;

@Service
public class DeckService {

    private final DeckRepository deckRepository;

    public DeckService(DeckRepository deckRepository) {
        this.deckRepository = deckRepository;
    }
}