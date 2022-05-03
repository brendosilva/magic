package com.desafio.zappts.magic.dto;


import com.desafio.zappts.magic.entities.Cards;
import com.desafio.zappts.magic.entities.Deck;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class DeckDTO implements Serializable {

    private Long id;

    private List<CardsDTO> cards = new ArrayList<>();

    public DeckDTO() {
    }

    public DeckDTO(Deck entity) {
        this.id = entity.getId();
    }

    public DeckDTO(Deck entity, List<Cards> listCard) {
        this.id = entity.getId();
        listCard.forEach(card -> this.cards.add(new CardsDTO(card)));
    }


}
