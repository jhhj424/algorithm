package com.jito.solved.baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

/**
 *  백준 - 감시 : https://www.acmicpc.net/problem/15683
 */
public class Boj15683 {
    private static int n, m, min = 0;
    private static final List<int[]> list = new ArrayList<>();
    private static final int[] dx = {-1, 0, 1, 0}, dy = {0, 1, 0, -1};
    private static final int[][] stat = {{1, 0, 0, 0}, {0, 1, 0, 0}, {0, 0, 1, 0}, {0, 0, 0, 1}, {1, 0, 1, 0}, {0, 1, 0, 1}, {1, 1, 0, 0}, {0, 1, 1, 0}, {0, 0, 1, 1}, {1, 0, 0, 1}, {1, 1, 1, 0}, {0, 1, 1, 1}, {1, 0, 1, 1}, {1, 1, 0, 1}, {1, 1, 1, 1}};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        int[][] map = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 0) min++;
                if (0 < map[i][j] && map[i][j] < 6) list.add(new int[]{i, j});
            }
        }
        bfs(map, min);
        System.out.println(min);
    }

    private static void bfs(int[][] map, int n) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(n, map));
        for (int[] ints : list) {
            int len = queue.size();
            for (int t = 0; t < len; t++) {
                Node m = queue.poll();
                assert m != null;
                int num = m.num;
                int x = ints[0];
                int y = ints[1];
                if (map[x][y] == 1) {
                    queue.add(cctv(m.map, x, y, num, stat[0]));
                    queue.add(cctv(m.map, x, y, num, stat[1]));
                    queue.add(cctv(m.map, x, y, num, stat[2]));
                    queue.add(cctv(m.map, x, y, num, stat[3]));
                }
                if (map[x][y] == 2) {
                    queue.add(cctv(m.map, x, y, num, stat[4]));
                    queue.add(cctv(m.map, x, y, num, stat[5]));
                }
                if (map[x][y] == 3) {
                    queue.add(cctv(m.map, x, y, num, stat[6]));
                    queue.add(cctv(m.map, x, y, num, stat[7]));
                    queue.add(cctv(m.map, x, y, num, stat[8]));
                    queue.add(cctv(m.map, x, y, num, stat[9]));
                }
                if (map[x][y] == 4) {
                    queue.add(cctv(m.map, x, y, num, stat[10]));
                    queue.add(cctv(m.map, x, y, num, stat[11]));
                    queue.add(cctv(m.map, x, y, num, stat[12]));
                    queue.add(cctv(m.map, x, y, num, stat[13]));
                }
                if (map[x][y] == 5) {
                    queue.add(cctv(m.map, x, y, num, stat[14]));
                }
            }
        }
    }

    private static Node cctv(int[][] map, int x, int y, int num, int[] status) {
        int[][] result = copy(map);
        for (int i = 0; i < 4; i++) {
            if (status[i] == 0) continue;
            int nx = x, ny = y;
            while (true) {
                nx = nx + dx[i];
                ny = ny + dy[i];
                if (!isValid(nx, ny)) break;
                if (result[nx][ny] == 6) break;
                if (result[nx][ny] == 0) {
                    result[nx][ny] = 8;
                    num--;
                }
            }
        }
        if (min > num) min = num;
        return new Node(num, result);
    }

    private static int[][] copy(int[][] map) {
        int[][] result = new int[n][m];
        for (int i = 0; i < n; i++) {
            System.arraycopy(map[i], 0, result[i], 0, m);
        }
        return result;
    }

    private static boolean isValid(int x, int y) {
        if (x < 0 || y < 0 || x >= n || y >= m) return false;
        return true;
    }
}

class Node {
    int num;
    int[][] map;

    Node(int num, int[][] map) {
        this.num = num;
        this.map = map;
    }
}
