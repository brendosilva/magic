package com.desafio.zappts.magic.services;

import com.desafio.zappts.magic.dto.PlayersDTO;
import com.desafio.zappts.magic.entities.Players;
import com.desafio.zappts.magic.repositories.PlayersRepository;
import com.desafio.zappts.magic.services.exceptions.ControllerNotFoundException;
import com.desafio.zappts.magic.services.exceptions.EntitieAlreadyExists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PlayersService {

    @Autowired
    private PlayersRepository playersRepository;

    @Transactional
    public PlayersDTO create(PlayersDTO playersDTO){
        try {
            Players players = new Players();
            copyDtoToEntity(playersDTO, players);
            players = playersRepository.save(players);
            return new PlayersDTO(players);
        } catch (DataIntegrityViolationException e) {
            throw new EntitieAlreadyExists("player already exists");
        }

    }



    @Transactional(readOnly = true)
    public List<PlayersDTO> listPlayers() {
        List<Players> players = playersRepository.findAll();
        return players.stream()
                .map(x -> new PlayersDTO(x.getId(),x.getName()))
                .collect(Collectors.toList());

    }

    @Transactional
    public PlayersDTO update(Long id, PlayersDTO dto) {
        try {
            Players players = playersRepository.getById(id);
            copyDtoToEntity(dto, players);
            players = playersRepository.save(players);
            return new PlayersDTO(players);
        } catch (EntityNotFoundException e) {
            throw new ControllerNotFoundException("id not found " + id);
        }
    }



    @Transactional(readOnly = true)
    public PlayersDTO findById(Long id) {
        Optional<Players> obj = playersRepository.findById(id);
        Players entity = obj.get();
        return new PlayersDTO(entity);
    }

    @Transactional
    public void delete(Long id) {
        try {
            playersRepository.deleteById(id);
        } catch (EmptyResultDataAccessException e) {
            throw new ControllerNotFoundException("id not found " + id);
        }
    }

    public void copyDtoToEntity(PlayersDTO playersDTO, Players player){

        player.setName(playersDTO.getName());
    }



}
