package com.jito.solved.programmers.level_1_test;


import java.util.*;

/*
    프로그래머스 : 3진법 뒤집기 : https://programmers.co.kr/learn/courses/30/lessons/68935?language=java
 */
public class Problem_30 {

    public static void main(String[] args) {
//        System.out.println(solution(45)); // 7
        System.out.println();
        System.out.println(solution(125)); // 7
    }
    public static int solution(int n) {
        int answer = 0;
        String s = to3(n);
        answer = to10(s);
        return answer;
    }

    public static String to3(int n) {
        ArrayList<Integer> list = new ArrayList<>();
        while(n >= 3) {
            list.add(n%3);
            n /= 3;
        }
        list.add(n%3);
        String s = "";
        for (Integer integer : list) s += integer;
        return s;
    }

    public static int to10(String m) {
        String[] split = m.split("");
        int ret = Integer.parseInt(split[0]);
        for (int i=1; i<split.length; i++) {
            ret *= 3;
            ret += Integer.parseInt(split[i]);
        }
        return ret;
    }
}