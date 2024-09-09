package com.calculadora.dto.exception;

public record ErrorObjectDTO(String message, String field, Object parameter) {
}
