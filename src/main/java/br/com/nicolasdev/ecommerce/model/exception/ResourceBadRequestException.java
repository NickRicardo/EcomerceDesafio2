package br.com.nicolasdev.ecommerce.model.exception;

public class ResourceBadRequestException extends RuntimeException {
    
    public ResourceBadRequestException (String mensagem){
        super(mensagem);
    }
}

