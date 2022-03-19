package com.realtime.interviews.java8;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Arrays;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Emp {
    private int empId;
    private String empName;
    private int deptId;
    private String status = "active";
    private int salary;

    public static List<Emp> listOfEmployees() {
        List<Emp> emps = Arrays.asList(
                new Emp(101, "Madhav", 101, "active", 2000),
                new Emp(102, "Kohli", 101, "active", 5000),
                new Emp(103, "Rohit", 102, "inactive", 6000),
                new Emp(104, "Smith", 102, "inactive", 4000),
                new Emp(105, "Warner", 103, "active", 3500),
                new Emp(106, "Maxwell", 103, "inactive", 3500),
                new Emp(107, "Iyer", 104, "active", 3500)
        );
        return emps;
    }
}
