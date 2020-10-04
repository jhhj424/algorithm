package com.jito.solved.programmers.level_2_test;

import java.util.Stack;

/*
    프로그래머스 - 연습문제 - 올바른 괄호 : https://programmers.co.kr/learn/courses/30/lessons/12909?language=java
 */
public class Problem_13 {
    public static void main(String[] args){
        System.out.println(solution("()()")); // true
        System.out.println(solution2(")()(")); // false
    }

    static boolean solution(String s) {
        Stack<Character> stack = new Stack<>();
        for(int i=0; i<s.length(); i++) {
            if(stack.isEmpty()){
                if(s.charAt(i) == ')')
                    return false;
                else
                    stack.push(s.charAt(i));
            }
            else {
                if(s.charAt(i) == ')')
                    stack.pop();
                else
                    stack.push(s.charAt(i));
            }
        }
        return stack.isEmpty();
    }

    static boolean solution2(String s) {
        Stack<Character> stack = new Stack<>();
        for(int i=0; i<s.length(); i++) {
            if(stack.isEmpty()){
                if(s.charAt(i) == ')')
                    return false;
            }
            else {
                if(s.charAt(i) == ')')
                    stack.pop();
            }
            if(s.charAt(i) == '(')
                stack.push(s.charAt(i));
        }
        return stack.isEmpty();
    }
}
