package com.jito.solved.programmers.level_2_test;

import java.util.Arrays;

/*
    프로그래머스 - 2017 카카오코드 예선 - 카카오프렌즈 컬러링북 : https://programmers.co.kr/learn/courses/30/lessons/1829?language=java
 */
public class Problem_26 {
    public static void main(String[] args) {
        int m = 6;
        int n = 4;
        int[][] picture = {{1, 1, 1, 0}, {1, 2, 2, 0}, {1, 0, 0, 1}, {0, 0, 0, 1}, {0, 0, 0, 3}, {0, 0, 0, 3}};
        System.out.println(Arrays.toString(solution(m, n, picture))); // [4,5]
    }

    static int M = 0;
    static int N = 0;
    static int maxSizeOfOneArea = 0;
    static int numberOfArea = 0;
    static long[][] map;
    public static int[] solution(int m, int n, int[][] picture) {
        M = m;
        N = n;
        numberOfArea = 0;
        maxSizeOfOneArea = 0;
        int[] answer = new int[2];

        map = new long[M][N];
        for(int i=0; i<M; i++){
            for(int k=0; k<N; k++){
                map[i][k] = picture[i][k];
            }
        }

        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                if(map[i][j] == 0) continue;
                numberOfArea++;
                dfs(i,j,picture[i][j]);
                answer[1] = Math.max(answer[1], maxSizeOfOneArea);
                maxSizeOfOneArea = 0;
            }
        }
        answer[0] = numberOfArea;
        return answer;
    }
    static void dfs(int a, int b, int area) {
        if(a < 0 || b < 0 || a >= M || b >= N) return;
        if(map[a][b] == 0) return;
        if(area != map[a][b]) return;
        maxSizeOfOneArea++;
        map[a][b] = 0;
        int[] dx = {-1,1,0,0};
        int[] dy = {0,0,-1,1};
        for(int i=0; i<4; i++) {
            dfs(a+dx[i],b+dy[i],area);
        }
    }
}