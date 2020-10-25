package com.jito.barkingdog.backtracking;

import java.util.Scanner;

/*
    https://www.acmicpc.net/problem/15650
    N과 M (2) 백트래킹 문제
 */
public class Boj15650 {

    static int n,m;
    static int arr[];
    static boolean isUsed[];

    static void func(int k, int s) {
        if(k == m) {
            for(int i=0; i<m; i++) {
                System.out.print(arr[i] + " ");
            }
            System.out.println();
            return;
        }
        for(int i=s; i<=n; i++) {
            if(!isUsed[i]) {
                arr[k] = i;
                isUsed[i] = true;
                func(k+1, i);
                isUsed[i] = false;
            }
        }

    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        n = scan.nextInt();
        m = scan.nextInt();

        arr = new int[m];
        isUsed = new boolean[n+1];

        func(0,1);
    }
}
