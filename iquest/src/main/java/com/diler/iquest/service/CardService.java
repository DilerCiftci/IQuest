package com.diler.iquest.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.diler.iquest.exception.EntityNotFoundException;
import com.diler.iquest.model.Card;
import com.diler.iquest.model.Deck;
import com.diler.iquest.repository.CardRepository;
import com.diler.iquest.repository.DeckRepository;

// Service layer for card (flashcard) operations
@Service
public class CardService {

    private final CardRepository cardRepository;
    private final DeckRepository deckRepository;

    public CardService(CardRepository cardRepository, DeckRepository deckRepository) {
        this.cardRepository = cardRepository;
        this.deckRepository = deckRepository;
    }

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

    public List<Card> getCardsByDeck(Long deckId) {
        if (deckId == null || deckId <= 0) {
            throw new IllegalArgumentException("Deck id is required to see cards.");
        }
        return cardRepository.findByDeckId(deckId);
    }

    public void deleteCard(Long id) {
        if (id == null || id <= 0) {
            throw new IllegalArgumentException("Card id is required.");
        }
        if (!cardRepository.existsById(id)) {
            throw new EntityNotFoundException("Card not found with id: " + id);
        }
        cardRepository.deleteById(id);
    }

    public Card updateCard(Long id, String question, String answer) {
        if (id == null || id <= 0) {
            throw new IllegalArgumentException("Card id is required.");
        }
        if (question == null || question.isBlank()) {
            throw new IllegalArgumentException("Card needs a question.");
        }
        if (answer == null || answer.isBlank()) {
            throw new IllegalArgumentException("Card needs an answer.");
        }

        Card card = cardRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Card not found with id: " + id));

        card.setQuestion(question);
        card.setAnswer(answer);
        return cardRepository.save(card);
    }
}