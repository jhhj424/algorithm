package com.jito.solved.baekjoon;

import java.util.Scanner;

/**
 * 백준 - 한수 : https://www.acmicpc.net/problem/1065
 */
public class Boj1065 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.close();

        if (n < 100) {
            System.out.println(n);
        } else {
            int result = 99;

            for (int i = 100; i <= n; ++i) {
                result += checkHanNumber(i);
            }

            if (n == 1000) result--;

            System.out.println(result);
        }
    }

    private static int checkHanNumber(int number) {
        int num1 = number / 100 % 10;
        int num2 = number / 10 % 10;
        int num3 = number % 10;

        if (num2 * 2 == num1 + num3) {
            return 1;
        }
        return 0;
    }
}
