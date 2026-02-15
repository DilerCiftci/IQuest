package com.diler.iquest.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.diler.iquest.model.Card;

public interface CardRepository extends JpaRepository<Card, Long> {
    List<Card> findByDeckId(Long deckId);
}