package com.jito.solved.baekjoon;

import java.util.Scanner;

/**
 * 백준 - 안전 영역 :  https://www.acmicpc.net/problem/2468
 */
public class Boj2468_1 {
    private static int n;
    private static int totalCnt = 0;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = Integer.parseInt(sc.nextLine());
        int[][] map = new int[n][n];
        int max = 0;
        for (int i = 0; i < n; i++) {
            String[] next = sc.nextLine().split(" ");
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(next[j]);
                max = Math.max(max, map[i][j]);
            }
        }

        int result = 1;
        for (int i = 1; i < max; i++) {
            int[][] copy = copy(map);
            totalCnt = 0;
            iterDfs(copy, i);
            print(copy);
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    if (copy[j][k] == 0) continue;
                    totalCnt++;
                    dfs(copy, j, k, 101);
                }
            }
            result = Math.max(result, totalCnt);
        }
        System.out.println(result);
    }

    private static int[][] copy(int[][] map) {
        int[][] m = new int[map.length][map.length];
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map.length; j++) {
                m[i][j] = map[i][j];
            }
        }
        return m;
    }

    private static void iterDfs(int[][] map, int num) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (map[i][j] == 0) continue;
                dfs(map, i, j, num);
            }
        }
    }

    private static void dfs(int[][] map, int a, int b, int num) {
        if (a < 0 || b < 0 || a == n || b == n) return;
        if (map[a][b] > num || map[a][b] == 0) return;
        map[a][b] = 0;
        dfs(map, a-1, b, num);
        dfs(map, a+1, b, num);
        dfs(map, a, b-1, num);
        dfs(map, a, b+1, num);
    }

    private static void print(int[][] map) {
        for (int[] ints : map) {
            for (int anInt : ints) {
                System.out.print(anInt + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
}
