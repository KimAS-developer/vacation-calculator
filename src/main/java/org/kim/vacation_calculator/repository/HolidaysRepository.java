package org.kim.vacation_calculator.repository;

import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Repository
public class HolidaysRepository {
    private final Set<LocalDate> holidays;

    public HolidaysRepository() {
        holidays = new HashSet<>();
        init();
    }

    public Set<LocalDate> findAllHolidays() {
        return holidays;
    }

    public void init() {
        holidays.add(LocalDate.of(2025, 1, 1));
        holidays.add(LocalDate.of(2025, 1, 2));
        holidays.add(LocalDate.of(2025, 1, 3));
        holidays.add(LocalDate.of(2025, 1, 4));
        holidays.add(LocalDate.of(2025, 1, 6));
        holidays.add(LocalDate.of(2025, 1, 7));
        holidays.add(LocalDate.of(2025, 1, 8));
        holidays.add(LocalDate.of(2025, 2, 23));
        holidays.add(LocalDate.of(2025, 3, 8));
        holidays.add(LocalDate.of(2025, 5, 1));
        holidays.add(LocalDate.of(2025, 5, 9));
        holidays.add(LocalDate.of(2025, 6, 12));
        holidays.add(LocalDate.of(2025, 11, 4));

        // Переносы
        holidays.add(LocalDate.of(2025, 2, 2));  // с 4 января
        holidays.add(LocalDate.of(2025, 5, 2));  // с 4 января
        holidays.add(LocalDate.of(2025, 5, 8));  // с 23 февраля
        holidays.add(LocalDate.of(2025, 6, 13)); // с 8 марта
        holidays.add(LocalDate.of(2025, 11, 3)); // с 1 ноября
        holidays.add(LocalDate.of(2025, 12, 31)); // с 5 января
    }
}
