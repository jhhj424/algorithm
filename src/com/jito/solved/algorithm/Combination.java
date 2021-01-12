package com.jito.solved.algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
조합
 */
public class Combination {
    static int[] arr = { 1, 2, 3, 4, 5 };
    public static void main(String[] args) {
        for(int i=1; i<=arr.length; i++) {
            makeCombination(i, new int[i], 0, 0);
        }
        System.out.println(list);
    }
    static ArrayList<String> list = new ArrayList<>();
    private static void makeCombination(int r, int[] temp, int current, int start) {
        if (r == current) {
            list.add(Arrays.toString(temp));
//            System.out.println(Arrays.toString(temp));
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
