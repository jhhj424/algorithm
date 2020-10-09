package com.jito.solved.programmers.level_2_test;

import java.util.ArrayList;

/*
    프로그래머스 - 월간 코드 챌린지 시즌1 - 삼각 달팽이 : https://programmers.co.kr/learn/courses/30/lessons/68645?language=java
 */
public class Problem_22 {
    public static void main(String[] args) {
        System.out.println(solution(4)); // [1,2,9,3,10,8,4,5,6,7]
    }

    public static ArrayList<Integer> solution(int n) {
        int[][] arr = new int[n+1][n+1];
        int x, y, num = 1;
        x = y = 0;
        for(int i=0; i<n; i++) {
            for(int j=i; j<n; j++) {
                if(i % 3 == 0) { // 아래
                    x++;
                }else if( i % 3 == 1) { // 오른쪽
                    y++;
                }else { // 대각선
                    x--;
                    y--;
                }
                arr[x][y] = num++;
            }
        }
        ArrayList<Integer> answer = new ArrayList<>();
        for (int[] anArr : arr) {
            for (int j = 0; j < arr.length; j++) {
                if (anArr[j] != 0)
                    answer.add(anArr[j]);
            }
        }

        return answer;
    }
}
