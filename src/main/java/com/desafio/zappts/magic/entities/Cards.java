package com.desafio.zappts.magic.entities;

import lombok.*;


import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;


@Entity
@Table(name = "tb_cards")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
public class Cards implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String edition;

    private String language;

    private Boolean foil;

    private BigDecimal price;

    @Column(unique = true)
    private String characteristics;

    @ManyToOne
    @JoinColumn(name = "deck_id")
    private Deck deck;

    public Cards (Long id, String name, String edition, String language, Boolean foil, BigDecimal price, String characteristics) {
        this.id = id;
        this.name = name;
        this.edition = edition;
        this.language = language;
        this.foil = foil;
        this.price = price;
        this.characteristics = characteristics;
    }

}
