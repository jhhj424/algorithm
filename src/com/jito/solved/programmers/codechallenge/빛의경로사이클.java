package com.jito.solved.programmers.codechallenge;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class 빛의경로사이클 {
    public static void main(String[] args) {
        System.out.println(solution(new String[]{"SL", "LR"})); // return {16}
    }

    static int D[][] = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}}; // U,R,D,L
    static boolean visited[][][]; // 3번째 배열 값은 U,R,D,L 에 해당
    static List<Integer> answer = new ArrayList<>();

    public static List<Integer> solution(String[] grid) {
        // 입력값에 해당하는 맵 그리기
        String[][] map = new String[grid.length][grid[0].split("").length];
        for (int i = 0; i < grid.length; i++) {
            String[] gridX = grid[i].split(""); // {S,L}
            for (int j = 0; j < gridX.length; j++) {
                map[i][j] = gridX[j];
            }
        }

        visited = new boolean[map.length][map[0].length][4];

        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                for (int k = 0; k < 4; k++) {
                    if (!visited[i][j][k]) {
                        // map, 현재좌표, 이동하는방향, 목적좌표, 거리
                        int result = startMap(map, new int[]{i, j}, k, 0);
                        if (result > 0) {
                            answer.add(result);
                        }
                    }
                }
            }
        }

        Collections.sort(answer);
        return answer;
    }

    private static int startMap(String[][] map, int[] curr, int d, int dist) {
        while (true) {
            if (visited[curr[0]][curr[1]][d]) return dist; // 방문한 경우 return
            visited[curr[0]][curr[1]][d] = true; // 방문 처리

            // 회전 처리
            String currStr = map[curr[0]][curr[1]];
            if (currStr.equals("R")) {
                d = (d + 1) % 4;
            } else if (currStr.equals("L")) {
                d = (d + 3) % 4;
            }

            int r = curr[0];
            int c = curr[1];
            r = (r + D[d][0] + map.length) % map.length;
            c = (c + D[d][1] + map[0].length) % map[0].length;
            curr = new int[]{r, c};
            dist++;
        }
    }

    private static void print(String[][] map) {
        for (String[] strings : map) {
            for (String string : strings) {
                System.out.print(string);
            }
            System.out.println();
        }
    }
}
