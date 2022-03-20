package org.java.practice;

public abstract class AbsClass {
    int a;
    int b;

    AbsClass(int a, int b) {
        this.a = a;
        this.b = b;
    }

    abstract void add(int a, int b);
}
