package me.hyeonic.javabasic.immutableobject.step03;

import static org.assertj.core.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class StudentsTest {

    @DisplayName("값을 추가하면 예외를 던진다.")
    @Test
    void 값을_추가하면_예외를_던진다() {
        // given
        Student student1 = new Student("학생1", 20);
        Student student2 = new Student("학생2", 20);
        Student student3 = new Student("학생3", 20);

        List<Student> studentList = new ArrayList<>(Arrays.asList(student1, student2, student3));

        Students students = new Students(studentList);

        // when & then
        assertThatThrownBy(() -> {
            students.getStudents().add(new Student("학생4", 20));
        }).isInstanceOf(UnsupportedOperationException.class);
    }
}