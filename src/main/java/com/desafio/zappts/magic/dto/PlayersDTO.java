package com.desafio.zappts.magic.dto;

import com.desafio.zappts.magic.entities.Players;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import java.io.Serializable;

@Getter
@Setter
public class PlayersDTO implements Serializable {

    private Long id;

    @NotEmpty(message = "campo obrigatório")
    private String name;

    @NotEmpty(message = "campo obrigatório")
    private String username;

    public PlayersDTO(){}

    public PlayersDTO(Long id, String name, String username){
        this.id = id;
        this.name = name;
        this.username = username;
    }

    public PlayersDTO(Players entity){
        this.id = entity.getId();
        this.name = entity.getName();
        this.username = entity.getUsername();
    }


}
