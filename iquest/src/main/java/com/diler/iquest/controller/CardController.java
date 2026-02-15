package com.diler.iquest.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.diler.iquest.model.Card;
import com.diler.iquest.service.CardService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@RequestMapping("/api/cards")
public class CardController {

    private final CardService cardService;

    public CardController(CardService cardService) {
        this.cardService = cardService;
    }

    // Create card
    @PostMapping("/deck/{deckId}")
    public Card createCard(@PathVariable Long deckId, @RequestBody Card card) {
        return cardService.addCard(card.getQuestion(), card.getAnswer(), deckId);
    }

    // Get cards
    @GetMapping("/deck/{deckId}")
    public List<Card> getCardsByDeck(@PathVariable Long deckId) {
        return cardService.getCardsByDeck(deckId);
    }

    // Delete card
    @DeleteMapping("/{id}")
    public void deleteCard(@PathVariable Long id) {
        cardService.deleteCard(id);
    }
}