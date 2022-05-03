package com.desafio.zappts.magic.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "tb_deck")
@Setter
@Getter
public class Deck implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @OneToMany(mappedBy = "deck", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    List<Cards> cards = new ArrayList<>();

    public Deck() {
    }

    public Deck(Long id, List<Cards> cards) {
        this.id = id;
        this.cards = cards;
    }
}
