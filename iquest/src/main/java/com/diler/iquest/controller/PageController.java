package com.diler.iquest.controller;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.diler.iquest.model.User;
import com.diler.iquest.service.CardService;
import com.diler.iquest.service.DeckService;
import com.diler.iquest.service.UserService;

import org.springframework.ui.Model;

@Controller
public class PageController {

    private final CardService cardService;
    private final UserService userService;
    private final DeckService deckService;

    public PageController(UserService userService, DeckService deckService, CardService cardService) {
        this.userService = userService;
        this.deckService = deckService;
        this.cardService = cardService;
    }

    @GetMapping("/")
    public String home() {
        return "home";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/register")
    public String showRegister() {
        return "register";
    }

    @PostMapping("/register")
    public String register(@RequestParam String username, @RequestParam String password) {
        userService.createUser(username, password, "USER");
        return "redirect:/login?registered";
    }

    // Deck mappings
    @GetMapping("/decks")
    public String myDecks(Model model, @AuthenticationPrincipal UserDetails userDetails) {

        User user = userService.findByUsername(userDetails.getUsername())
                .orElseThrow();

        model.addAttribute("decks", deckService.getDecksByUser(user));

        return "decks";
    }

    @GetMapping("/decks/create")
    public String createDeckForm() {
        return "create-deck";
    }

    @PostMapping("/decks/create")
    public String createDeck(@RequestParam String name, @AuthenticationPrincipal UserDetails userDetails) {

        User user = userService.findByUsername(userDetails.getUsername())
                .orElseThrow();

        deckService.createDeck(name, user);

        return "redirect:/decks";
    }

    // Card endpoints
    @GetMapping("/decks/{id}")
    public String viewDeck(@PathVariable Long id, Model model) {

        model.addAttribute("cards", cardService.getCardsByDeck(id));
        model.addAttribute("deckId", id);

        return "cards";
    }

    @GetMapping("/decks/{id}/cards/create")
    public String createCardForm(@PathVariable Long id, Model model) {
        model.addAttribute("deckId", id);
        return "create-card";
    }

    @PostMapping("/decks/{id}/cards/create")
    public String createCard(@PathVariable Long id, @RequestParam String question, @RequestParam String answer) {

        cardService.addCard(question, answer, id);

        return "redirect:/decks/" + id;
    }
}
