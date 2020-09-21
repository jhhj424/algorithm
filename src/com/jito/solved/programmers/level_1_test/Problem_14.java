package com.jito.solved.programmers.level_1_test;

/*
프로그래머스 - 시저 암호

https://programmers.co.kr/learn/courses/30/lessons/12926?language=java
 */
public class Problem_14 {
    public static void main(String[] args) {
//        System.out.println(solution("AB",1));
        System.out.println(solution("z",1));
    }
    public static String solution(String s, int n) {
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<s.length(); i++) {
            char c = s.charAt(i);
            if(Character.isLowerCase(c)) c = (char) ((c+n-'a')%26+'a');
            else if(Character.isUpperCase(c)) c = (char) ((c+n-'A')%26+'A');
            sb.append(c);
        }
        return sb.toString();
    }
}
