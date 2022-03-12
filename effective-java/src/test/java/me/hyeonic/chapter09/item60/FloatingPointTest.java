package me.hyeonic.chapter09.item60;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public class FloatingPointTest {

    @Test
    void floatingPointTest() {
        // given
        double coin = 1.015;

        // when
        double result = coin - 0.13;

        // then
        assertThat(result).isEqualTo(0.885);
    }
}
