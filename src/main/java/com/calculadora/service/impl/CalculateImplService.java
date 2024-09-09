package com.calculadora.service.impl;

import com.calculadora.dto.OperationDTO;
import com.calculadora.exception.CalculateException;
import com.calculadora.service.CalculateService;
import com.calculadora.service.OperationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatusCode;
@Slf4j
public class CalculateImplService implements CalculateService {
    private OperationService operationStrategy;
    private final static Integer STATUS_CODE = 404;
    private final static String MESSAGE_CALCULATE_EXCEPTION = "Operand not found";
    private final static String MESSAGE_CALCULATE_EXCEPTION_KEY = "operand.not.found";

    @Override
    public Integer calculate(OperationDTO operationDTO) {
        log.info("Object: {}", operationDTO);
        operationStrategy = getOperation(operationDTO.operand());
        log.info("define strategy by: {}", operationDTO.operand());
        return operationStrategy.executeOperation(Integer.valueOf(operationDTO.leftNum()), Integer.valueOf(operationDTO.rigthNum()));
    }

    private OperationService getOperation(String operand){
        switch (operand){
            case "+": return new SumImplService();
            case "-": return new SubtractImplService();
            case "/": return new DivideImplService();
            case "*": return new MultiplyImplService();
            default: throw new CalculateException(HttpStatusCode.valueOf(STATUS_CODE), MESSAGE_CALCULATE_EXCEPTION, MESSAGE_CALCULATE_EXCEPTION_KEY);
        }
    }

}
