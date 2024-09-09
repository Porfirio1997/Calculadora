package com.calculadora.service.impl;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
 class SubtractImplServiceTest {

 SubtractImplService service;

 @BeforeEach
 public void init(){
     service = new SubtractImplService();
 }

 @Test
 void TestExecuteOperation(){
      Integer numerador = 2;
      Integer denominador = 5;

      Integer result = service.executeOperation(numerador, denominador);
      assertEquals((numerador - denominador) , result);
 }

}
