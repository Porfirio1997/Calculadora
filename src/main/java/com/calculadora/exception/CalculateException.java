package com.calculadora.exception;

import com.calculadora.dto.exception.MessageDTO;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;

public class CalculateException extends RuntimeException{

    private final HttpStatusCode status;

    private final String key;

    public CalculateException(HttpStatusCode status, String message, String key) {
        super(message);
        this.status = status;
        this.key = key;
    }

    public ResponseEntity<MessageDTO> getMessageError() {
        return ResponseEntity.status(status).body(new MessageDTO(getMessage(), key));
    }


}
