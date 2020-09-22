package com.jito.solved.programmers.level_1_test;

/*
연습문제 - 이상한 문자 만들기 - 프로그래머스

https://programmers.co.kr/learn/courses/30/lessons/12930?language=java
 */
public class Problem_17 {
    public static void main(String[] args) {
        System.out.println(solution("try hello  world  ."));
    }
    public static String solution(String s) {
        StringBuilder ret = new StringBuilder();
        String[] arr = s.split("");
        int cnt = 0;
        for(int i=0; i<arr.length; i++) {
            if(arr[i].equals(" ")) cnt = 0;
            else {
                cnt++;
                if(cnt%2!=0) arr[i] = arr[i].toUpperCase();
                else arr[i] = arr[i].toLowerCase();
            }
            ret.append(arr[i]);
        }
        return ret.toString();
    }
}
