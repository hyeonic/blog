package calculator;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

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

    @DisplayName("숫자 하나를 문자열로 입력할 경우 해당 숫자를 반환한다.")
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 5, 10, 100})
    void splitAndSum_숫자하나(int number) {
        // given
        String text = String.valueOf(number);

        // when
        int result = StringCalculator.splitAndSum(text);

        // then
        assertThat(result).isEqualTo(number);
    }
}