package com.diler.iquest.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.diler.iquest.model.Deck;
import com.diler.iquest.model.User;

// Repository for Deck database operations
public interface DeckRepository extends JpaRepository<Deck, Long> {
    List<Deck> findByUser(User user);
}