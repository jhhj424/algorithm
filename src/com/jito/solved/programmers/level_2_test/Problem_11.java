package com.jito.solved.programmers.level_2_test;

/*
    프로그래머스 - 연습문제 - 가장 큰 정사각형 찾기 : https://programmers.co.kr/learn/courses/30/lessons/12905
 */
public class Problem_11 {
    public static void main(String[] args) {
//        int[][] board = {{0,0,1,1}, {1,1,1,1}};
        int[][] board = {{1,0}, {0,0}};
        System.out.println(solution(board));
    }

    public static int solution(int [][]board) {
        int max = 0;
        for(int i=0; i<board.length; i++) {
            if(max<board[i][0])
                max = board[i][0];
        }
        for(int i=0; i<board[0].length; i++) {
            if(max<board[0][i])
                max = board[0][1];
        }
        for(int i=1; i<board.length; i++) {
            for(int j=1; j<board[0].length; j++) {
                if(board[i][j] != 1)
                    continue;
                board[i][j] = Math.min(board[i-1][j], Math.min(board[i-1][j-1], board[i][j-1])) + 1;

                if(board[i][j] > max)
                    max = board[i][j];
            }
        }
        return max * max;
    }
}
