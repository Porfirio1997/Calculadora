package com.calculadora.service.impl;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@ExtendWith(MockitoExtension.class)
public class DivideImplServiceTest {

    DivideImplService service;

    @BeforeEach
    public void init(){
        service = new DivideImplService();
    }
    @Test
    void testExecuteOperation(){
        Integer numerador = 2;
        Integer denominador = 2;

        Integer result = service.executeOperation(numerador, denominador);
        assertEquals((numerador / denominador) , result);
    }

    @Test
    void testExecuteOperationDivideByZero(){
        Integer inputOne = 2;
        Integer InputTwo = 0;
        assertThrows(ArithmeticException.class, () -> service.executeOperation(inputOne, InputTwo));
    }

}
