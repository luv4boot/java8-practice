package com.luv4code.java8;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;

public class EmployeeTest {
    public static void main(String[] args) {
       /* List<String> namesList = EmployeeDatabase.getAllEmployees().stream().map(Employee::getName).collect(toList());
        Set<String> uniqueNames = new HashSet<>();

        Set<String> duplicateNames = namesList.stream().filter(name -> !uniqueNames.add(name)).collect(toSet());
//        duplicateNames.forEach(System.out::println);

        uniqueNames.forEach(System.out::println);*/


       /* List<String> namesList = EmployeeDatabase.getAllEmployees().stream().map(Employee::getName).collect(toList());
        Map<String, Long> mapOfNames = namesList.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        Set<String> duplicateNames = mapOfNames.entrySet().stream().filter(entry -> entry.getValue() > 1).map(entry -> entry.getKey()).collect(Collectors.toSet());
        duplicateNames.forEach(System.out::println);*/


    }
}
