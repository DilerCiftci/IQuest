package com.diler.iquest.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.diler.iquest.dto.request.CreateCardRequest;
import com.diler.iquest.dto.request.UpdateCardRequest;
import com.diler.iquest.dto.response.CardDTO;
import com.diler.iquest.model.Card;
import com.diler.iquest.service.CardService;

import jakarta.validation.Valid;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/api/cards")
public class CardController {

    private final CardService cardService;

    public CardController(CardService cardService) {
        this.cardService = cardService;
    }

    // Create card
    @PostMapping("/decks/{deckId}")
    public CardDTO createCard(@PathVariable Long deckId, @Valid @RequestBody CreateCardRequest request) {
        Card card = cardService.addCard(request.question(), request.answer(), deckId);
        return new CardDTO(card.getId(), card.getQuestion(), card.getAnswer());
    }

    // Get cards
    @GetMapping("/decks/{deckId}")
    public List<CardDTO> getCardsByDeck(@PathVariable Long deckId) {
        return cardService.getCardsByDeck(deckId)
                .stream()
                .map(card -> new CardDTO(card.getId(), card.getQuestion(), card.getAnswer()))
                .toList();
    }

    // Delete card
    @DeleteMapping("/{id}")
    public void deleteCard(@PathVariable Long id) {
        cardService.deleteCard(id);
    }

    // Update card
    @PutMapping("/{id}")
    public CardDTO updateCard(@PathVariable Long id, @Valid @RequestBody UpdateCardRequest request) {
        Card updated = cardService.updateCard(id, request.question(), request.answer());
        return new CardDTO(updated.getId(), updated.getQuestion(), updated.getAnswer());
    }
}