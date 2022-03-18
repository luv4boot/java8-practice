package com.realtime.interviews;

import java.util.*;
import java.util.stream.Collectors;

public class EmployeeTest {
    public static void main(String[] args) {

        List<Employee> employees = EmployeeRepository.employeeList();

        //how many male and female employees are there in organization?
        Map<String, Long> noOfMaleAndFemaleEmployees = employees.stream().collect(Collectors.groupingBy(Employee::getGender, Collectors.counting()));
        System.out.println("Total no of Male and Female Employees in the organization.....\n");
        System.out.println(noOfMaleAndFemaleEmployees);

        //print all departments in the organization

        System.out.println("\nList of all the departments in the organization....\n");
        employees.stream().map(Employee::getDepartment).distinct().forEach(System.out::println);

        //what is the average age of male and female employees
        Map<String, Double> avgAgeOfMaleAndFemaleEmployees = employees.stream().collect(Collectors.groupingBy(Employee::getGender, Collectors.averagingInt(Employee::getAge)));
        System.out.println("\nAverage Age of Male And Female Employees.....\n");
        System.out.println(avgAgeOfMaleAndFemaleEmployees);

        //get the details of highest paid employee in the organization
        Optional<Employee> highestPaidEmployeeWrapper = employees.stream().collect(Collectors.maxBy(Comparator.comparingDouble(Employee::getSalary)));
        System.out.println("\nThe Maximum Salary of employee in the organization\n");
        System.out.println(highestPaidEmployeeWrapper.get().getName());

        //get the names of employees who have joined after 2015?
        System.out.println("\nEmployee Names after joining 2015\n");
        employees.stream().filter(employee -> employee.getYearOfJoining() > 2015).map(Employee::getName).forEach(System.out::println);

        //count the no of employees in each department
        Map<String, Long> noOfEmployeesForEachDepartment = employees.stream().collect(Collectors.groupingBy(Employee::getDepartment, Collectors.counting()));
        System.out.println("\nNumber of employees working for each department\n");
        System.out.println(noOfEmployeesForEachDepartment);

        //what is the average salary of each department
        Map<String, Double> avarageSalaryForEachDepartment = employees.stream().collect(Collectors.groupingBy(Employee::getDepartment, Collectors.averagingDouble(Employee::getSalary)));
        System.out.println("\nAverage Salary for each Department\n");
        System.out.println(avarageSalaryForEachDepartment);

        //get the details of youngest male employee in the product development team
        Optional<Employee> youngestMaleEmployeeInProductDevelopmentWrapper = employees.stream().filter(employee -> employee.getGender() == "Male" && employee.getDepartment() == "Product Development").min(Comparator.comparing(Employee::getAge));
        System.out.println("\nYoungest Male Employee Details in Product Development Department\n");
        System.out.println(youngestMaleEmployeeInProductDevelopmentWrapper.get().getName());

        //who was the most working experience in the organization
        Optional<Employee> seniorMostEmployeeWrapper = employees.stream().sorted(Comparator.comparing(Employee::getYearOfJoining)).findFirst();
        System.out.println("\nMost working experience employee in the organization\n");
        System.out.println(seniorMostEmployeeWrapper.get());

        //how many male and female employees are there in the sales and marketing team?
        Map<String, Long> noOfMaleAndFemaleEmployeesInSalesAndMarketingTeam = employees.stream().filter(employee -> employee.getDepartment() == "Sales And Marketing").collect(Collectors.groupingBy(Employee::getGender, Collectors.counting()));
        System.out.println("\nNo of Male and Female Employees are there in Sales and Marketing Department\n");
        System.out.println(noOfMaleAndFemaleEmployeesInSalesAndMarketingTeam);

        //what is the average salary of male and female employee
        Map<String, Double> averagingSalaryForMaleAndFemaleEmployees = employees.stream().collect(Collectors.groupingBy(Employee::getGender, Collectors.averagingDouble(Employee::getSalary)));
        System.out.println("\nAverage Salary for Male and Female Employees\n");
        System.out.println(averagingSalaryForMaleAndFemaleEmployees);

        //list down the employee list in each department
        Map<String, List<Employee>> employeeListForEachDepartment = employees.stream().collect(Collectors.groupingBy(Employee::getDepartment));
        System.out.println("\nEmployee List for each department......\n");
        Set<Map.Entry<String, List<Employee>>> set = employeeListForEachDepartment.entrySet();
        for (Map.Entry entry : set) {
            System.out.println("Department Name: " + entry.getKey());
            List<Employee> employeeList = (List<Employee>) entry.getValue();
            System.out.println("Employees: " + employeeList);
        }

        //what is the average salary and total salary in the organization
        DoubleSummaryStatistics employeeSalaryStats = employees.stream().collect(Collectors.summarizingDouble(Employee::getSalary));
        System.out.println("\nEmployee Average Salary and Total Salary\n");
        System.out.println("Average Salary: " + employeeSalaryStats.getAverage());
        System.out.println("Total Salary: " + employeeSalaryStats.getSum());

        //separate the employees who are younger or equal to 25 years from those employees who are older than 25 years
        Map<Boolean, List<Employee>> partitionEmployeeByAge = employees.stream().collect(Collectors.partitioningBy(employee -> employee.getAge() > 25));
        Set<Map.Entry<Boolean, List<Employee>>> entries = partitionEmployeeByAge.entrySet();
        for (Map.Entry<Boolean, List<Employee>> entry : entries) {
            if (entry.getKey()) {
                System.out.println("Employees older than 25 years: ");
            } else System.out.println("Employees are Younger than or equal to 25 years");
            List<Employee> list = entry.getValue();
            for (Employee employee : list) {
                System.out.println(employee.getName());
            }
        }

        //who is the oldest employee in the organization? what is his age and which department he belongs to?
        Optional<Employee> oldestEmployeeWrapper = employees.stream().max(Comparator.comparingInt(Employee::getAge));
        Employee oldestEmployee = oldestEmployeeWrapper.get();
        System.out.println("\nName: "+oldestEmployee.getName());
        System.out.println("Age: "+oldestEmployee.getAge());
        System.out.println("Department: "+oldestEmployee.getDepartment());

    }
}
