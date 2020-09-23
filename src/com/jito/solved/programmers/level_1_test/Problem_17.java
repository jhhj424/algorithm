package com.jito.solved.programmers.level_1_test;

import java.util.Arrays;

/*
연습문제 - x만큼 간격이 있는 n개의 숫자

https://programmers.co.kr/learn/courses/30/lessons/12954?language=java
 */
public class Problem_17 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(2, 5)));
        System.out.println(Arrays.toString(solution(2, 0)));
        System.out.println(Arrays.toString(sol(0, 2)));
        System.out.println(Arrays.toString(sol(0, 0)));
    }

    public static long[] sol(int x, int n) {
        long[] answer = new long[n];
        int index = 0;
        long i = x;
        while(index < n) {
            answer[index++] = i;
            i += x;
        }
        return answer;
    }

    public static long[] solution(int x, int n) {
        long[] answer = new long[n];
        long num = x;
        for(int i=0; i<n; i++) {
            answer[i] = num;
            num += x;
        }
        return answer;
    }
}
