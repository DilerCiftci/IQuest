package com.diler.iquest.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.diler.iquest.dto.request.CreateDeckRequest;
import com.diler.iquest.dto.request.UpdateDeckRequest;
import com.diler.iquest.dto.response.DeckDTO;
import com.diler.iquest.model.Deck;
import com.diler.iquest.model.User;
import com.diler.iquest.service.DeckService;
import com.diler.iquest.service.UserService;

import jakarta.validation.Valid;

import java.util.List;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

// REST API for deck operations: create, get all, update, delete
@RestController
@RequestMapping("/api/decks")
public class DeckController {

    private final DeckService deckService;
    private final UserService userService;

    public DeckController(DeckService deckService, UserService userService) {
        this.deckService = deckService;
        this.userService = userService;
    }

    @PostMapping
    public DeckDTO createDeck(@Valid @RequestBody CreateDeckRequest request,
            @AuthenticationPrincipal UserDetails userDetails) {

        User user = userService.findByUsername(userDetails.getUsername())
                .orElseThrow(() -> new IllegalArgumentException("User not found"));

        Deck deck = deckService.createDeck(request.name(), user);
        return new DeckDTO(deck.getId(), deck.getName());
    }

    @GetMapping
    public List<DeckDTO> getAllDecks(@AuthenticationPrincipal UserDetails userDetails) {

        User user = userService.findByUsername(userDetails.getUsername())
                .orElseThrow(() -> new IllegalArgumentException("User not found"));

        return deckService.getDecksByUser(user)
                .stream()
                .map(deck -> new DeckDTO(deck.getId(), deck.getName()))
                .toList();
    }

    @PutMapping("/{id}")
    public DeckDTO updateDeck(@PathVariable Long id, @Valid @RequestBody UpdateDeckRequest request) {
        Deck updated = deckService.updateDeck(id, request.name());
        return new DeckDTO(updated.getId(), updated.getName());
    }

    @DeleteMapping("/{id}")
    public void deleteDeck(@PathVariable Long id) {
        deckService.deleteDeck(id);
    }
}