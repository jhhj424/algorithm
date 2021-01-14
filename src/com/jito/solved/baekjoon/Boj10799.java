package com.jito.solved.baekjoon;

import java.util.Scanner;
import java.util.Stack;

/**
 * 백준 - 쇠막대기 : https://www.acmicpc.net/problem/10799
 */
public class Boj10799 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        char[] arr = scan.nextLine().replaceAll(" ","").toCharArray();
        Stack<Integer> stack = new Stack<>();
        int cnt = 0;


        for(int i=0; i<arr.length; i++){
            if(arr[i] == ')'){
                if(i - stack.peek() ==1 ){
                    stack.pop();
                    cnt+= stack.size();
                }else{
                    stack.pop();
                    cnt+=1;
                }
                continue;
            }
            stack.push(i);
        }
        System.out.print(cnt);
    }
}
