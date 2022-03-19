package com.realtime.interviews.java8;

import java.util.*;
import java.util.stream.Collectors;

public class EmpTest {
    public static void main(String[] args) {
        List<Emp> emps = Emp.listOfEmployees();

//to print employee details based on departments
        printEmployeeDetailsBasedOnDepartment(emps);

//to print employees count working in each department
        countEmployesWorkingInEachDepartment(emps);

//to print active and inactive employees in the given collection
        countActiveAndInactiveEmployees(emps);

//to print max/min salary from the given collection
        maxAndMinSalary(emps);
//to print max salary form each department
        getMaxSalaryFromEachDepartment(emps);

    }

    private static void getMaxSalaryFromEachDepartment(List<Emp> emps) {
        Map<Integer, Optional<Emp>> maxSalaryFromEachDepartment = emps.stream().collect(Collectors.groupingBy(Emp::getDeptId, Collectors.maxBy(Comparator.comparing(Emp::getSalary))));
        maxSalaryFromEachDepartment.entrySet().forEach(entry -> {
            System.out.println("DepartmentId: " + entry.getKey());
            Optional<Emp> optionalEmp = entry.getValue();
            if (optionalEmp.isPresent()) {
                String employeeName = optionalEmp.get().getEmpName();
                int salary = optionalEmp.get().getSalary();
                System.out.println(employeeName + " -- " + salary);
            }
        });
    }

    private static void maxAndMinSalary(List<Emp> emps) {
        DoubleSummaryStatistics salaryStats = emps.stream().collect(Collectors.summarizingDouble(Emp::getSalary));
        System.out.println("Max Salary: " + salaryStats.getMax());
        System.out.println("Min Salary: " + salaryStats.getMin());
        System.out.println("Average Salary: " + salaryStats.getAverage());
        System.out.println("Total Salary: " + salaryStats.getSum());
    }

    private static void countActiveAndInactiveEmployees(List<Emp> emps) {
        Map<Boolean, List<Emp>> partitionByEmpStatus = emps.stream().collect(Collectors.partitioningBy(emp -> emp.getStatus().equals("active")));
        partitionByEmpStatus.entrySet().forEach(entry -> {
            if (entry.getKey()) {
                System.out.print("Employee status active: ");
            } else {
                System.out.print("Employee status inactive: ");
            }
            List<Emp> list = entry.getValue();
            long count = list.stream().count();
            System.out.println(count);
        });
    }

    private static void countEmployesWorkingInEachDepartment(List<Emp> emps) {
        Map<Integer, Long> employeesWorkingInEachDept = emps.stream().collect(Collectors.groupingBy(Emp::getDeptId, Collectors.counting()));
        employeesWorkingInEachDept.entrySet().forEach(entry -> {
            System.out.println(entry.getKey() + " ---- " + entry.getValue());
        });
    }

    private static void printEmployeeDetailsBasedOnDepartment(List<Emp> emps) {
        Map<Integer, List<Emp>> empsBasedOnDepartments = emps.stream().collect(Collectors.groupingBy(Emp::getDeptId, Collectors.toList()));
        Set<Map.Entry<Integer, List<Emp>>> entries = empsBasedOnDepartments.entrySet();

        Iterator<Map.Entry<Integer, List<Emp>>> iterator = entries.iterator();
        while (iterator.hasNext()) {
            Map.Entry<Integer, List<Emp>> entry = iterator.next();
            System.out.println("Department Id: " + entry.getKey());
            List<Emp> list = entry.getValue();
            list.stream().forEach(System.out::println);
        }
    }
}
