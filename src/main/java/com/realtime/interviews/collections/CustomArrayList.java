package com.realtime.interviews.collections;

import java.util.ArrayList;

public class CustomArrayList extends ArrayList<Object> {

    @Override
    public boolean add(Object o) {
        if (this.contains(o)) {
            return true;
        } else {
            return super.add(o);
        }
    }

    public static void main(String[] args) {
        CustomArrayList list = new CustomArrayList();
        list.add(1);
        list.add(2);
        list.add(1);
        list.add(1);
        list.add(1);

        System.out.println(list);
    }

}