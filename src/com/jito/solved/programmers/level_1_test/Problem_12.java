package com.jito.solved.programmers.level_1_test;

/*
프로그래머스 - 서울에서 김서방 찾기

https://programmers.co.kr/learn/courses/30/lessons/12919?language=java
 */
public class Problem_12 {
    public static void main(String[] args) {
        System.out.println(solution(new String[]{"Jane","Kim"}));
    }

    public static String solution(String[] seoul) {
        for(int i=0; i<seoul.length; i++)
            if (seoul[i].equals("Kim"))
                return "김서방은 " + i + "에 있다";
        return "";
    }
}
