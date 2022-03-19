package com.realtime.interviews.collections;

import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class FailFastMap {
    public static void main(String[] args) {
        Map<Integer, String> map = new ConcurrentHashMap<>();
//        Map<Integer, String> map = new HashMap<>();
        map.put(1, "a");
        map.put(2, "b");

        Iterator<Integer> itr = map.keySet().iterator();
        while (itr.hasNext()) {
            Integer key = itr.next();
            System.out.println(key + " : " + map.get(key));
            map.put(3, "c");
        }

    }
}
