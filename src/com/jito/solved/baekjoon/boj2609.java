package com.jito.solved.baekjoon;

import java.util.Scanner;

/*
    최대공약수와 최소공배수 : 유클리드 호제법 : https://www.acmicpc.net/problem/2609
 */
public class boj2609 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        long gcd = gcd(Math.max(n, m), Math.min(n, m));
        System.out.println(gcd);
        System.out.println(((long)n*(long)m) / gcd);
    }
    static long gcd(long big, long small) {
        if(small==0) return big;
        return gcd(small, big%small);
    }
}
