package com.jito.solved.programmers.level_2_test;

/*
    프로그래머스 - 연습문제 - 다음 큰 숫자 (!비트개수세기) : https://programmers.co.kr/learn/courses/30/lessons/12911?language=java
 */
public class Problem_14 {
    public static void main(String[] args) {
        System.out.println(solution(78)); // 83
        System.out.println(solution(15)); // 23
    }

    // Integer.bitCount -> 인자로 전달된 int 값의 비트데이터(2진데이터)중 1 비트의 수를 카운트 해줌
    public static int solution(int n) {
        int bit_cnt = Integer.bitCount(n);
        for(int i=n+1; ; i++) {
            if(bit_cnt == Integer.bitCount(i))
                return i;
        }
    }
}
