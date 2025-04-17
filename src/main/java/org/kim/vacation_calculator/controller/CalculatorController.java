package org.kim.vacation_calculator.controller;

import jakarta.validation.Valid;
import org.kim.vacation_calculator.dto.VacationRequest;
import org.kim.vacation_calculator.service.CalculatorService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
@RequestMapping("/api/v1/calculate")
public class CalculatorController {
    private final CalculatorService calculatorService;

    public CalculatorController(CalculatorService calculatorService) {
        this.calculatorService = calculatorService;
    }

    @PostMapping
    public BigDecimal calculateVacationPay(
            @RequestBody @Valid VacationRequest request
    ) {
        return calculatorService.calculate(request);
    }
}
