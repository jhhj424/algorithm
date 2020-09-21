package com.jito.solved.programmers.level_1_test;

/*
프로그래머스 - 소수찾기 - 에라토스테네스의 체

https://programmers.co.kr/learn/courses/30/lessons/12919?language=java
 */
public class Problem_13 {
    public static void main(String[] args) {
        System.out.println(solution(10));
    }
    public static int solution(int n) {
        boolean[] arr = new boolean[n+1];
        arr[0] = arr[1] = true;
        for(int i=2; i*i<=n; i++) {
            if(!arr[i])
                for(int j=i*i; j<=n; j+=i) arr[j] = true;
        }
        int cnt = 0;
        for(boolean b: arr) if(!b) cnt++;
        return cnt;
    }
}
