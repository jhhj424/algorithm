package com.jito.solved.programmers.level_2_test;

/*
    프로그래머스 - 연습문제 - 최댓값과 최솟값 : https://programmers.co.kr/learn/courses/30/lessons/12939
 */
public class Problem_15 {
    public static void main(String[] args) {
        System.out.println(solution("1 2 3 4")); // "1 4"
    }

    public static String solution(String s) {
        String[] split = s.split(" ");
        int max, min;
        max = min = Integer.parseInt(split[0]);
        for(String st : split) {
            int i = Integer.parseInt(st);
            if(max < i) max = i;
            if(min > i) min = i;
        }
        return min + " " + max;
    }
}
