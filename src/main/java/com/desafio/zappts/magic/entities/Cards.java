package com.desafio.zappts.magic.entities;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;

@Entity
@Table(name = "tb_cards")
@Data
public class Cards implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String edition;

    private String language;

    private Boolean foil;

    private BigDecimal price;

    @Column(unique = true)
    private String characteristics;


}
