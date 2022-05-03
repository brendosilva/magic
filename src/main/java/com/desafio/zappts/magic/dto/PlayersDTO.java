package com.desafio.zappts.magic.dto;

import com.desafio.zappts.magic.entities.Cards;
import com.desafio.zappts.magic.entities.Players;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.OneToMany;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class PlayersDTO implements Serializable {

    private Long id;

    @NotEmpty(message = "campo obrigatório")
    private String name;

    public PlayersDTO(){}

    public PlayersDTO(Long id, String name){
        this.id = id;
        this.name = name;
    }

    public PlayersDTO(Players entity){
        this.id = entity.getId();
        this.name = entity.getName();
    }


}
