package com.jito.solved.programmers.level_1_test;

import java.util.ArrayList;
import java.util.Collections;

/*
프로그래머스 - 나누어 떨어지는 숫자 배열
 */
public class Problem_8 {
    public static void main(String[] args) {

    }
    public static Integer[] solution(int[] arr, int divisor) {
        ArrayList<Integer> list = new ArrayList<>();
        for(int i:arr) if(i%divisor == 0) list.add(i);
        Collections.sort(list);
        return list.size()==0?new Integer[]{-1}:list.toArray(new Integer[]{});
    }
}
