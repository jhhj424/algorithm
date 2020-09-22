package com.jito.solved.programmers.level_1_test;

/*
프로그래머스 - 연습문제 - 약수의 합

https://programmers.co.kr/learn/courses/30/lessons/12928?language=java
 */
public class Problem_16 {
    public static void main(String[] args) {
        System.out.println(solution(12)); // 28
    }
    public static int solution(int n) {
        int answer = 0;
        for(int i=1; i<=n/2; i++) if(n%i==0) answer += i;
        return answer+n;
    }
}
