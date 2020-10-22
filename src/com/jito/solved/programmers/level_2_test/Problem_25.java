package com.jito.solved.programmers.level_2_test;

/*
    프로그래머스 - 2020 카카오 인턴십 - 키패드 누르기 : https://programmers.co.kr/learn/courses/30/lessons/67256?language=java
 */
public class Problem_25 {
    public static void main(String[] args) {
        System.out.println(solution(new int[]{1, 3, 4, 5, 8, 2, 1, 4, 5, 9, 5}, "right")); // LRLLLRLLRRL
    }

    private static String ret = "";
    private static int left = 10, right = 12;

    public static String solution(int[] numbers, String hand) {
        for (int now_num : numbers) {
            if (now_num == 1 || now_num == 4 || now_num == 7) {
                moveLeft(now_num);
            } else if (now_num == 3 || now_num == 6 || now_num == 9) {
                moveRight(now_num);
            } else { // 손가락을 선택해줘야 하는 부분

                int left_move = getDist(left, now_num);
                int right_move = getDist(right, now_num);

                if(left_move > right_move) {
                    moveRight(now_num);
                }else if(left_move < right_move) {
                    moveLeft(now_num);
                } else {
                    if (hand.equals("right")) {
                        moveRight(now_num);
                    } else {
                        moveLeft(now_num);
                    }
                }
            }
        }
        return ret;
    }

    static void moveLeft (int now) {
        ret += "L";
        left = now;
    }

    static void moveRight(int now) {
        ret += "R";
        right = now;
    }

    static int getDist(int now, int n) {
        // 0 의 위치는 11 로 처리
        if(now == 0) now = 11;
        if(n == 0) n = 11;

        int x = (now-1) / 3;
        int y = (now-1) % 3;

        int num_x = (n-1) / 3;
        int num_y = (n-1) % 3;

        return Math.abs(x - num_x) + Math.abs(y - num_y);
    }
}