package com.luv4code.java8;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Arrays;
import java.util.List;

@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Employee {
    private String name;
    private String id;
    private String city;
}

class EmployeeDatabase {
    static List<Employee> getAllEmployees() {
        List<Employee> employees = Arrays.asList(
                new Employee("Madhav", "1", "Hyderabad"),
                new Employee("Mallesh", "2", "Noida"),
                new Employee("Madhav", "3", "Pune"),
                new Employee("Dhoni", "4", "Banglore"),
                new Employee("Holder", "5", "Banglore"),
                new Employee("Madhav", "6", "Delhi"),
                new Employee("Mallesh", "7", "Baroda")
        );

        return employees;
    }
}
