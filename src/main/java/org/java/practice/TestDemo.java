package org.java.practice;

public class TestDemo {
    public static void main(String[] args) {
        String word = "abc";
        char[] chars = word.toCharArray();

        int count = 0;
        for (Character ch : chars) {
            count++;
        }

        System.out.println("total number of characters in string is " + count);

    }
}
