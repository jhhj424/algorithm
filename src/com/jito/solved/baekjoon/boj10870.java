package com.jito.solved.baekjoon;

import java.util.Scanner;

/*
백준 10870번 피보나치 수 5 : https://www.acmicpc.net/problem/10870
 */
public class boj10870 {
    static int[] arr;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        arr = new int[n+1];
        int fibo = fibo(n);
        System.out.println(fibo);
    }
    public static int fibo(int n) {
        if(n < 2) return n;
        if(arr[n] != 0) return arr[n];
        return arr[n] = fibo(n-2) + fibo(n-1);
    }
}
