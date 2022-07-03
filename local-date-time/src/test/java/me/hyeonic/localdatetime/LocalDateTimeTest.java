package me.hyeonic.localdatetime;

import static org.assertj.core.api.Assertions.assertThat;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LocalDateTimeTest {

    @DisplayName("LocalDateTime을 생성한다.")
    @Test
    void create() {
        LocalDateTime localDateTime = LocalDateTime.of(2022, 07, 03, 18, 30);

        assertThat(localDateTime).isEqualTo("2022-07-03T18:30");
    }

    @DisplayName("LocalDate와 LocalTime을 활용하여 LocalDateTime을 생성한다.")
    @Test
    void localDateWithLocalTime() {
        LocalDate localDate = LocalDate.of(2022, 07, 03);
        LocalTime localTime = LocalTime.of(18, 30);

        LocalDateTime localDateTime = LocalDateTime.of(localDate, localTime);

        assertThat(localDateTime).isEqualTo("2022-07-03T18:30");
    }

    @DisplayName("LocalDateTime을 활용하여 LocalDate와 LocalTime을 구한다.")
    @Test
    void getLocalDateAndGetLocalTime() {
        LocalDate localDate = LocalDate.of(2022, 07, 03);
        LocalTime localTime = LocalTime.of(18, 30);
        LocalDateTime localDateTime = LocalDateTime.of(localDate, localTime);

        assertThat(localDateTime.toLocalDate()).isEqualTo(localDate);
        assertThat(localDateTime.toLocalTime()).isEqualTo(localTime);
    }
}
