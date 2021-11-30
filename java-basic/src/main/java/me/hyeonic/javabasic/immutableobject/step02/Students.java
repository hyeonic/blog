package me.hyeonic.javabasic.immutableobject.step02;

import java.util.ArrayList;
import java.util.List;

public class Students {
    private final List<Student> students;

    public Students(List<Student> students) {
        this.students = new ArrayList<>(students);
    }

    public List<Student> getStudents() {
        return students;
    }
}