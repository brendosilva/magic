package com.desafio.zappts.magic.controllers.exceptions;

import com.desafio.zappts.magic.services.exceptions.ControllerNotFoundException;
import com.desafio.zappts.magic.services.exceptions.EntitieAlreadyExists;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import java.time.Instant;

@ControllerAdvice
public class ControllerExceptionHandle {

    @ExceptionHandler(ControllerNotFoundException.class)
    public ResponseEntity<StandardError> entityNotFound(ControllerNotFoundException e, HttpServletRequest request) {
        HttpStatus status = HttpStatus.NOT_FOUND;
        StandardError err = StandardError.builder()
                .timestamp(Instant.now())
                .status(status.value())
                .error("Resource not found")
                .path(request.getRequestURI())
                .build();


        return ResponseEntity.status(status).body(err);
    }

    @ExceptionHandler(EntitieAlreadyExists.class)
    public ResponseEntity<StandardError> alreadyExists(EntitieAlreadyExists e, HttpServletRequest request){
        HttpStatus status = HttpStatus.BAD_REQUEST;
        StandardError err = StandardError.builder()
                .timestamp(Instant.now())
                .status(status.value())
                .error(e.getMessage())
                .path(request.getRequestURI())
                .build();

        return ResponseEntity.status(status).body(err);

    }
}
