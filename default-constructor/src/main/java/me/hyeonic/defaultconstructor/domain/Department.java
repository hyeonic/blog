package me.hyeonic.defaultconstructor.domain;

import lombok.Getter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Getter
public class Department {

    @Id
    @GeneratedValue
    @Column(name = "department_id")
    private Long id;

    private String name;

    protected Department() { }

    private Department(String name) {
        this.name = name;
    }

    public static Department createDepartment(String name) {
        return new Department(name);
    }

    public void changeName(String name) {
        this.name = name;
    }
}