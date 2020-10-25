package com.jito.barkingdog.stack;

/*

    배열로 스택 구현하기 - 스택의 개념 학습

 */
public class Stack {
    static int pos = 0;
    static int[] stack = new int[1000];

    static void push(int n) {
        stack[pos++] = n;
    }

    static void pop() {
        pos--;
    }

    static void top() {
        System.out.println("top : " + stack[pos-1]);
    }

    static void test() {
        push(1);
        push(2);
        push(3);
        push(4);
        push(5);
        pop();
        top();
        pop();
        top();
    }

    public static void main(String[] args) {
        test();
    }
}
