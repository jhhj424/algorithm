package com.jito.solved.programmers.level_2_test;

/*
    프로그래머스 - 연습문제 - N개의 최소공배수 : https://programmers.co.kr/learn/courses/30/lessons/12953?language=java
 */
public class Problem_18 {
    public static void main(String[] args) {
        System.out.println(solution(new int[]{2,6,8,14})); // 168
    }

    public static int solution(int[] arr) {
        if(arr.length==1)return arr[0];
        else if (arr.length==2)return arr[0]*arr[1] / gcd(arr[1], arr[0]);

        int lcm = arr[0]*arr[1] / gcd(arr[1], arr[0]);
        for(int i=2; i<arr.length; i++) {
            int a = lcm;
            int b = arr[i];
            lcm = a*b / gcd(Math.max(a,b), Math.min(a,b));
        }
        return lcm;
    }
    // 최대 공약수
    static int gcd(int big, int small) {
        if(small == 0)
            return big;
        return gcd(small, big % small);
    }
}
