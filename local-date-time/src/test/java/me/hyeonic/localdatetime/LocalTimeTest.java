package me.hyeonic.localdatetime;

import static org.assertj.core.api.Assertions.assertThat;

import java.time.LocalTime;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LocalTimeTest {

    @DisplayName("LocalTime을 생성한다.")
    @Test
    void create() {
        LocalTime localTime = LocalTime.of(18, 30, 15);
        assertThat(localTime).isEqualTo("18:30:15");

        LocalTime secondWithoutLocalTime = LocalTime.of(18, 30);
        assertThat(secondWithoutLocalTime).isEqualTo("18:30");
    }

    @DisplayName("현재 시간을 구한다.")
    @Test
    void now() {
        LocalTime now = LocalTime.now();

        assertThat(now).isNotNull();
    }

    @DisplayName("시간을 더한다.")
    @Test
    void plusHours() {
        LocalTime localTime = LocalTime.of(18, 30, 15);

        LocalTime plusLocalTime = localTime.plusHours(3);

        assertThat(plusLocalTime).isEqualTo("21:30:15");
    }

    @DisplayName("분을 더한다.")
    @Test
    void plusMinutes() {
        LocalTime localTime = LocalTime.of(18, 30, 15);

        LocalTime plusLocalTime = localTime.plusMinutes(40);

        assertThat(plusLocalTime).isEqualTo("19:10:15");
    }

    @DisplayName("초를 더한다.")
    @Test
    void plusSeconds() {
        LocalTime localTime = LocalTime.of(18, 30, 15);

        LocalTime plusLocalTime = localTime.plusSeconds(15);

        assertThat(plusLocalTime).isEqualTo("18:30:30");
    }

    @DisplayName("두 시간을 비교하여 과거를 판단한다.")
    @Test
    void isBefore() {
        LocalTime first = LocalTime.of(18, 30, 15);
        LocalTime second = LocalTime.of(20, 30, 15);

        boolean result = first.isBefore(second);

        assertThat(result).isTrue();
    }

    @DisplayName("두 시간을 비교하여 미래를 판단한다.")
    @Test
    void isAfter() {
        LocalTime first = LocalTime.of(18, 30, 15);
        LocalTime second = LocalTime.of(20, 30, 15);

        boolean result = second.isAfter(first);

        assertThat(result).isTrue();
    }

    @DisplayName("동일한 시간의 동등성을 판단한다.")
    @Test
    void equals() {
        LocalTime first = LocalTime.of(18, 30, 15);
        LocalTime second = LocalTime.of(18, 30, 15);

        boolean result = first.equals(second);

        assertThat(result).isTrue();
    }
}
