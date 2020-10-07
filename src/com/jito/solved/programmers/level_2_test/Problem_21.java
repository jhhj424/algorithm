package com.jito.solved.programmers.level_2_test;

import java.util.Arrays;

/*
    프로그래머스 - 연습문제 - 행렬의 곱셈 : https://programmers.co.kr/learn/courses/30/lessons/12949/solution_groups?language=java&type=my
 */
public class Problem_21 {
    public static void main(String[] args) {
        int[][] arr1 = {{1,4},{3,2},{4,1}};
        int[][] arr2 = {{3,3},{3,3}};
        System.out.println(Arrays.deepToString(solution(arr1, arr2))); // 전부다 15
    }
    public static int[][] solution(int[][] arr1, int[][] arr2) {
        int[][] answer = new int[arr1.length][arr2[0].length];

        for (int i = 0; i < answer.length; i++) {
            for (int j = 0; j < answer[0].length; j++) {
                for (int k = 0; k < arr1[0].length; k++) {
                    answer[i][j] += arr1[i][k] * arr2[k][j];
                }
            }
        }
        return answer;
    }
}
