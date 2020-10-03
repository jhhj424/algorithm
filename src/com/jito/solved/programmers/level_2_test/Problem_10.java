package com.jito.solved.programmers.level_2_test;

import java.util.Arrays;

/*
    프로그래머스 - 완전탐색 - 카펫 : https://programmers.co.kr/learn/courses/30/lessons/42842?language=java
 */
public class Problem_10 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(10, 2)));
    }
    public static int[] solution(int brown, int yellow) {
        int w = 0;
        int h = 0;
        for(int i=1; i<=yellow/2+1; i++) {
            w = i;
            h = (yellow%i==0)? yellow/i: yellow/i+1;

            if(2*w + 2*h + 4 == brown)
                break;
        }
        return new int[]{Math.max(w,h)+2, Math.min(w,h)+2};
    }
}
