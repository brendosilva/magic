package com.desafio.zappts.magic.controllers;

import com.desafio.zappts.magic.dto.CardsDTO;
import com.desafio.zappts.magic.services.CardsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@Controller
@RequestMapping(value = "/cards")
public class CardsController {

    @Autowired
    private CardsService cardsService;

    @PostMapping
    public ResponseEntity<CardsDTO> save(@RequestBody  CardsDTO cardsDTO) {
        CardsDTO dto = cardsService.create(cardsDTO);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(dto.getId())
                .toUri();
        return ResponseEntity.created(uri).body(dto);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<CardsDTO> update(@PathVariable final Long id, @RequestBody final CardsDTO dto){
        CardsDTO cardsDTO = cardsService.update(id, dto);
        return ResponseEntity.ok().body(cardsDTO);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<CardsDTO> delete(@PathVariable final Long id) {
        cardsService.delete(id);

        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public ResponseEntity<List<CardsDTO>> findAll () {
        List<CardsDTO> cardsDTOS = cardsService.listCards();
        return ResponseEntity.ok().body(cardsDTOS);
    }


}
