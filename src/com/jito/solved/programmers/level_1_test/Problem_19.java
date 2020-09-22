package com.jito.solved.programmers.level_1_test;

import java.util.ArrayList;
import java.util.Arrays;

/*
연습문제 - 자연수 뒤집어 배열로 만들기

https://programmers.co.kr/learn/courses/30/lessons/12932?language=java
 */
public class Problem_19 {
    public static void main(String[] args) {

        double beforeTime = System.currentTimeMillis(); //코드 실행 전에 시간 받아오기

        System.out.println(Arrays.toString(solution(1234512345)));

        double afterTime = System.currentTimeMillis(); // 코드 실행 후에 시간 받아오기
        double secDiffTime = (afterTime - beforeTime)/1000; //두 시간에 차 계산
        System.out.println("1번째 solution() 런타임 : "+secDiffTime);

        beforeTime = System.currentTimeMillis(); //코드 실행 전에 시간 받아오기

        System.out.println(Arrays.toString(solution1(1234512345)));

        afterTime = System.currentTimeMillis(); // 코드 실행 후에 시간 받아오기
        secDiffTime = (afterTime - beforeTime)/1000; //두 시간에 차 계산
        System.out.println("2번째 solution 런타임 : "+secDiffTime);
    }
    public static int[] solution(long n) {
        int[] ret = new int[String.valueOf(n).length()];
        int idx = 0;
        while(n != 0) {
            ret[idx++] = (int)(n % 10);
            n/=10;
        }
        return ret;
    }
    public static int[] solution1(long n) {
        ArrayList<Integer> list = new ArrayList<>();
        while(n != 0) {
            list.add((int)(n % 10));
            n/=10;
        }
        int[] arr = new int[list.size()];
        Arrays.setAll(arr, list::get);
        return arr;
    }
}
