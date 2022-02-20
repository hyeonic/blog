package bank;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class DollarTest {

    @DisplayName("가격과 수를 곱한 금액을 합계로 얻을 수 있다.")
    @Test
    void testMultiplication() {
        // given
        Dollar five = new Dollar(5);

        // when
        Dollar product = five.times(2);

        // then
        assertThat(product.getAmount()).isEqualTo(10);
    }

    @DisplayName("Dollar에서 times 연산을 수행하면 amount의 상태가 바뀌지 않아야 한다.")
    @Test
    void testMultiplicationKeepValue() {
        // given
        Dollar five = new Dollar(5);

        // when
        five.times(2);
        five.times(3);

        // then
        assertThat(five.getAmount()).isEqualTo(5);
    }

    @DisplayName("`new Dollar(5).equals(new Dollar(5))`는 true를 만족해야 한다. 즉 `동등성`을 만족한다.")
    @Test
    void testEquality() {
        // given
        Dollar dollar1 = new Dollar(5);
        Dollar dollar2 = new Dollar(5);

        // when
        boolean result = dollar1.equals(dollar2);

        // then
        assertThat(result).isTrue();
    }

    @DisplayName("`new Dollar(5).equals(new Dollar(6))`은 false를 만족해야 한다.")
    @Test
    void testNoneEquality() {
        // given
        Dollar dollar1 = new Dollar(5);
        Dollar dollar2 = new Dollar(6);

        // when
        boolean result = dollar1.equals(dollar2);

        // then
        assertThat(result).isFalse();
    }

    @DisplayName("Dollar의 `equals()`는 `null`인 경우 false이다.")
    @Test
    void testEqualityNoneNull() {
        // given
        Dollar dollar1 = new Dollar(5);
        Dollar dollar2 = null;

        // when
        boolean result = dollar1.equals(dollar2);

        // then
        assertThat(result).isFalse();
    }

    @DisplayName("Dollar의 `equals()`는 다른 객체와 비교하는 경우 false이다.")
    @Test
    void testEqualityNoneDollarObject() {
        // given
        Dollar dollar = new Dollar(5);
        Object Object = new Object();

        // when
        boolean result = dollar.equals(Object);

        // then
        assertThat(result).isFalse();
    }
}
