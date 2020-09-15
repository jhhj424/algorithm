package com.jito.solved.programmers.level_1_test;

import java.util.Arrays;
import java.util.Stack;

/*
그리디 알고리즘 - 같은 숫자는 싫어 - 프로그래머스

https://programmers.co.kr/learn/courses/30/lessons/12906?language=java
 */
public class Problem_4 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(new int[]{1, 1, 3, 3, 0, 1, 1})));
    }
    public static Integer[] solution(int[] arr) {
        Stack<Integer> stack = new Stack<>();
        stack.push(arr[0]);
        for (int i : arr) if(stack.peek() != i) stack.push(i);
        return stack.toArray(new Integer[]{});
    }
}
