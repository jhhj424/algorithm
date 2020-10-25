package com.jito.barkingdog.backtracking;

import java.util.Scanner;

/*
    https://www.acmicpc.net/problem/15649
    N과 M (1) 백트래킹 문제 - 순열
 */
public class Boj15649 {

    static int n,m;
    static int arr[];
    static boolean isUsed[];

    static void func(int k) {
        if(k == m) {
            for(int i=0; i<m; i++) {
                System.out.print(arr[i] + " ");
            }
            System.out.println();
            return;
        }
        for(int i=1; i<=n; i++) {
            if(!isUsed[i]) {
                arr[k] = i;
                isUsed[i] = true;
                func(k+1);
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

        func(0);
    }
}
