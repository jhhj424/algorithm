package com.jito.solved.programmers;

import java.util.Arrays;

public class level1_6 {
    public static void main(String[] args) {
        System.out.println(평균구하기1(new int[]{1, 2, 3, 4,}));
        System.out.println(평균구하기2(new int[]{1, 2, 3, 4,}));
    }
    public static double 평균구하기1(int[] arr) {
        if(arr == null) {
            return 0;
        }
        double answer = 0;
        int sum = 0;
        for(int i=0; i<arr.length; i++ ) {
            sum += arr[i];
        }
        answer = (double)sum/arr.length;
        return answer;
    }
    public static double 평균구하기2(int[] array) {
        return (double)Arrays.stream(array).average().orElse(0);
    }
}
