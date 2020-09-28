package com.jito.solved.programmers.level_2_test;

import java.util.*;

/*
스택/큐 - 기능개발 : https://programmers.co.kr/learn/courses/30/lessons/42586?language=java
 */
public class Problem_6 {
    public static void main(String[] args) {
        System.out.println(solution(new int[]{93, 30, 55}, new int[]{1, 30, 5}));
    }
    public static ArrayList<Integer> solution(int[] progresses, int[] speeds) {
        int[] ret = {};
        Queue<Progress> q = new LinkedList<>();

        // 초기 값
        for(int i=0; i<progresses.length; i++) {
            q.offer(new Progress(progresses[i], speeds[i]));
        }
        ArrayList<Integer> list = new ArrayList<>();
        while(!q.isEmpty()) {
            int cnt = 0;
            int size = q.size();
            for(int i=0; i<size; i++) {
                Progress now = q.poll();
                q.offer(new Progress(now.now + now.speed, now.speed));
            }
            if(q.peek().now >= 100) {
                while (!q.isEmpty()) {
                    if(q.peek().now >= 100) {
                        cnt++;
                        q.poll();
                    } else {
                        break;
                    }
                }
            }
            if(cnt!=0)
                list.add(cnt);
        }
        return list;
    }
}
class Progress {
    int now;
    int speed;
    Progress(int n, int s) {
        this.now = n;
        this.speed = s;
    }
}