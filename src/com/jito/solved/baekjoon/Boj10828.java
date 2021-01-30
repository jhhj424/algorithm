package com.jito.solved.baekjoon;

import java.util.Scanner;
import java.util.Stack;

/**
 * 백준 - 스택 : https://www.acmicpc.net/problem/10828
 */
public class Boj10828 {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
        Stack<Integer> stack = new Stack<>();
        Scanner sc = new Scanner(System.in);
        int cnt = sc.nextInt();

        for(int i=0; i<cnt; i++) {
            String input = sc.next();
            switch (input) {
                case "push":
                    int input2 = sc.nextInt();
                    stack.push(input2);
                    break;
                case "pop":
                    sb.append(stack.isEmpty() ? -1 : stack.pop()).append('\n');
                    break;
                case "size":
                    sb.append(stack.size()).append('\n');
                    break;
                case "empty":
                    sb.append(stack.isEmpty() ? 1 : 0).append('\n');
                    break;
                case "top":
                    sb.append(stack.isEmpty() ? -1 : stack.peek()).append('\n');
                    break;
            }
        }
        System.out.println(sb.toString());
    }
}
