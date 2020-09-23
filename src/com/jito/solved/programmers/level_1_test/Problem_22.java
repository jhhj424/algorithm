package com.jito.solved.programmers.level_1_test;

import java.util.Arrays;
import java.util.Collections;

/*
연습문제 - 정수 내림차순으로 배치하기

https://programmers.co.kr/learn/courses/30/lessons/12933?language=java
 */
public class Problem_22 {
    public static void main(String[] args) {
        System.out.println(solution(118372));// 873211
    }

    public static long solution(long n) {
        String[] arr = String.valueOf(n).split("");
        Arrays.sort(arr, Collections.reverseOrder());
        return Long.parseLong(Arrays.toString(arr).replaceAll("[^0-9]",""));
    }
}
