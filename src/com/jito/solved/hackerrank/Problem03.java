package com.jito.solved.hackerrank;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Problem03 {

    public static int minX(List<Integer> arr) {
        int sum = 0;
        int min = 0;
        for(int i : arr) {
            sum += i;
            min = Math.min(min, sum);
        }
        min--;
        return min * (-1);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        ArrayList<Integer> arr = new ArrayList<>();
        for(int i=0; i<n; i++) {
            arr.add(sc.nextInt());
        }

        int i = minX(arr);
        System.out.println(i);
    }
}
