package br.com.davidd5.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class ResourceNotFoundExceptions extends RuntimeException {

    public ResourceNotFoundExceptions(String message) {
        super(message);
    }
}
