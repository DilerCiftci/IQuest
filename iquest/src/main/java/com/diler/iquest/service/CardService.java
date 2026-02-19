package com.diler.iquest.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.diler.iquest.exception.EntityNotFoundException;
import com.diler.iquest.model.Card;
import com.diler.iquest.model.Deck;
import com.diler.iquest.repository.CardRepository;
import com.diler.iquest.repository.DeckRepository;

@Service
public class CardService {

    private final CardRepository cardRepository;
    private final DeckRepository deckRepository;

    public CardService(CardRepository cardRepository, DeckRepository deckRepository) {
        this.cardRepository = cardRepository;
        this.deckRepository = deckRepository;
    }

    // Add card
    public Card addCard(String question, String answer, Long deckId) {
        if (question == null || question.isBlank()) {
            throw new IllegalArgumentException("Card needs a question.");
        }
        if (answer == null || answer.isBlank()) {
            throw new IllegalArgumentException("Card needs an answer.");
        }
        if (deckId == null || deckId <= 0) {
            throw new IllegalArgumentException("Card needs a valid deck id.");
        }

        Deck deck = deckRepository.findById(deckId)
                .orElseThrow(() -> new EntityNotFoundException("Deck not found with id: " + deckId));

        Card card = new Card(question, answer, deck);
        return cardRepository.save(card);
    }

    // Get cards
    public List<Card> getCardsByDeck(Long deckId) {
        if (deckId == null || deckId <= 0) {
            throw new IllegalArgumentException("Deck id is required to see cards.");
        }
        return cardRepository.findByDeckId(deckId);
    }

    // Delete card
    public void deleteCard(Long id) {
        if (id == null || id <= 0) {
            throw new IllegalArgumentException("Card id is required.");
        }
        if (!cardRepository.existsById(id)) {
            throw new EntityNotFoundException("Card not found with id: " + id);
        }
        cardRepository.deleteById(id);
    }
}