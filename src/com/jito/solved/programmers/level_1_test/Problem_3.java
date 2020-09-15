package com.jito.solved.programmers.level_1_test;

import java.util.Arrays;
import java.util.HashSet;

/*
두 개 뽑아서 더하기 - 프로그래머스

https://programmers.co.kr/learn/courses/30/lessons/68644?language=java
 */
public class Problem_3 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(new int[]{2, 1, 3, 4, 1}))); // 2,3,4,5,6,7
    }

    public static Integer[] solution(int[] numbers) {
        HashSet<Integer> set = new HashSet<>();
        for(int i=0; i<numbers.length-1; i++) {
            for(int j=i+1; j<numbers.length; j++) {
                set.add(numbers[i]+numbers[j]);
            }
        }
        Integer[] answer =  set.toArray(new Integer[]{});
        Arrays.sort(answer);
        return answer;
    }
}
