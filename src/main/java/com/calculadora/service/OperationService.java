package com.calculadora.service;

import org.springframework.stereotype.Service;

@Service
public interface OperationService {
    Integer executeOperation(Integer inputOne, Integer inputTwo);
}
