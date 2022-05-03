package com.desafio.zappts.magic;

import com.desafio.zappts.magic.entities.Cards;
import com.desafio.zappts.magic.entities.Players;

import java.math.BigDecimal;

public class Factory {

    public static Players createPlayers() {
        Players players = new Players(1L, "Diego");
        return players;
    }

    public static Cards createCards(){
        Cards cards = new Cards(1L, "nameTest", "editionTest", "languageTest", true, new BigDecimal(750.0), "magico");
        return cards;
    }
}
