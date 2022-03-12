package me.hyeonic.chapter09.item60;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class BigDecimalTest {

    @Test
    void bigDecimalTest() {
        // given
        BigDecimal coin = new BigDecimal(1.015);

        // when
        BigDecimal result = coin.subtract(new BigDecimal("0.13"));

        // then
//        assertThat(result).isEqualTo(new BigDecimal("0.885"));
    }

    @Test
    void duplicateBigDecimalTreeSetTest() {
        // given
        Set<BigDecimal> bigDecimals = new TreeSet<>(Set.of(new BigDecimal("2.00"), new BigDecimal("2.0")));

        // when
        int size = bigDecimals.size();

        // then
        assertThat(size).isEqualTo(1);
    }

    @Test
    void duplicateBigDecimalHashSetTest() {
        // given
        Set<BigDecimal> bigDecimals = new HashSet<>(Set.of(new BigDecimal("2.00"), new BigDecimal("2.0")));

        // when
        int size = bigDecimals.size();

        // then
        assertThat(size).isEqualTo(2);
    }

    @Test
    void calculateBigDecimalTest() {
        // given
        BigDecimal bigDecimal1 = new BigDecimal("10.0");
        BigDecimal bigDecimal2 = new BigDecimal("5.0");

        // when
        BigDecimal add = bigDecimal1.add(bigDecimal2);
        BigDecimal subtract = bigDecimal1.subtract(bigDecimal2);
        BigDecimal multiply = bigDecimal1.multiply(bigDecimal2);
        BigDecimal divide = bigDecimal1.divide(bigDecimal2);
        BigDecimal remainder = bigDecimal1.remainder(bigDecimal2);

        // given
        assertAll(
                () -> assertThat(add).isEqualTo(new BigDecimal("15.0")),
                () -> assertThat(subtract).isEqualTo(new BigDecimal("5.0")),
                () -> assertThat(multiply).isEqualTo(new BigDecimal("50.00")),
                () -> assertThat(divide).isEqualTo(new BigDecimal("2")),
                () -> assertThat(remainder).isEqualTo(new BigDecimal("0.0"))
        );
    }

    @Test
    void divide() {
        // given
        BigDecimal bigDecimal1 = BigDecimal.valueOf(10);
        BigDecimal bigDecimal2 = BigDecimal.valueOf(3);

        // when
        BigDecimal divide = bigDecimal1.divide(bigDecimal2, 2, RoundingMode.UP);

        // then
        assertThat(divide).isEqualTo(BigDecimal.valueOf(3.34));
    }
}
