package com.jito.solved.algorithm;

import java.util.Arrays;

/*
중복 순열
 */
public class OverlabPermutation {
    static int[] arr = { 1, 2, 3, 4, 5 };
    public static void main(String[] args) {
        makeOverlabPermutation(3, new int[3], 0);
    }
    private static void makeOverlabPermutation(int r, int[] temp, int current) {
        if (r == current) {
            System.out.println(Arrays.toString(temp));
//            for(int i : temp){
//                System.out.print(i+" ");
//            }
//            System.out.println();
        } else {
            for (int i = 0; i < arr.length; i++) {
                temp[current] = arr[i];
                makeOverlabPermutation(r, temp, current + 1);
            }
        }
    }
}
