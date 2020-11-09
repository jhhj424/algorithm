package com.jito.solved.baekjoon;

import java.util.Scanner;

/*
백준 10872번 팩토리얼 : https://www.acmicpc.net/problem/10872
 */
public class boj10872 {

    public static int[] arr;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        arr = new int[n+1];
        arr[0] = 1;
        int factorial = factorial(n, 1);
        System.out.println(factorial);
    }
    public static int factorial(int n, int start) {
        if(arr[n] != 0) return arr[n];
        arr[start] = arr[start-1] * start;
        return factorial(n, start+1);
    }
}
