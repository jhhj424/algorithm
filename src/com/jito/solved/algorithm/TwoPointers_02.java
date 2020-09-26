package com.jito.solved.algorithm;

import java.util.Scanner;

/*
투 포인터

https://www.acmicpc.net/problem/2003
 */
public class TwoPointers_02 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] arr = new int[n];
        for(int i=0; i<n; i++) {
            arr[i] = sc.nextInt();
        }

        int end = 0, sum = 0, result = 0;
        for(int start = 0; start < n; start++) {
            while (sum < m && end < n) {
                sum += arr[end];
                end++;
            }
            if(sum == m)
                result++;
            sum -= arr[start];
        }
        System.out.println(result);
        sc.close();
    }
}
