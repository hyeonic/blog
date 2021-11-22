package me.hyeonic.object.chapter07.employee;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Application {
    private static List<Employee> employees;

    public static void main(String[] args) {
        employees = new ArrayList<>(Arrays.asList(
                new SalariedEmployee("직원A", 400),
                new SalariedEmployee("직원B", 300),
                new SalariedEmployee("직원C", 250),
                new HourlyEmployee("아르바이트D", 1, 120),
                new HourlyEmployee("아르바이트E", 1, 120),
                new HourlyEmployee("아르바이트F", 1, 120)
        ));

        sumOfPays();
    }

    private static void sumOfPays() {
        double result = 0;
        for (Employee employee : employees) {
            result += employee.monthlyBasePay();
        }

        System.out.println(result);
    }
}