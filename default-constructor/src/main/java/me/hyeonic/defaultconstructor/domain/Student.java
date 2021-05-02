package me.hyeonic.defaultconstructor.domain;

import lombok.Getter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
@Getter
public class Student {

    @Id @GeneratedValue
    @Column(name = "student_id")
    private Long id;

    private String number;

    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "department_id")
    private Department department;

    protected Student() { }

    private Student(String number, String name, Department department) {
        this.number = number;
        this.name = name;
        this.department = department;
    }

    public static Student  createStudent(String number, String name, Department department) {
        return new Student(number, name, department);
    }
}

