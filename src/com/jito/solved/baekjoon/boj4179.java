package com.jito.solved.baekjoon;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/*
 백준 4179번 문제 : 불! : BFS : https://www.acmicpc.net/problem/4179
 */
public class boj4179 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] dx = {-1,1,0,0};
        int[] dy = {0,0,-1,1};
        char[][] input = new char[n][m];
        int[][] dist = new int[n][m];
        int[][] fire = new int[n][m];
        Queue<Pair> q_fire = new LinkedList<>();
        Queue<Pair> q_J = new LinkedList<>();
        for(int i=0; i<n; i++) {
            String s = sc.next();
            for(int j=0; j<m; j++) {
                char c = s.charAt(j);
                if(c == 'J') {
                    q_J.offer(new Pair(i,j));
                }
                else if(c == 'F') {
                    q_fire.offer(new Pair(i,j));
                }
                else if(c == '.') {
                    dist[i][j] = -1;
                    fire[i][j] = -1;
                }else if(c == '#') {
                    dist[i][j] = 0;
                    fire[i][j] = 0;
                }
                input[i][j] = s.charAt(j);
            }
        }

        // 불 bfs
        while(!q_fire.isEmpty()) {
            Pair now = q_fire.poll();
            for(int i=0; i<4; i++) {
                int nx = now.x + dx[i];
                int ny = now.y + dy[i];
                if(nx < 0 || ny < 0 || nx >= n || ny >= m) continue;
                if(fire[nx][ny] >= 0) continue;
                fire[nx][ny] = fire[now.x][now.y] + 1;
                q_fire.offer(new Pair(nx, ny));
            }
        }
        // 지훈 bfs
        while(!q_J.isEmpty()) {
            Pair now = q_J.poll();
            for(int i=0; i<4; i++) {
                int nx = now.x + dx[i];
                int ny = now.y + dy[i];
                if(nx < 0 || ny < 0 || nx >= n || ny >= m) {
                    System.out.println(dist[now.x][now.y] + 1);
                    return;
                }
                if(dist[nx][ny] >= 0 || (fire[nx][ny]-1 <= dist[now.x][now.y] && fire[nx][ny] != -1)) continue;
                dist[nx][ny] = dist[now.x][now.y] + 1;
                q_J.offer(new Pair(nx, ny));
            }
        }

        System.out.println("IMPOSSIBLE");
    }
}
