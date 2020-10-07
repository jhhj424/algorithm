package com.jito.solved.programmers.level_2_test;

import java.util.Collections;
import java.util.PriorityQueue;

/*
    프로그래머스 - Summer/Winter Coding(~2018) - 점프와 순간 이동 : https://programmers.co.kr/learn/courses/30/lessons/12980?language=java
 */
public class Problem_20 {
    public static void main(String[] args) {
        System.out.println(solution(5000)); // 5
    }

    public static int solution(int n) {
        int ans = 0;

        while (n != 0) {
            if( n % 2 == 0)
                n /= 2;
            else {
                n -= 1;
                ans++;
            }
        }

        return ans;
    }
}
