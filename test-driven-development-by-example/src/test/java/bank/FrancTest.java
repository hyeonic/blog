package bank;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class FrancTest {

    @DisplayName("가격과 수를 곱한 금액을 합계로 얻을 수 있다.")
    @Test
    void testMultiplication() {
        // given
        Franc five = new Franc(5);

        // when
        Franc product = five.times(2);

        // then
        assertThat(product.getAmount()).isEqualTo(10);
    }
}
