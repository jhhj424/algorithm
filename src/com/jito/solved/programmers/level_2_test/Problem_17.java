package com.jito.solved.programmers.level_2_test;

/*
    프로그래머스 - 연습문제 - 숫자의 표현 : https://programmers.co.kr/learn/courses/30/lessons/12924?language=java
 */
public class Problem_17 {
    public static void main(String[] args) {
        System.out.println(solution(15)); // 4
    }

    public static int solution(int n) {
        int answer = 0;
        for(int i=1; i<=n; i++) {
            int sum = 0;
            for(int j=i; j<=n; j++) {
                sum += j;
                if(sum == n) {
                    answer++;
                    break;
                }
            }
        }
        return answer;
    }
}
