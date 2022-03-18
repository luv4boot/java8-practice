package org.java.practice.arrays;

public class FindSecondMaxElement {
    public static void main(String[] args) {
        int arr[] = new int[]{12, 56, 76, 89, 100, 343, 21, 234};

        int max = Integer.MIN_VALUE;
        int next_max = Integer.MIN_VALUE;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > max) {
                next_max = max;
                max = arr[i];
            } else if (arr[i] > next_max) {
                next_max = arr[i];
            }
        }

        System.out.println("Maximum and Second Maximum Values are: " + max + " " + next_max);

    }
}
