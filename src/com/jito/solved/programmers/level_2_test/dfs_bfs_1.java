package com.jito.solved.programmers.level_2_test;

/*
깊이/너비 우선 탐색(DFS/BFS) - 타겟 넘버

https://programmers.co.kr/learn/courses/30/lessons/43165?language=java
 */
public class dfs_bfs_1 {
    public static void main(String[] args) {
        System.out.println(solution(new int[]{1, 1, 1, 1, 1}, 3)); // 5
    }

    static int answer = 0;
    public static int solution(int[] numbers, int target) {

        dfs(numbers, 0, 0, target);

        return answer;
    }
    public static void dfs(int[] s, int i, int sum, int t) {
        if(s.length == i) {
            if(t == sum) answer++;
        } else if(s.length > i) {
            dfs(s, i+1, sum+s[i], t);
            dfs(s, i+1, sum-s[i], t);
        }
    }
}
