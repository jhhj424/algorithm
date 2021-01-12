package com.jito.solved.programmers.level_1_test;

/*
연습문제 - 핸드폰 번호 가리기

https://programmers.co.kr/learn/courses/30/lessons/12948?language=java
 */
public class Problem_27 {
    public static void main(String[] args) {
        System.out.println(solution("01033334444")); // "*******4444"
    }
    public static String solution(String phone_number) {
        StringBuilder sb = new StringBuilder();
        String[] s = phone_number.split("");
        for(int i=0; i<s.length; i++) {
            if(i<s.length-4) sb.append("*");
            else sb.append(s[i]);
        }
        return sb.toString();
    }
}
