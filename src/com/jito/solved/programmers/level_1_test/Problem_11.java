package com.jito.solved.programmers.level_1_test;

/*
 프로그래머스 - 문자열 다루기 기본

https://programmers.co.kr/learn/courses/30/lessons/12918?language=java
 */
public class Problem_11 {
    public static void main(String[] args) {
        System.out.println(solution("a234"));
        System.out.println(solution("1234"));
    }
    public static boolean solution(String s) {
        if(!(s.length()==4 || s.length()==6)) return false;
        for(int i=0; i<s.length(); i++) {
            if(!(s.charAt(i) >= '0' && s.charAt(i)<='9')) return false;
        }
        return true;
    }
}
