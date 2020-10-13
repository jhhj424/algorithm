package com.jito.solved.programmers.level_2_test;

/*
    프로그래머스 - JadenCase 문자열 만들기 : https://programmers.co.kr/learn/courses/30/lessons/12951?language=java
 */
public class Problem_23 {
    public static void main(String[] args) {
        System.out.println(solution("3people            unFollowed me")); // 3people Unfollowed Me
        System.out.println(solution("for the last week")); // For The Last Week
    }
    public static String solution(String s) {
        StringBuilder sb = new StringBuilder();

        // 전체를 소문자로 변환
        String[] arr = s.toLowerCase().split(" ");
        for (int i=0; i<arr.length; i++) {
            if(arr[i].length() < 1) {
                sb.append(" ");
                continue;
            }
            String tmp = arr[i];
            if(tmp.charAt(0) >= 'a' && tmp.charAt(0) <= 'z') {
                sb.append(tmp.substring(0,1).toUpperCase()).append(tmp.substring(1));
            }else {
                sb.append(tmp);
            }
            if(i < arr.length-1)
                sb.append(" ");
        }
        if(s.charAt(s.length()-1) == ' ')
            sb.append(" ");

        return sb.toString();
    }
}