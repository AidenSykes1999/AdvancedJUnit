package com.spartaglobal.sortmanager;

import java.util.Arrays;

public class NumberArray {
    public static int[] arrayOfNumbers() {

        int numArray[] = new int[40];
        int rand = (int) (Math.random() * 10);

        for (int i = 0; i < numArray.length; i++) {
            numArray[i] = (int) (Math.random() * 10);

        }

        return numArray;
    }

    public static void main(String[] args) {

        int[] numbers = arrayOfNumbers();
        System.out.println(Arrays.toString(numbers));

    }

}

