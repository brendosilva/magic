package com.desafio.zappts.magic.controllers;

import com.desafio.zappts.magic.dto.PlayersDTO;
import com.desafio.zappts.magic.services.PlayersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@Controller
@RequestMapping(value = "/players")
public class PlayersController {
    @Autowired
    private PlayersService playersService;

    @GetMapping
    public ResponseEntity<List<PlayersDTO>> findAll(){
        List<PlayersDTO> list = playersService.listPlayers();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<PlayersDTO> findById(@PathVariable final Long id){
        PlayersDTO player = playersService.findById(id);
        return ResponseEntity.ok().body(player);
    }

    @PostMapping
    public ResponseEntity<PlayersDTO> create(@RequestBody PlayersDTO dto){
        PlayersDTO playersDTO = playersService.create(dto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(playersDTO.getId())
                .toUri();

                return ResponseEntity.created(uri).body(playersDTO);
    }
}
