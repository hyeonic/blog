package me.hyeonic.object.chapter07.employee;

public abstract class Employee {
    protected String name;
    protected double basePay;

    public Employee(String name, double basePay) {
        this.name = name;
        this.basePay = basePay;
    }

    public abstract double calculatePay(double taxRate);

    public abstract double monthlyBasePay();
}