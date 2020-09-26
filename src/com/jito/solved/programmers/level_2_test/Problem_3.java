package com.jito.solved.programmers.level_2_test;

import java.util.Arrays;

/*
프로그래머스 - 스택/큐 - 주식가격

https://programmers.co.kr/learn/courses/30/lessons/42584?language=java
 */
public class Problem_3 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(new int[]{1, 2, 3, 2, 3})));
    }
    public static int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        for(int i=0; i<prices.length; i++) {
            int cnt = 0;
            for(int j=i+1; j<prices.length; j++) {
                cnt++;
                if(prices[i] > prices[j]) break;
            }
            answer[i] = cnt;
        }
        return answer;
    }
}
