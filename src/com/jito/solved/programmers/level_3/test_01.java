package com.jito.solved.programmers.level_3;

/*
    프로그래머스 - 연습문제 - 2 x n 타일링 : https://programmers.co.kr/learn/courses/30/lessons/12900?language=java
 */
public class test_01 {
    public static void main(String[] args) {
        System.out.println(solution(4)); // 5
    }

    static int[] d;
    public static int solution(int n) {
        d = new int[n+1];
        return ti(n);
    }
    static int ti(int n) {
        if(n==1)
            return 1;
        if(n==2)
            return 2;
        if(d[n] != 0)
            return d[n];
        return d[n] = ti(n-2) + ti(n-1);
    }
}
