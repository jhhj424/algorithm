package com.jito.solved.programmers.level_2_test;

import java.util.Collections;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

/*
    프로그래머스 - 연습문제 - 최솟값 만들기 : https://programmers.co.kr/learn/courses/30/lessons/12941
 */
public class Problem_19 {
    public static void main(String[] args) {
        System.out.println(solution(new int[]{1,4,2}, new int[]{5,4,4})); // 29
    }

    public static int solution(int []A, int []B)
    {
        int answer = 0;
        PriorityQueue<Integer> q1 = new PriorityQueue<Integer>();
        PriorityQueue<Integer> q2 = new PriorityQueue<Integer>(Collections.reverseOrder());
        for(int i=0; i<A.length; i++) {
            q1.offer(A[i]);
            q2.offer(B[i]);
        }
        while (!q1.isEmpty()) {
            answer += q1.poll() * q2.poll();
        }
        return answer;
    }
}
