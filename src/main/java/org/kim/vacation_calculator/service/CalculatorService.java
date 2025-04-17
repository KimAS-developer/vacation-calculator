package org.kim.vacation_calculator.service;

import org.kim.vacation_calculator.dto.VacationRequest;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;

@Service
public class CalculatorService {
    private final BigDecimal AVERAGE_NUMBER_DAYS_IN_MONTH = BigDecimal.valueOf(29.3);
    private final HolidayService holidayService;

    public CalculatorService(HolidayService holidayService) {
        this.holidayService = holidayService;
    }

    public BigDecimal calculate(VacationRequest request) {
        if (request.getCalculateWithDates()) {
            return calculateWithDates(
                    request.getSalary(),
                    request.getStartVacation(),
                    request.getEndVacation()
            );
        }
        return calculateSimple(request.getSalary(), request.getVacationDays());
    }

    public BigDecimal calculateSimple(BigDecimal salary, int vacationsDays) {
        return salary
                .divide(AVERAGE_NUMBER_DAYS_IN_MONTH, 2, RoundingMode.HALF_EVEN)
                .multiply(BigDecimal.valueOf(vacationsDays));
    }

    public BigDecimal calculateWithDates(
            BigDecimal salary,
            LocalDate startVacation,
            LocalDate endVacation
    ) {
        int vacationDays = holidayService.getVacationDays(startVacation, endVacation);
        return calculateSimple(salary, vacationDays);
    }
}
