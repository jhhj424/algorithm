package com.jito.solved.programmers.level_3;

import java.util.*;

/*
    프로그래머스 - 그래프 - 가장 먼 노드 : https://programmers.co.kr/learn/courses/30/lessons/49189?language=java
 */
public class Problem_03 {
    public static void main(String[] args) {
        int n = 7;
        int[][] vertex = {
                {3, 6}, {4, 3}, {3, 2}, {1, 3}, {1, 2}, {2, 4}, {5, 2}, {4, 7}
        };
        System.out.println(solution(n, vertex));
    }

    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    static int[] dist;
    public static int solution(int n, int[][] edge) {
        int answer = 0;
        dist = new int[n+1];
        for(int i=0; i<=n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int[] i : edge) {
            int a = i[0];
            int b = i[1];
            graph.get(a).add(b);
            graph.get(b).add(a);
        }
        bfs();
        int max = 0;
        for(int i = 1; i < dist.length; i++) {
            if(dist[i] > max) {
                max = dist[i];
                answer = 0;
            }
            if(dist[i] == max) {
                answer++;
            }
        }
        return answer;
    }
    static void bfs() {
        Queue<Integer> q = new LinkedList<>();
        q.offer(1);
        dist[1] = 1;
        while (!q.isEmpty()) {
            int now = q.poll();
            for(int i=0; i<graph.get(now).size(); i++) {
                int next = graph.get(now).get(i);
                if(dist[next] != 0) continue;
                dist[next] = dist[now] + 1;
                q.offer(next);
            }
        }
    }
}