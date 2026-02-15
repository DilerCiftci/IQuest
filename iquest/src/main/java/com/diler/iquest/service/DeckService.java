package com.diler.iquest.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.diler.iquest.model.Deck;
import com.diler.iquest.model.User;
import com.diler.iquest.repository.DeckRepository;

@Service
public class DeckService {

    private final DeckRepository deckRepository;

    public DeckService(DeckRepository deckRepository) {
        this.deckRepository = deckRepository;
    }

    // Create deck
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

    // Get decks
    public List<Deck> getDecksByUser(User user) {
        if (user == null) {
            throw new IllegalArgumentException("User is required.");
        }
        return deckRepository.findByUser(user);
    }

    // Delete deck
    public void deleteDeck(Long id) {
        if (id == null || id <= 0) {
            throw new IllegalArgumentException("No decks to delete.");
        }
        deckRepository.deleteById(id);
    }
}