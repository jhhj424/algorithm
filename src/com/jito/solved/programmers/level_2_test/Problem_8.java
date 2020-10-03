package com.jito.solved.programmers.level_2_test;

import java.util.Arrays;

/*
    프로그래머스 - 정렬 - H-Index : https://programmers.co.kr/learn/courses/30/lessons/42747?language=java
 */
public class Problem_8 {
    public static void main(String[] args) {
        int[] citations = {3, 0, 6, 1, 5};
        Problem_8 p = new Problem_8();
        System.out.println(p.solution(citations));
    }

    public int solution(int[] citations) {
        Arrays.sort(citations);
        for(int i=0; i<citations.length; i++) {
            int H = citations.length-i;

            if(citations[i] >= H) {
                return H;
            }
        }
        return 0;
    }
}
