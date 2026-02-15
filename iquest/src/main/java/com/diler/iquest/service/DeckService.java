package com.diler.iquest.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.diler.iquest.model.Deck;
import com.diler.iquest.repository.DeckRepository;

@Service
public class DeckService {

    private final DeckRepository deckRepository;

    public DeckService(DeckRepository deckRepository) {
        this.deckRepository = deckRepository;
    }

    // Create deck
    public Deck createDeck(String name, String user) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Deck name is required.");
        }
        if (user == null || user.isBlank()) {
            throw new IllegalArgumentException("User is required.");
        }

        Deck deck = new Deck(name, user);
        return deckRepository.save(deck);
    }

    // Get deck by user
    public List<Deck> getDecksByUser(String user) {
        if (user == null || user.isBlank()) {
            throw new IllegalArgumentException("User is required.");
        }
        return deckRepository.findByUser(user);
    }
}