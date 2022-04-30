package com.desafio.zappts.magic.services;

import com.desafio.zappts.magic.dto.PlayersDTO;
import com.desafio.zappts.magic.entities.Players;
import com.desafio.zappts.magic.repositories.PlayersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PlayersService {

    @Autowired
    private PlayersRepository playersRepository;

    @Transactional
    public PlayersDTO create(PlayersDTO playersDTO){
        Players player = new Players();
        copyDtoToEntity(playersDTO, player);
        player = playersRepository.save(player);
        return new PlayersDTO(player);
    }

    @Transactional(readOnly = true)
    public List<PlayersDTO> listPlayers() {
        List<Players> players = playersRepository.findAll();
        return players.stream()
                .map(x -> new PlayersDTO(x.getId(),x.getName(), x.getUsername()))
                .collect(Collectors.toList());

    }

    @Transactional(readOnly = true)
    public PlayersDTO findById(Long id) {
        Optional<Players> obj = playersRepository.findById(id);
        Players entity = obj.get();
        return new PlayersDTO(entity);
    }

    public void copyDtoToEntity(PlayersDTO playersDTO, Players player){
        player.setName(playersDTO.getName());
        player.setUsername(playersDTO.getUsername());
    }


}
