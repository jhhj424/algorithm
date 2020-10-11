package com.jito.solved.baekjoon;

import java.util.*;

/*
 백준 1697번 문제 : 숨바꼭질 : bfs : https://www.acmicpc.net/problem/1697
 */
public class boj1697 {
    public static void main(String[] args) {
        int[] dist = new int[100001];
        int[] next = new int[3];
        Arrays.fill(dist, -1); // 거리를 모두 -1로 초기화

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); // 수빈이 위치
        int k = sc.nextInt(); // 동생위치 : 목적지

        dist[n] = 0;

        Queue<Integer> queue = new LinkedList<>();
        queue.offer(n);
        while(!queue.isEmpty()) {
            int now = queue.poll();

            next[0] = now + -1;
            next[1] = now + 1;
            next[2] = now * 2;

            for(int i=0; i<3; i++) {
                if(next[i] < 0 || next[i] > 100000)
                    continue;
                if(dist[next[i]] > -1)
                    continue;
                queue.offer(next[i]);
                dist[next[i]] = dist[now] + 1;
            }
        }
        System.out.println(dist[k]);
    }
}
