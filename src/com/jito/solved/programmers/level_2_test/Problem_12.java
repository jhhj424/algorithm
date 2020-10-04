package com.jito.solved.programmers.level_2_test;

/*
    프로그래머스 - 연습문제 - 피보나치 수 : https://programmers.co.kr/learn/courses/30/lessons/12945?language=java
 */
public class Problem_12 {
    public static void main(String[] args) {
        System.out.println(solution(5)); // 5
    }

    static int[] d = new int[100001];
    public static int solution(int n) {
        if(n == 1 || n == 2)
            return 1;
        if(d[n] != 0)
            return d[n];
        return d[n] = solution(n-2) + solution(n-1);
    }

}
