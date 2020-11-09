package com.jito.solved.baekjoon;

import java.util.Scanner;

/*
백준 2447 별 찍기 10 : https://www.acmicpc.net/problem/2447
 */
public class boj2447 {
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                recursive(i, j);
            }
            sb.append("\n");
        }
        System.out.println(sb.toString());
    }
    static void recursive(int x, int y) {
        while (x != 0) {
            if (x % 3 == 1 && y % 3 == 1) {
                sb.append(" ");
                return;
            }
            x /= 3;
            y /= 3;
        }
        sb.append("*");
    }
}
