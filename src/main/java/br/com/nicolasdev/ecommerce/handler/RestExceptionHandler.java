package br.com.nicolasdev.ecommerce.handler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import br.com.nicolasdev.ecommerce.model.exception.ResourceBadRequestException;
import br.com.nicolasdev.ecommerce.model.exception.ResourceNotFoundException;

@ControllerAdvice
public class RestExceptionHandler {
    

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<?> handlerResourceNotFoundException(ResourceNotFoundException ex){

        ModeloErro erro = new ModeloErro("Not Found", ex.getMessage(), 404);
        return ResponseEntity.status(404).body(erro);
    }

    @ExceptionHandler(ResourceBadRequestException.class)
    public ResponseEntity<?> handlerResourceBadRequestException(ResourceBadRequestException ex){

        ModeloErro erro = new ModeloErro("Bad Request", ex.getMessage(), 400);
        return ResponseEntity.status(400).body(erro);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<?> handlerResourceException(Exception ex){

        ModeloErro erro = new ModeloErro("Internal Server Error", ex.getMessage(), 500);
        return ResponseEntity.status(500).body(erro);
    }
}
