package com.desafio.zappts.magic.services;

import com.desafio.zappts.magic.dto.CardsDTO;
import com.desafio.zappts.magic.dto.DeckDTO;
import com.desafio.zappts.magic.entities.Cards;
import com.desafio.zappts.magic.entities.Deck;
import com.desafio.zappts.magic.repositories.CardsRepository;
import com.desafio.zappts.magic.repositories.DeckRepository;
import jdk.jfr.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DeckService {

    @Autowired
    private DeckRepository deckRepository;

    @Autowired
    private CardsRepository cardsRepository;

    @Transactional
    public DeckDTO create(DeckDTO deckDTO) {
        Deck deck = new Deck();
        copyDtoToEntity(deckDTO, deck);
        deck = deckRepository.save(deck);
        return new DeckDTO(deck);

    }

    @Transactional(readOnly = true)
    public List<DeckDTO> findAll(){
        List<Deck> listDeck = deckRepository.findAll();
        return listDeck.stream().map(x -> new DeckDTO(x)).collect(Collectors.toList());
    }

    private void copyDtoToEntity(DeckDTO dto, Deck entity) {
        entity.setId(dto.getId());
        entity.getCards().clear();
        for (CardsDTO cardsDTO : dto.getCards()) {
            Cards cards = cardsRepository.getById(cardsDTO.getId());
            entity.getCards().add(cards);
        }
    }
}
