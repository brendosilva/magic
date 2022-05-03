package com.desafio.zappts.magic.repositories;

import com.desafio.zappts.magic.entities.Deck;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DeckRepository extends JpaRepository<Deck, Long> {
}
