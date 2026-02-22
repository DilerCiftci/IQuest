package com.diler.iquest.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.diler.iquest.model.Card;

// Repository for Card database operations
public interface CardRepository extends JpaRepository<Card, Long> {
    List<Card> findByDeckId(Long deckId);
}