package com.calculadora.service.impl;

import com.calculadora.service.OperationService;

public class SubtractImplService implements OperationService {
    @Override
    public Integer executeOperation(Integer inputOne, Integer inputTwo) {
        return inputOne - inputTwo;
    }
}