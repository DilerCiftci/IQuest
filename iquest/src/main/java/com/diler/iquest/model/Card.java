package com.diler.iquest.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Card {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String question;
    private String answer;
    private String deck;

    public Card() {
    }

    public Card(String question, String answer, String deck) {
        this.question = question;
        this.answer = answer;
        this.deck = deck;
    }

    public Long getId() {
        return id;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public String getDeck() {
        return deck;
    }

    public void setDeck(String deck) {
        this.deck = deck;
    }
}