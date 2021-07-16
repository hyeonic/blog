package me.hyeonic.javabycomparison.chapter06;

import java.io.IOException;

public class Person {

    private String name;
    private Gender gender;
    private double height;
    private double weight;

    public Person() {
    }

    public Person(String name, Gender gender, double height, double weight) {
        this.name = name;
        this.gender = gender;
        this.height = height;
        this.weight = weight;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public void addHeight(double height) {
        this.height += height;
    }

    public void addWeight(double weight) {
        this.weight += weight;
    }

    public double getBmi() {
        return this.weight / ((this.height / 100) * (this.height / 100));
    }

    public void throwException() throws IOException {
        throw new IOException();
    }
}