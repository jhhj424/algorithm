package com.jito.solved.programmers.level_3;

import java.util.LinkedList;
import java.util.Queue;

/*
    프로그래머스 - DFS - 단어 변환 : https://programmers.co.kr/learn/courses/30/lessons/43163?language=java
 */
public class Problem_02 {
    public static void main(String[] args) {
        String hit = "hit";
        String cog = "cog";
        String[] arr = {"hot","dot","dog","lot","log","cog"};
        System.out.println(solution(hit, cog, arr));
    }
    public static int solution(String begin, String target, String[] words) {
        int n = words.length, answer = 0;

        Queue<Node> q = new LinkedList<>();

        boolean[] visited = new boolean[n];
        q.offer(new Node(begin,0));

        while(!q.isEmpty()) {
            Node now = q.poll();
            if(now.word.equals(target)) {
                answer = now.dist;
                break;
            }

            for(int i=0; i<n; i++) {
                if(visited[i] || !isAble(now.word, words[i])) continue;
                visited[i] = true;
                q.offer(new Node(words[i], now.dist +1));
            }
        }

        return answer;
    }
    static boolean isAble(String now, String next) {
        int cnt = 0;
        for(int i=0; i<now.length(); i++) {
            if(now.charAt(i) == next.charAt(i))
                cnt++;
        }
        return cnt == now.length() - 1;
    }
}
class Node {
    String word;
    int dist;

    public Node(String word, int dist) {
        this.word = word;
        this.dist = dist;
    }
}