package com.calculadora.dto.exception;

import java.util.List;

public record ErrorResponseDTO( String message, String key, String objectName, List<ErrorObjectDTO> errors) {
}
