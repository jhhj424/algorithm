package com.jito.solved.algorithm;

import java.util.Arrays;

/*
순열
 */
public class Permutation {
    static int[] arr = { 1, 2, 3, 4, 5 };
    public static void main(String[] args) {
        makePermutation(3, new int[3], 0, new boolean[arr.length]);
    }
    private static void makePermutation(int r, int[] temp, int current, boolean[] visited) {
        if (r == current) {
            System.out.println(Arrays.toString(temp));
//            for(int i : temp){
//                System.out.print(i+" ");
//            }
//            System.out.println();
            return;
        } else {
            for (int i = 0; i < arr.length; i++) {
                if (!visited[i]) {
                    visited[i] = true;
                    temp[current] = arr[i];
                    makePermutation(r, temp, current +1, visited);
                    visited[i] = false;
                }
            }
        }
    }
}
