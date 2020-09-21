package com.jito.solved.programmers.level_1_test;

import java.util.*;

/*
프로그래머스 문자열 내림차순으로 배치하기

https://programmers.co.kr/learn/courses/30/lessons/12917?language=java
 */
public class Problem_10 {
    public static void main(String[] args) {
        System.out.println(solution("Zbcdefg"));
    }

    public static String solution(String s) {
        String arr[] = s.split("");
        Arrays.sort(arr, Collections.reverseOrder());
        return String.join("",arr);
    }
}
