package com.jito.solved.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 백준 - 안전 영역 :  https://www.acmicpc.net/problem/2468
 */
public class Boj2468 {
    static int dx[] = { -1, 1, 0, 0 };
    static int dy[] = { 0, 0, -1, 1 };
    static int map[][];
    static boolean visited[][];
    static int N, cnt;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        int mx = -987654321;
        map = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < map.length; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] > mx) mx = map[i][j];
            }
        }
        int res = 1;
        for (int r = 0; r <= mx; r++) {
            visited = new boolean[N][N];
            cnt = 0;
            for (int x = 0; x < N; x++) {
                for (int y = 0; y < N; y++) {
                    if (map[x][y] > r && !visited[x][y]) {
                        find(x, y, r);
                        cnt++;
                    }
                }
            }
            res = Math.max(res, cnt);
        }

        System.out.println(res);
    }

    public static void find(int x, int y, int rr) {
        visited[x][y] = true;
        for (int d = 0; d < 4; d++) {
            int xx = x + dx[d];
            int yy = y + dy[d];
            if (xx < 0 || yy < 0 || xx >= N || yy >= N) continue;
            if (visited[xx][yy] || map[xx][yy] <= rr) continue;
            find(xx, yy, rr);
        }
    }
}
