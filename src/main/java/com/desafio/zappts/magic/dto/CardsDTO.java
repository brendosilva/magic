package com.desafio.zappts.magic.dto;

import com.desafio.zappts.magic.entities.Cards;
import com.desafio.zappts.magic.entities.Deck;
import com.desafio.zappts.magic.entities.Players;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CardsDTO implements Serializable {

    private Long id;

    private String name;

    private String edition;

    private String language;

    private Boolean foil;

    private BigDecimal price;

    private String characteristics;

    private Deck deck;




    public CardsDTO(Long id, String name, String edition, String language, Boolean foil, BigDecimal price,
                    String characteristics){
        super();
        this.id = id;
        this.name = name;
        this.edition = edition;
        this.language = language;
        this.foil = foil;
        this.price = price;
        this.characteristics = characteristics;

    }

    public CardsDTO (Cards entity){
        this.id = entity.getId();
        this.name = entity.getName();
        this.edition = entity.getEdition();
        this.language = entity.getLanguage();
        this.foil = entity.getFoil();
        this.price = entity.getPrice();
        this.characteristics = entity.getCharacteristics();
        this.deck = entity.getDeck();
    }
}
