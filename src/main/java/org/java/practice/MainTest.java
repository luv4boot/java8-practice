package org.java.practice;

public class MainTest {
    public static void main(String[] args) {
        AbsClass ab = new AbsClass(10, 20) {
            @Override
            void add(int a, int b) {
                System.out.println(a + b);
            }
        };
        ab.add(10, 20);
    }
}
