package org.kim.vacation_calculator.service;

import org.kim.vacation_calculator.repository.HolidaysRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Set;

@Service
public class HolidayService {
    private Set<LocalDate> holidays;
    private final HolidaysRepository holidaysRepository;

    public HolidayService(HolidaysRepository holidaysRepository) {
        this.holidaysRepository = holidaysRepository;
        holidays = holidaysRepository.findAllHolidays();
    }

    public int getVacationDays(LocalDate startVacation, LocalDate endVacation) {
        LocalDate currentDay = startVacation;
        int vacationDays = 0;
        while (!currentDay.isAfter(endVacation)) {
            if (isWorkingDay(currentDay) && !isHoliday(currentDay)) {
                ++vacationDays;
            }
            currentDay = currentDay.plusDays(1);
        }
        return vacationDays;
    }

    public boolean isWorkingDay(LocalDate date) {
        return date.getDayOfWeek()
                .getValue() < 6;
    }

    public boolean isHoliday(LocalDate date) {
        return holidays.contains(date);
    }
}
