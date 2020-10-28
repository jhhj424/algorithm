package com.jito.solved.programmers.level_1_test;


import java.util.*;

/*
    프로그래머스 - 2018 KAKAO BLIND RECRUITMENT - [1차] 비밀지도 : https://programmers.co.kr/learn/courses/30/lessons/17681?language=java

 */
public class Problem_29 {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(6, new int[]{46, 33, 33 ,22, 31, 50}, new int[]{27 ,56, 19, 14, 14, 10}))); // "#####","# # #", "### #", "# ##", "#####"
    }

    public static String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];
        for (int i=0; i<n; i++) {
            StringBuilder sb = new StringBuilder();
            String s1 = Integer.toBinaryString(arr1[i]);
            String s2 = Integer.toBinaryString(arr2[i]);
            s1 = toLength5(s1, n);
            s2 = toLength5(s2, n);
            for(int j=0; j<n; j++) {
                if(s1.charAt(j) == s2.charAt(j) && s1.charAt(j) == '0') {
                    sb.append(" ");
                }else {
                    sb.append("#");
                }
            }
            answer[i] = sb.toString();
        }
        return answer;
    }

    public static String toLength5(String s, int n) {
        if(s.length()==n) return s;
        return toLength5("0" + s, n);
    }
}