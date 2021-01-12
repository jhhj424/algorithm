package com.jito;

import java.util.Arrays;

public class Main2 {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution("110010101001"))); // [3,8]
        for(int i=0; i<100; i++) {
            System.out.println((int)(Math.random() * 500000));
        }
    }

    public static int[] solution(String s) {
        int[] answer = new int[2];
        int len = 0;
        String removeZero = "";
        while(!s.equals("1")) {
            len = s.length(); // 이진수 길이
            removeZero = s.replaceAll("0",""); // 2단계
            answer[0] += 1; // 변환횟수
            answer[1] += len - removeZero.length();
            s = Integer.toBinaryString(removeZero.length());
        }
        return answer;
    }
}
