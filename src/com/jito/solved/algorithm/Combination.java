package com.jito.solved.algorithm;

import java.util.Arrays;

/*
조합
 */
public class Combination {
    static int[] arr = { 1, 2, 3, 4, 5 };
    public static void main(String[] args) {
        makeCombination(3, new int[3], 0, 0);
    }
    private static void makeCombination(int r, int[] temp, int current, int start) {
        if (r == current) {
            System.out.println(Arrays.toString(temp));
//            for(int i : temp){
//                System.out.print(i+" ");
//            }
//            System.out.println();
        } else {
            for (int i = start; i < arr.length; i++) {
                temp[current] = arr[i];
                makeCombination(r, temp, current + 1, i + 1);
            }
        }
    }
}
