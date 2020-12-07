package com.jito.solved.baekjoon;

import java.util.Scanner;

public class boj1145 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int SIZE = 5;
        // 5개의 자연수
        int[] arr = new int[SIZE];
        int min = 100;

        // 자연수 입력. 100보다 작거나 같은 서로 다른 자연수
        for (int i = 0; i < SIZE; i++) {
            arr[i] = sc.nextInt();

            if (min > arr[i]) {
                min = arr[i];
            }
        }

        int cnt = 0;
        while (true) {  // 나올 수 있는 가장 큰 값은 100 * 99 * 98 = 970,200
            for (int i = 0; i < SIZE; i++) {
                if (min % arr[i] == 0) cnt++;
            }

            // 적어도 세 개의 자연수로 나누어지는 경우 반복문 탈출
            if (cnt >= 3) break;

            cnt = 0;
            min++;
        }

        System.out.println(min);
    }
}