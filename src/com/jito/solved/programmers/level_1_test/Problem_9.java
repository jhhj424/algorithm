package com.jito.solved.programmers.level_1_test;

import java.util.Arrays;

/*
프로그래머스 - 문자열 내 마음대로 정렬하기

https://programmers.co.kr/learn/courses/30/lessons/12915?language=java
 */
public class Problem_9 {
    public static void main(String[] args) {
        String s[] = {"abce", "abcd", "cdx"};
        int n = 1;
        System.out.println(Arrays.toString(solution(s, n)));
    }
    public static String[] solution(String[] strings, int n) {
        Arrays.sort(strings, (o1, o2) -> {
            char c1 = o1.charAt(n);
            char c2 = o2.charAt(n);
            if(c1==c2) {
                return o1.compareTo(o2);
            }else return c1 - c2;
        });
        return strings;
    }
}
