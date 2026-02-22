package com.diler.iquest.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.diler.iquest.exception.EntityNotFoundException;
import com.diler.iquest.model.Deck;
import com.diler.iquest.model.User;
import com.diler.iquest.repository.DeckRepository;

// Service layer for deck operations
@Service
public class DeckService {

    private final DeckRepository deckRepository;

    public DeckService(DeckRepository deckRepository) {
        this.deckRepository = deckRepository;
    }

    public Deck createDeck(String name, User user) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Deck name is required.");
        }
        if (user == null) {
            throw new IllegalArgumentException("User is required.");
        }

        Deck deck = new Deck(name, user);
        return deckRepository.save(deck);
    }

    public List<Deck> getDecksByUser(User user) {
        if (user == null) {
            throw new IllegalArgumentException("User is required.");
        }
        return deckRepository.findByUser(user);
    }

    public void deleteDeck(Long id) {
        if (id == null || id <= 0) {
            throw new IllegalArgumentException("Deck id is required.");
        }
        // Check if deck exists before trying to delete
        if (!deckRepository.existsById(id)) {
            throw new EntityNotFoundException("Deck not found with id: " + id);
        }
        deckRepository.deleteById(id);
    }

    public Deck updateDeck(Long id, String name) {
        if (id == null || id <= 0) {
            throw new IllegalArgumentException("Deck id is required.");
        }
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Deck name is required.");
        }

        Deck deck = deckRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Deck not found with id: " + id));

        deck.setName(name);
        return deckRepository.save(deck);
    }
}