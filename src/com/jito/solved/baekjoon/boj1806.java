package com.jito.solved.baekjoon;

import java.util.*;

/**
 * Created by jhhj424@naver.com on 2020-11-02
 * Blog : https://jhhj424.tistory.com/
 * Github : http://github.com/jhhj424
 * 백준 1806번 부분합 : https://www.acmicpc.net/problem/1806
 */
public class boj1806 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int len = sc.nextInt();
        long target = sc.nextInt();
        int[] arr = new int[len];
        for(int i=0; i<len; i++) {
            arr[i] = sc.nextInt();
        } // 입력 End

        int s, e, sum;
        s = e = sum = 0;
        int result = 100001;

        while(true) {
            if(sum >= target) {
                sum -= arr[s++];
                result = Math.min(result, (e - s) + 1);
            }
            else if(e == len) break;
            else {
                sum += arr[e++];
            }
        }
        if(result == 100001) {
            System.out.println(0);
        } else {
            System.out.println(result);
        }
        sc.close();
    }
}
