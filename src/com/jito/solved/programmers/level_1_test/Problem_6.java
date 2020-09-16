package com.jito.solved.programmers.level_1_test;

/*
프로그래머스 2016년

https://programmers.co.kr/learn/courses/30/lessons/12901
 */
public class Problem_6 {
    public static void main(String[] args) {
        System.out.println(solution(1, 6));
    }

    public static String solution(int a, int b) {
        String[] day = {"SUN", "MON", "TUE", "WED", "THU", "FRI", "SAT" }; //요일 배열
        int[] maxday = {31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31}; //1월부터 12월까지 마지막날짜
        int d = 0;
        for(int i=0; i<a-1; i++) {
            d += maxday[i];
        }
        d += b;
        int day_num = d % 7 + 4;
        if(day_num > 6) day_num -= 7;
        return day[day_num];
    }
}
