package com.jito.solved.baekjoon;

        import java.util.Scanner;

/*
* N 찍기
*
문제
자연수 N이 주어졌을 때, 1부터 N까지 한 줄에 하나씩 출력하는 프로그램을 작성하시오.

입력
첫째 줄에 100,000보다 작거나 같은 자연수 N이 주어진다.

출력
첫째 줄부터 N번째 줄 까지 차례대로 출력한다.
*/
public class boj2741 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int limit = scan.nextInt();
        for(int i=0; i<limit; i++) {
            System.out.println(i+1);
        }
    }
}
