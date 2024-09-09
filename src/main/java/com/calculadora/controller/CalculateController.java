package com.calculadora.controller;

import com.calculadora.dto.OperationDTO;
import com.calculadora.service.CalculateService;
import com.calculadora.service.impl.CalculateImplService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CalculateController {
    private final CalculateService calculateService;
    public CalculateController() {
        this.calculateService = new CalculateImplService();
    }
    @Operation(summary = "Simple math operation API")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "ok",
                    content = { @Content(mediaType = "application/json", schema = @Schema(implementation = Integer.class)) }),
            @ApiResponse(responseCode = "400", description = "Invalid field",
                    content = @Content),
            @ApiResponse(responseCode = "404", description = "Operand not found",
                    content = @Content),
            @ApiResponse(responseCode = "500", description = "can't divide by zero",
                    content = @Content) })

    @PostMapping("calculate")
    public Integer calculate(@Valid @RequestBody OperationDTO operationDTO){
        return calculateService.calculate(operationDTO);
    }
}
