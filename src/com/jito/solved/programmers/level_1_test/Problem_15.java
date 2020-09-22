package com.jito.solved.programmers.level_1_test;

import java.util.Stack;

/*
2019 카카오 개발자 겨울 인턴십 - 크레인 인형뽑기 게임 - 프로그래머스

https://programmers.co.kr/learn/courses/30/lessons/64061?language=java
 */
public class Problem_15 {
    public static void main(String[] args) {
        int[][] board = {{0,0,0,0,0},{0,0,1,0,3},{0,2,5,0,1},{4,2,4,4,2},{3,5,1,3,1}};
        int[] moves= {1,5,3,5,1,2,1,4};
        System.out.println(solution(board, moves)); // 4
    }

    public static int solution(int[][] board, int[] moves) {
        int answer = 0;
        Stack<Integer> stack = new Stack<>();
        for (int idx : moves) {
            for(int j=0; j<board.length; j++) {
                int n = board[j][idx-1];
                if(n==0) continue;
                if(!stack.isEmpty() && stack.peek() == n) {
                    stack.pop();
                    answer++;
                }
                else stack.push(n);
                board[j][idx-1] = 0;
                break;
            }
        }
        return answer * 2;
    }
}
