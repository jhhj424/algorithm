package com.jito.solved.programmers.level_1_test;

public class Problem_1 {
    public static void main(String[] args) {
        int[] answer = new int[2];
        answer = solution1(3,12);
        for(int i: answer) {
            System.out.println(i);
        }
    }
    public static int[] solution1(int n, int m) {
        int[] answer = new int[2];
        if(n>m) {
            answer[0] = gcd(n,m);
        } else {
            answer[0] = gcd(m,n);
        }
        answer[1] = n*m/answer[0];

        return answer;
    }
    public static int gcd(int big, int small) {
        if(small == 0) {
            return big;
        }
        return gcd(small, big%small);
    }
}
