package com.diler.iquest.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.diler.iquest.model.Deck;

public interface DeckRepository extends JpaRepository<Deck, Long> {
    List<Deck> findByUser(String user);
}