package com.luv4code.java8;

public class Test {
    public static void main(String[] args) {

        int[] arr = {1, 2, 3, 4, 6, 7};
        int n = arr.length + 1;

        int sum = n * (n + 1) / 2;

        int restSum = 0;

        for (int i = 0; i < arr.length; i++) {
            restSum += arr[i];
        }

        int missingNumber = sum - restSum;
        System.out.println(missingNumber);

    }
}
