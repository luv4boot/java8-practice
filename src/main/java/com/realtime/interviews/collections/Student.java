package com.realtime.interviews.collections;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Student implements Comparable<Student> {
    private int id;
    private String name;


    @Override
    public int compareTo(Student s) {
        if (id == s.id)
            return 0;
        else if (id > s.id)
            return 1;
        else
            return -1;
    }

    public static void main(String[] args) {
        List<Student> students = Arrays.asList(
                new Student(111, "Madhav"),
                new Student(111, "Yuvraj"),
                new Student(222, "Kohli"),
                new Student(222, "Dravid")
        );
        Collections.sort(students, new IdComparator2());
        students.stream().forEach(System.out::println);
    }
}
