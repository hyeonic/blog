package me.hyeonic.javabasic.immutableobject.step01;

import static org.assertj.core.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import me.hyeonic.javabasic.immutableobject.step02.Student;
import me.hyeonic.javabasic.immutableobject.step02.Students;

class StudentsTest {

    @DisplayName("원본 리스트에서 값을 추가하면 해당 내부 리스트 또한 변경된다. 즉 불변이 아니다.")
    @Test
    void 원본리스트에서_추가하면_변경된다() {
        // given
        Student student1 = new Student("학생1", 20);
        Student student2 = new Student("학생2", 20);
        Student student3 = new Student("학생3", 20);

        List<Student> studentList = new ArrayList<>(Arrays.asList(student1, student2, student3));

        Students students = new Students(studentList);

        // when
        studentList.add(new Student("학생4", 20));

        // then
        assertThat(students.getStudents().size()).isEqualTo(3);
    }
}