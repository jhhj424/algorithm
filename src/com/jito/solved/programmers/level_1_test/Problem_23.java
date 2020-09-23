package com.jito.solved.programmers.level_1_test;

/*
연습문제 - 콜라츠 추측

https://programmers.co.kr/learn/courses/30/lessons/12943?language=java
 */
public class Problem_23 {
    public static void main(String[] args) {
        System.out.println(solution(16));// 4
        System.out.println(sol(16));// 4
    }

    public static int solution(int num) {
        int answer = 0;
        long n = num;
        while(n != 1) {
            if(answer == 500) return -1;
            if(n%2 == 0) {
                n /=2;
                answer++;
            } else {
                n *=3;
                n +=1;
                answer++;
            }
        }
        return answer;
    }

    public static int sol(int num) {
        long n = (long)num;
        for(int i =0; i<500; i++){
            if(n==1) return i;
            n = (n%2==0) ? n/2 : n*3+1;
        }
        return -1;
    }
}
