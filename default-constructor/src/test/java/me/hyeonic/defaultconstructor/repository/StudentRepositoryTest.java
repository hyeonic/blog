package me.hyeonic.defaultconstructor.repository;

import me.hyeonic.defaultconstructor.domain.Department;
import me.hyeonic.defaultconstructor.domain.Student;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.orm.jpa.JpaSystemException;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
class StudentRepositoryTest {

    @PersistenceContext
    EntityManager em;

    @Autowired
    DepartmentRepository departmentRepository;

    @Autowired
    StudentRepository studentRepository;

    @Test
    @DisplayName("학생 list 를 전부 조회하는 test")
    void findAllStudent() {

        // given
        Department department = Department.createDepartment("소프트웨어공학과");
        departmentRepository.save(department);

        Student student1 = Student.createStudent("1234", "student1", department);
        Student student2 = Student.createStudent("1235", "student2", department);
        studentRepository.save(student1);
        studentRepository.save(student2);

        // when & then
        assertThrows(JpaSystemException.class, () -> {
            List<Student> students = studentRepository.findAll(); // -> 조회하는 시점에서 예외를 던진다.
        });
    }

    @BeforeEach
    void beforeEach() {
        Department department = Department.createDepartment("소프트웨어공학과");
        departmentRepository.save(department);

        Student student1 = Student.createStudent("1234", "student1", department);
        Student student2 = Student.createStudent("1235", "student2", department);
        studentRepository.save(student1);
        studentRepository.save(student2);
    }

    @Test
    void main() {

        em.flush();
        em.clear();

        System.out.println("================================= department 직접 접근 전 =================================");
        List<Student> students = studentRepository.findAll();
        for (Student student : students) {
            System.out.println(student.getClass());
            System.out.println(student.getDepartment().getClass());
        }

        System.out.println("================================= department 직접 접근 후 =================================");
        for (Student student : students) {
            System.out.println(student.getDepartment().getName());
        }
    }
}

