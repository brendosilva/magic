package com.desafio.zappts.magic.repositories;

import com.desafio.zappts.magic.entities.Cards;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CardsRepository  extends JpaRepository<Cards, Long> {
    Cards findByCharacteristics(String Characteristics);
}
