package com.jito.solved.programmers.level_1_test;

/*
연습문제 - 하샤드 수

https://programmers.co.kr/learn/courses/30/lessons/12947?language=java
 */
public class Problem_26 {
    public static void main(String[] args) {
        System.out.println(solution(10)); // true
        System.out.println(solution(11)); // false
    }
    public static boolean solution(int x) {
        String[] s = String.valueOf(x).split("");
        int sum = 0;
        for(String i: s) sum+= Integer.parseInt(i);
        return x % sum == 0;
    }
}
