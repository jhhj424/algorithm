package com.jito.solved.baekjoon;

import java.util.Scanner;

/**
 * Created by jhhj424@naver.com on 2020-11-07
 * Blog : https://jhhj424.tistory.com/
 * Github : http://github.com/jhhj424
 */
/*
백준 2018번 수들의 합 5 : https://www.acmicpc.net/problem/2018
 */
public class boj2018 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int left, right, sum, cnt;
        left = right = sum = cnt = 0;
        int[] arr = new int[n+1];
        for(int i=0; i<n+1; i++) {
            arr[i] = i;
        }
        while(true) {
            if(sum >= n) {
                left++;
                sum -= arr[left];
            }else if(right == n) {
                break;
            }else {
                right++;
                sum += arr[right];
            }
            if(sum == n) cnt++;
        }
        System.out.println(cnt);
    }
}
