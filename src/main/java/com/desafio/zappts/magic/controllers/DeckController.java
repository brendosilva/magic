package com.desafio.zappts.magic.controllers;

import com.desafio.zappts.magic.dto.DeckDTO;
import com.desafio.zappts.magic.services.DeckService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@Controller
@RequestMapping("/deck")
public class DeckController {

    @Autowired
    private DeckService deckService;

    @PostMapping
    public ResponseEntity<DeckDTO> create(@RequestBody DeckDTO deckDTO){
        deckDTO = deckService.create(deckDTO);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(deckDTO.getId())
                .toUri();

        return ResponseEntity.created(uri).body(deckDTO);
    }

    @GetMapping()
    public ResponseEntity<List<DeckDTO>> getDeck(){
        List<DeckDTO> all = deckService.findAll();
        return ResponseEntity.ok().body(all);
    }
}
