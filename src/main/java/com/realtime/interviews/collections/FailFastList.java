package com.realtime.interviews.collections;

import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class FailFastList {
    public static void main(String[] args) {
//        List<String> list = new ArrayList<>();
        List<String> list = new CopyOnWriteArrayList<>();
        list.add("a");
        list.add("b");
        list.add("c");
        list.add("d");

        Iterator<String> itr = list.iterator();
        while (itr.hasNext()) {
            String element = itr.next();
            System.out.println(element);
            list.add("e");
        }
    }
}
