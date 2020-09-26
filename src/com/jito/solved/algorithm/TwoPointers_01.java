package com.jito.solved.algorithm;

import java.io.*;
import java.util.*;

/*
투 포인터

https://www.acmicpc.net/problem/2003
 */
public class TwoPointers_01 {
    static int N,M,result,sum;
    static int[] inputArr ;
    static int s,e;  //s:시작 포인터, e : end 포인터

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        inputArr = new int[N+1];
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            inputArr[i] = Integer.parseInt(st.nextToken());
        }

        s=0;e=0;

        while(e <= N) {

            if (sum < M) {
                sum += inputArr[e];
                e++;
            } else {
                sum -= inputArr[s];
                s++;
            }

            if (sum == M)
                result++;
        }

        System.out.println(result);
    }
}
