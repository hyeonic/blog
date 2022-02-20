package me.hyeonic.javabasic.firstclasscollection;

import java.util.List;

public class Students {
    public static final int STUDENTS_MIN_SIZE = 5;

    private List<Student> students;

    public Students(List<Student> students) {
        validateSize(students);
        this.students = students;
    }

    private void validateSize(List<Student> students) {
        if (students.size() <= STUDENTS_MIN_SIZE) {
            throw new IllegalArgumentException();
        }
    }
}