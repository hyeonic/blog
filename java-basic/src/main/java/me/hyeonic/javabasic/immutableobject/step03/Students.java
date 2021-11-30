package me.hyeonic.javabasic.immutableobject.step03;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Students {
    private final List<Student> students;

    public Students(List<Student> students) {
        this.students = new ArrayList<>(students);
    }

    public List<Student> getStudents() {
        return Collections.unmodifiableList(students);
    }
}