package com.calculadora.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public record OperationDTO(@NotNull Integer leftNum,
                           @Pattern(regexp = "^[+\\-/*]$", message = "deve corresponder a + ou - ou / ou * ") String operand,
                           @NotNull Integer rigthNum) {
}
