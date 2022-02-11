package calculator;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@SuppressWarnings("NonAsciiCharacters")
class StringCalculatorTest {

    @DisplayName("빈 문자열을 입력할 경우 0을 반환해야 한다.")
    @Test
    void splitAndSum_빈문자열() {
        // given
        String text = "";

        // when
        int result = StringCalculator.splitAndSum(text);

        // then
        assertThat(result).isEqualTo(0);
    }

    @DisplayName("null 값을 입력할 경우 0을 반환해야 한다.")
    @Test
    void splitAndSum_null() {
        // given
        String text = null;

        // when
        int result = StringCalculator.splitAndSum(text);

        // then
        assertThat(result).isEqualTo(0);
    }
}