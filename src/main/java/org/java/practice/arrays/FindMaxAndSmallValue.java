package org.java.practice.arrays;

public class FindMaxAndSmallValue {
    public static void main(String[] args) {
        int arr[] = new int[]{12, 56, 76, 89, 100, 343, 21, 234};

        int max = arr[0];
        int min = arr[0];

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            } else if (arr[i] < min) {
                min = arr[i];
            }
        }

        System.out.println("Max and Min Values are: " + max + " " + min);

    }
}
