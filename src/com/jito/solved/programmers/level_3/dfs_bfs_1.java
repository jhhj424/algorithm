package com.jito.solved.programmers.level_3;

/*
깊이/너비 우선 탐색(DFS/BFS) - 네트워크

https://programmers.co.kr/learn/courses/30/lessons/43162?language=java
 */
public class dfs_bfs_1 {
    public static void main(String[] args) {
        int[][] computers = {{1, 1, 0}, {1, 1, 0}, {0, 0, 1}}; // 2
//        int[][] computers = {{1, 1, 0}, {1, 1, 1}, {0, 1, 1}}; // 1
        System.out.println(sol(3,computers));
    }

    public static int sol(int n, int[][] computers) {
        int ret = 0;
        boolean[] b = new boolean[n];
        for(int i=0; i<n; i++) {
            if(!b[i]) {
                dfs(computers, i, b);
                ret++;
            }
        }
        return ret;
    }
    public static void dfs(int[][] computers, int i, boolean[] b) {
        b[i] = true;
        for(int j=0; j<computers.length; j++) {
            if(computers[i][j] == 1 && !b[j]) {
                dfs(computers, j, b);
            }
        }
    }
}
