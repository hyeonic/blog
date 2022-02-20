package me.hyeonic.javabasic.equalityidentity;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

class PointTest {

    @Test
    void identity() {
        // given
        Point point1 = new Point(2, 3);
        Point point2 = point1;

        // when
        boolean result = point1 == point2;

        // then
        assertThat(result).isTrue();
    }

    @Test
    void equals() {
        // given
        Point point1 = new Point(2, 3);
        Point point2 = new Point(2, 3);

        // when
        boolean result = point1.equals(point2);

        // then
        assertThat(result).isTrue();
    }
}