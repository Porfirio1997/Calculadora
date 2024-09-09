package com.calculadora.service;

import com.calculadora.dto.OperationDTO;
import org.springframework.stereotype.Service;

@Service
public interface CalculateService {
    Integer calculate(OperationDTO operationDTO);
}
