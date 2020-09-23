package com.jito.solved.programmers.level_1_test;

/*
연습문제 - 정수 제곱근 판별

https://programmers.co.kr/learn/courses/30/lessons/12934?language=java
 */
public class Problem_24 {
    public static void main(String[] args) {
        System.out.println(solution(121)); // 144
        System.out.println(solution(3)); // -1
    }

    public static long solution(long n) {
        if(Math.pow((int)Math.sqrt(n),2) == n) return (long)Math.pow(Math.sqrt(n)+1,2);
        return -1;
    }
}
