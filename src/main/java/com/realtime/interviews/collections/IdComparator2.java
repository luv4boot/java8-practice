package com.realtime.interviews.collections;

import java.util.Comparator;

public class IdComparator2 implements Comparator<Student> {
    @Override
    public int compare(Student s1, Student s2) {

        //if both the id's are same then sorting based on name
        if (s1.getId() == s2.getId())
            return s1.getName().compareTo(s2.getName());
        else if (s1.getId() > s2.getId())
            return 1;
        else
            return -1;

    }
}
