package me.hyeonic.javabasic.immutableobject.step01;

import java.util.List;

public class Students {
    private final List<Student> students;

    public Students(List<Student> students) {
        this.students = students;
    }

    public List<Student> getStudents() {
        return students;
    }
}