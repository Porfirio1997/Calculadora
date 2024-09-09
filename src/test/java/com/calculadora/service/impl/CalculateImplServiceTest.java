package com.calculadora.service.impl;

import com.calculadora.dto.OperationDTO;
import com.calculadora.exception.CalculateException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@ExtendWith(MockitoExtension.class)
public class CalculateImplServiceTest {

    CalculateImplService service;

    @BeforeEach
    public void init(){
        service = new CalculateImplService();
    }
    @Test
    void testCalculateSum(){
        var dto = sumOperationDTO();

        Integer result = service.calculate(dto);
        assertEquals((dto.leftNum() + dto.rigthNum()) , result);
    }

    @Test
    void testCalculateSubtract(){
        var dto = subtractOperationDTO();

        Integer result = service.calculate(dto);
        assertEquals((dto.leftNum() - dto.rigthNum()) , result);
    }

    @Test
    void testCalculateMultiply(){
        var dto = multiplyOperationDTO();

        Integer result = service.calculate(dto);
        assertEquals((dto.leftNum() * dto.rigthNum()) , result);
    }

    @Test
    void testCalculateDivide(){
        var dto = divideOperationDTO();

        Integer result = service.calculate(dto);
        assertEquals((dto.leftNum() / dto.rigthNum()) , result);
    }

    @Test
    void testCalculateOtherOperand(){
        var dto = otherOperandOperationDTO();
        assertThrows(CalculateException.class, () -> service.calculate(dto));
    }


    private OperationDTO sumOperationDTO(){
        return new OperationDTO(1, "+", 1);
    }
    private OperationDTO subtractOperationDTO(){
        return new OperationDTO(1, "-", 1);
    }
    private OperationDTO multiplyOperationDTO(){
        return new OperationDTO(1, "*", 1);
    }
    private OperationDTO divideOperationDTO(){
        return new OperationDTO(1, "/", 1);
    }

    private OperationDTO otherOperandOperationDTO(){
        return new OperationDTO(1, "/-", 1);
    }
}
