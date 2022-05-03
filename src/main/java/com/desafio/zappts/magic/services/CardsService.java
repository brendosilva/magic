package com.desafio.zappts.magic.services;

import com.desafio.zappts.magic.dto.CardsDTO;
import com.desafio.zappts.magic.entities.Cards;
import com.desafio.zappts.magic.repositories.CardsRepository;
import com.desafio.zappts.magic.services.exceptions.ControllerNotFoundException;
import com.desafio.zappts.magic.services.exceptions.EntitieAlreadyExists;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.dao.IncorrectResultSizeDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CardsService {

    @Autowired
    private CardsRepository cardsRepository;

    @Transactional
    public CardsDTO create(CardsDTO cardsDTO){
        try {
            Cards cards = new Cards();
            copyDtoToEntity(cardsDTO, cards);
            cards.setCharacteristics(cardsDTO.getCharacteristics());
            cards = cardsRepository.save(cards);
            return new CardsDTO(cards);
        } catch (DataIntegrityViolationException e) {
            throw new EntitieAlreadyExists("characteristics already exists");
        }
    }

    @Transactional(readOnly = true)
    public List<CardsDTO> listCards () {
        List<Cards> cards = cardsRepository.findAll();
        return cards.stream().map(x -> new CardsDTO(x.getId(),x.getName(),x.getEdition(),x.getLanguage(),x.getFoil(),x.getPrice(), x.getCharacteristics())).collect(Collectors.toList());
    }

    @Transactional
    public CardsDTO update(Long id, CardsDTO dto){

            try {
                Cards cards = cardsRepository.getById(id);
                copyDtoToEntity(dto, cards);
                cards = cardsRepository.save(cards);
                return new CardsDTO(cards);
            }  catch (DataIntegrityViolationException e) {
                throw new EntitieAlreadyExists("characteristics already exists");
            }
    }

    @Transactional
    public void delete(Long id) {
        try {
            cardsRepository.deleteById(id);
        } catch (EmptyResultDataAccessException e) {
            throw new ControllerNotFoundException("id not found " + id);
        }
    }

    public void copyDtoToEntity(CardsDTO dto, Cards entity){
        entity.setName(dto.getName());
        entity.setEdition(dto.getEdition());
        entity.setLanguage(dto.getLanguage());
        entity.setFoil(dto.getFoil());
        entity.setPrice(dto.getPrice());
        entity.setDeck(dto.getDeck());
        //entity.setCharacteristics(dto.getCharacteristics());

    }
}
