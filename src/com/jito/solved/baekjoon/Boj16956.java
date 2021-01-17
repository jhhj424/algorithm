package com.jito.solved.baekjoon;

import java.util.Scanner;

/**
 * 백준 - 늑대와 양 : https://www.acmicpc.net/problem/16956
 */
public class Boj16956 {
    private static int dx[] = {0,1,0,-1};
    private static int dy[] = {1,0,-1,0};
    private static int x;
    private static int y;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        x = sc.nextInt();
        y = sc.nextInt();
        sc.nextLine();

        char[][] map = new char[x][y];

        for (int i = 0; i < x; i++) {
            String next = sc.nextLine();
            for (int j = 0; j < y; j++) {
                char nextChar = next.charAt(j);
                map[i][j] = nextChar;
            }
        }

        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                if (map[i][j] == 'S') {
                    for (int k = 0; k < 4; k++) {
                        int a = i + dx[k];
                        int b = j + dy[k];
                        if (a < 0 || b < 0 || a >= x || b >= y) continue;
                        if (map[a][b] == 'S') continue;
                        if (map[a][b] == 'W') {
                            System.out.println(0);
                            return;
                        }
                        map[a][b] = 'D';
                    }
                }
            }
        }
        System.out.println(1);
        printMap(map);
    }

    private static void printMap(char[][] map) {
        for (char[] chars : map) {
            for (char c : chars) {
                System.out.print(c);
            }
            System.out.println();
        }
    }
}
