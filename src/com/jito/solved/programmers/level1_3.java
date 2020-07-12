package com.jito.solved.programmers;

public class level1_3 {
    public static void main(String[] args) {
        System.out.println(두정수사이의합1(3,5));
        System.out.println(두정수사이의합2(5,3));
    }
    public static long 두정수사이의합1(int a, int b) {
        long answer = 0;
        int big, small;
        if(a>b) {
            big = a;
            small = b;
        } else {
            big = b;
            small = a;
        }
        for(int i=small; i<= big; i++) {
            answer += i;
        }
        return answer;
    }
    public static long 두정수사이의합2(int a, int b) {
        return sumAtoB(Math.min(a, b), Math.max(b, a));
    }

    private static long sumAtoB(long a, long b) {
        return (b - a + 1) * (a + b) / 2;
    }

}
