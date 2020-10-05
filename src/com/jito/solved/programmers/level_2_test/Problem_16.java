package com.jito.solved.programmers.level_2_test;

/*
    프로그래머스 - 연습문제 - 땅따먹기 : https://programmers.co.kr/learn/courses/30/lessons/12913?language=java
 */
public class Problem_16 {
    public static void main(String[] args) {
        int[][] land = {{1,2,3,5},{5,6,7,8},{4,3,2,1}};
        System.out.println(solution(land));
    }

    static int solution(int[][] land) {
        int answer = 0;
        for(int i=1; i<land.length; i++) {
            land[i][0] += Math.max(land[i-1][1], Math.max(land[i-1][2], land[i-1][3]));
            land[i][1] += Math.max(land[i-1][0], Math.max(land[i-1][2], land[i-1][3]));
            land[i][2] += Math.max(land[i-1][1], Math.max(land[i-1][0], land[i-1][3]));
            land[i][3] += Math.max(land[i-1][1], Math.max(land[i-1][2], land[i-1][0]));
        }
        for(int i=0; i<4; i++) {
            answer = Math.max(answer, land[land.length-1][i]);
        }
        return answer;
    }
}
