package com.jito.solved.hackerrank;

import java.util.ArrayList;
import java.util.Stack;

public class Problem04 {
    static String[] arr = {"a", "e", "i", "o", "u"};
    public static void main(String[] args) {
        int n = 2;
        int cnt = 0;

        Stack<String> stack = new Stack<>();
        stack.push(arr[0]);
        while (!stack.isEmpty()) {
            String now = stack.pop();
            if(now.length() == 2) {
                System.out.println(now);
                cnt++;
                continue;
            }
            // 마지막 문자
            String s = now.substring(now.length() - 1);
            // 마지막 문자의 인덱스
            int index = 0;
            for(int i=0; i<5; i++) {
                if(arr[i].equals(s)) {
                    index = i;
                    break;
                }
            }
            for(int i=0; i<5; i++) {
                if(index - 1 == i || index + 1 == i) {
                    String next = now + arr[i];
                    stack.push(next);
                }
            }
        }
    }
}
