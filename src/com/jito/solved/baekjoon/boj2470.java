package com.jito.solved.baekjoon;

import java.util.*;

/*
백준 문제 2470번 두 용액 : https://www.acmicpc.net/problem/2470
 */
public class boj2470 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i=0; i<n; i++) {
            arr[i] = sc.nextInt();
        }
        Arrays.sort(arr);
        int left = 0;
        int right = n-1;
        int max = (int)3e9;
        int result1 = -1, result2 = -1;
        while(left < right) {
            int sum = arr[left] + arr[right];

            if(Math.abs(sum) < max) {
                max = Math.abs(sum);
                result1 = arr[left];
                result2 = arr[right];
            }

            if(sum > 0) {
                right--;
            } else {
                left++;
            }
        }
        System.out.println(result1 + " " + result2);
    }
}
