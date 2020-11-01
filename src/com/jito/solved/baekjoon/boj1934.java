package com.jito.solved.baekjoon;

import java.util.Scanner;

/*
    최소공배수 : 유클리드호제법 활용 : https://www.acmicpc.net/problem/1934
 */
public class boj1934 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long k = sc.nextInt();
        for(int i=0; i<k; i++) {
            long n = sc.nextInt();
            long m = sc.nextInt();
            long gcd = gcd(Math.max(n, m), Math.min(n, m));
            System.out.println((n*m) / gcd);
        }
    }
    static long gcd(long big, long small) {
        if(small==0) return big;
        return gcd(small, big%small);
    }
}
