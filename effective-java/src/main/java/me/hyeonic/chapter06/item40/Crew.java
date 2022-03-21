package me.hyeonic.chapter06.item40;

import java.util.Objects;

public class Crew {

    private final String name;
    private final Course course;

    public Crew(String name, Course course) {
        this.name = name;
        this.course = course;
    }

    public Crew() {
        this("unknown", Course.NONE);
    }

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Crew crew = (Crew) o;
        return Objects.equals(name, crew.name) && course == crew.course;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, course);
    }

    public String toString() {
        return "Crew{" +
                "name='" + name + '\'' +
                ", course=" + course +
                '}';
    }
}
