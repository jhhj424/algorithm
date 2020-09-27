package com.jito.solved.programmers.level_1_test;

import java.util.Arrays;

/*
연습문제 - 제일 작은 수 제거하기

https://programmers.co.kr/learn/courses/30/lessons/12935?language=java
 */
public class Problem_25 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(new int[]{4, 3, 2, 1})));
    }
    public static int[] solution(int[] arr) {
        if(arr.length <= 1) return new int[]{-1};
        int[] answer = new int[arr.length-1];
        int[] copy_arr = Arrays.copyOf(arr, arr.length);
        Arrays.sort(copy_arr);
        int idx = 0;
        for (int anArr : arr) {
            if (anArr == copy_arr[0]) continue;
            answer[idx++] = anArr;
        }
        return answer;
    }
}
