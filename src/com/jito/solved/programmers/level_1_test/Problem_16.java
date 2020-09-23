package com.jito.solved.programmers.level_1_test;

/*
2020 카카오 인턴십 - 키패드 누르기

https://programmers.co.kr/learn/courses/30/lessons/67256?language=java
 */
public class Problem_16 {
    public static void main(String[] args) {
        System.out.println(solution(new int[]{1, 3, 4, 5, 8, 2, 1, 4, 5, 9, 5}, "right")); // LRLLLRLLRRL
    }
    public static String solution(int[] numbers, String hand) {
        String ret = "";

        int left[] = {3,0};
        int right[] = {3,2};

        for(int n : numbers) {
            int x = 0;
            int y = 0;
            if(n<4) {
                y = n-1;
            } else if(n<7) {
                x = 1;
                y = n%4;
            } else {
                x = 2;
                y = n%7;
            }
            if(n == 0) {
                x = 3; y = 1;
            }

            // 좌,우 키패드 입력 처리
            if(n%3==0 && n != 0) {
                ret += "R";
                right[0] = x;
                right[1] = y;
                continue;
            } else if(n%3 == 1) {
                ret += "L";
                left[0] = x;
                left[1] = y;
                continue;
            }

            int left_move = Math.abs(left[0] - x) + Math.abs(left[1] - y);
            int right_move = Math.abs(right[0] - x) + Math.abs(right[1] - y);

            // 왼손잡이, 오른손잡이 처리
            if(left_move == right_move) {
                if(hand.equals("left")) {
                    ret += "L";
                    left[0] = x;
                    left[1] = y;
                } else {
                    ret += "R";
                    right[0] = x;
                    right[1] = y;
                }
            } else {
                if(left_move > right_move) {
                    ret += "R";
                    right[0] = x;
                    right[1] = y;
                } else {
                    ret += "L";
                    left[0] = x;
                    left[1] = y;
                }
            }

        }
        return ret;
    }
}
