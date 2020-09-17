package com.jito.solved.programmers.level_1_test;

import java.util.Arrays;

/*
그리디 문제 - 체육복 - 프로그래머스

https://programmers.co.kr/learn/courses/30/lessons/42862?language=java
 */
public class Problem_7 {
    public static void main(String[] args) {
        int n = 5;
        int lost[] = {2,4};
        int reserve[] = {3};
        System.out.println(solution(n,lost,reserve));
    }
    public static int solution(int n, int[] lost, int[] reserve) {
        int ret = 0;
        int[] arr = new int[n+2];
        Arrays.fill(arr, 1);
        for (int aLost : lost) {
            arr[aLost]--;
        }
        for (int aReserve : reserve) {
            arr[aReserve]++;
        }
        for(int i=0; i<arr.length; i++) {
            if(arr[i] == 0) {
                if(arr[i-1]==2) {
                    arr[i] = 1;
                    arr[i-1]--;
                    continue;
                }
                else if(arr[i+1]==2) {
                    arr[i] = 1;
                    arr[i+1]--;
                }
            }
        }
        for(int i=1; i<arr.length-1; i++) {
            if(arr[i]>0) ret++;
        }
        return ret;
    }
}
