package me.hyeonic.localdatetime;

import static org.assertj.core.api.Assertions.assertThat;

import java.time.LocalDate;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LocalDateTest {

    @DisplayName("LocalDate를 생성한다.")
    @Test
    void creat() {
        LocalDate localDate = LocalDate.of(2022, 07, 03);

        assertThat(localDate).isEqualTo("2022-07-03");
    }

    @DisplayName("현재 시간을 구한다.")
    @Test
    void now() {
        LocalDate now = LocalDate.now();

        assertThat(now).isNotNull();
    }

    @DisplayName("일을 더한다.")
    @Test
    void plusDays() {
        LocalDate localDate = LocalDate.of(2022, 07, 03);
        LocalDate plusLocalDate = localDate.plusDays(1);

        assertThat(plusLocalDate).isEqualTo("2022-07-04");
    }

    @DisplayName("주를 더한다.")
    @Test
    void plusWeeks() {
        LocalDate localDate = LocalDate.of(2022, 07, 03);
        LocalDate plusLocalDate = localDate.plusWeeks(5);

        assertThat(plusLocalDate).isEqualTo("2022-08-07");
    }

    @DisplayName("월을 더한다.")
    @Test
    void plusMonths() {
        LocalDate localDate = LocalDate.of(2022, 07, 03);
        LocalDate plusLocalDate = localDate.plusMonths(7);

        assertThat(plusLocalDate).isEqualTo("2023-02-03");
    }
    
    @DisplayName("연을 더한다.")
    @Test
    void plusYears() {
        LocalDate localDate = LocalDate.of(2022, 07, 03);
        LocalDate plusLocalDate = localDate.plusYears(5);

        assertThat(plusLocalDate).isEqualTo("2027-07-03");
    }

    @DisplayName("두 날짜를 비교하여 과거를 판단한다.")
    @Test
    void isBefore() {
        LocalDate first = LocalDate.of(2022, 07, 03);
        LocalDate second = LocalDate.of(2023, 07, 03);

        boolean result = first.isBefore(second);

        assertThat(result).isTrue();
    }

    @DisplayName("두 날짜를 비교하여 미래를 판단한다.")
    @Test
    void isAfter() {
        LocalDate first = LocalDate.of(2022, 07, 03);
        LocalDate second = LocalDate.of(2023, 07, 03);

        boolean result = second.isAfter(first);

        assertThat(result).isTrue();
    }

    @DisplayName("동일한 날짜의 동등성을 판단한다.")
    @Test
    void equals() {
        LocalDate first = LocalDate.of(2022, 07, 03);
        LocalDate second = LocalDate.of(2022, 07, 03);

        boolean result = first.equals(second);

        assertThat(result).isTrue();
    }
}
