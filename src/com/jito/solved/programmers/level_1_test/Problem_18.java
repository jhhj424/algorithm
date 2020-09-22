package com.jito.solved.programmers.level_1_test;

/*
연습문제 - 자릿수 더하기 - 프로그래머스

https://programmers.co.kr/learn/courses/30/lessons/12931?language=java
 */
public class Problem_18 {
    public static void main(String[] args) {
        System.out.println(solution(123)); // 6
        System.out.println(solution(987)); // 24
    }
    public static int solution(int n) {
        int answer = 0;
        while (n != 0) {
            answer += n % 10;
            n /= 10;
        }
        return answer;
    }
    public static int solution2(int n) {
        int answer = 0;
        String[] arr = String.valueOf(n).split("");
        for(String s: arr) answer += Integer.parseInt(s);
        return answer;
    }
}
