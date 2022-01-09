package me.hyeonic.modernjavainaction.chapter09.testing;

import static java.util.Comparator.*;
import static java.util.stream.Collectors.*;

import java.util.Comparator;
import java.util.List;
import java.util.Objects;

public class Point {
    public static final Comparator<Point> compareByXAndThenY = comparing(Point::getX).thenComparing(Point::getY);

    private final int x;
    private final int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public static List<Point> moveAllPointsRightBy(List<Point> points, int x) {
        return points.stream()
                     .map(p -> new Point(p.getX() + x, p.getY()))
                     .collect(toList());
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        Point point = (Point)o;
        return x == point.x && y == point.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }
}
