package com.jito.solved.programmers.level_2_test;

/*
연습문제 - 2 x n 타일링 - DP 풀이

https://programmers.co.kr/learn/courses/30/lessons/12900?language=java
 */
public class Problem_5 {
    public static void main(String[] args) {
        System.out.println(solution(4)); // 5
    }

    static int[] arr = new int[60001];
    public static int solution(int n) {
        int answer = t(n);
        return answer;
    }
    static int t(int n) {
        if(n==1) return 1;
        if(n==2) return 2;
        if(arr[n] != 0) return arr[n];
        return arr[n] = (t(n-2) + t(n-1)) % 1000000007;
    }
}