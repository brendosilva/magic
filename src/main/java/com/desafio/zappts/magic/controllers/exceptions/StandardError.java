package com.desafio.zappts.magic.controllers.exceptions;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.time.Instant;

@Getter
@Setter
@Builder
public class StandardError implements Serializable {

    private Instant timestamp;
    private Integer status;
    private String error;
    private String message;
    private String path;


}
