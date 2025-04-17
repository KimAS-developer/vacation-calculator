package org.kim.vacation_calculator.dto;

import jakarta.validation.constraints.AssertTrue;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotNull;
import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.time.LocalDate;

public class VacationRequest {
    @NotNull(message = "Поле 'salary' обязательно")
    @DecimalMin(
            value = "0.0",
            message = "Зарплата не должна быть отрицательной"
    )
    private BigDecimal salary;

    @NotNull(message = "Выберите режим работы калькулятора")
    private Boolean calculateWithDates;

    @DecimalMin(
            value = "0",
            message = "Количество дней отпуска не может быть отрицательным"
    )
    private Integer vacationDays;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate startVacation;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate endVacation;

    @AssertTrue(message = "При расчете с датами отпуска " +
            "необходимо указать даты начала и конца, а также " +
            "убедиться, что дата конца отпуска не раньше, чем дата начала")
    public boolean isRequestWithDates() {
        if (!calculateWithDates) return true;
        return startVacation != null && endVacation != null
                && endVacation.isAfter(startVacation);
    }

    public BigDecimal getSalary() {
        return salary;
    }

    public void setSalary(BigDecimal salary) {
        this.salary = salary;
    }

    @NotNull
    public Boolean getCalculateWithDates() {
        return calculateWithDates;
    }

    public void setCalculateWithDates(@NotNull Boolean calculateWithDates) {
        this.calculateWithDates = calculateWithDates;
    }

    public Integer getVacationDays() {
        return vacationDays;
    }

    public void setVacationDays(Integer vacationDays) {
        this.vacationDays = vacationDays;
    }

    public LocalDate getStartVacation() {
        return startVacation;
    }

    public void setStartVacation(LocalDate startVacation) {
        this.startVacation = startVacation;
    }

    public LocalDate getEndVacation() {
        return endVacation;
    }

    public void setEndVacation(LocalDate endVacation) {
        this.endVacation = endVacation;
    }
}
