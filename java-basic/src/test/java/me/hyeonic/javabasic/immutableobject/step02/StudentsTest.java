package me.hyeonic.javabasic.immutableobject.step02;

import static org.assertj.core.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class StudentsTest {

    @DisplayName("원본 리스트에서 값을 추가하면 해당 내부 리스트는 변경되지 않는다. 불변일까?")
    @Test
    void 원본리스트에서_추가하면_변경되지_않는다() {
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

    @DisplayName("요소들은 공유된다. 즉 불변이 아니다.")
    @Test
    void 요소들은_공유된다() {
        // given
        Student student1 = new Student("학생1", 20);
        Student student2 = new Student("학생2", 20);
        Student student3 = new Student("학생3", 20);

        List<Student> studentList = new ArrayList<>(Arrays.asList(student1, student2, student3));

        Students students = new Students(studentList);

        // when
        for (Student student : studentList) {
            student.setAge(10);
        }

        // then
        assertThat(students.getStudents().get(0).getAge()).isEqualTo(20);
    }

    @DisplayName("get으로 반환된 리스트를 통해 내부 리스트 변경이 가능하다. 즉 불변이 아닌다.")
    @Test
    void get으로_내부리스트_변경이_가능하다() {

        // given
        Student student1 = new Student("학생1", 20);
        Student student2 = new Student("학생2", 20);
        Student student3 = new Student("학생3", 20);

        List<Student> studentList = new ArrayList<>(Arrays.asList(student1, student2, student3));

        Students students = new Students(studentList);

        // when
        List<Student> studentsInStudentList = students.getStudents();
        studentsInStudentList.add(new Student("학생4", 20));

        // then
        assertThat(students.getStudents().size()).isEqualTo(3);
    }
}