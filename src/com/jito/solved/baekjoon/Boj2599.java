package com.jito.solved.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 백준 - 짝정하기 : https://www.acmicpc.net/problem/2599
 */
public class Boj2599 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int box[][] = new int[3][2];
        boolean check = true;

        for(int i = 0; i < 3; i++) {
            String temp[] = br.readLine().split(" ");
            box[i][0] = Integer.parseInt(temp[0]);
            box[i][1] = Integer.parseInt(temp[1]);
        }

        for(int i = 0; i <= box[0][0]; i++) {
            int result[][] = new int[3][2];
            result[0][0] = i;
            result[0][1] = box[0][0] - i;
            result[1][1] = box[2][1] - result[0][1];
            result[1][0] = box[1][0] - result[1][1];
            result[2][0] = box[0][1] - result[1][0];
            result[2][1] = box[2][0] - result[2][0];

            if(result[0][0] >= 0 && result[0][1] >= 0 && result[1][0] >= 0 && result[1][1] >= 0 && result[2][0] >= 0 && result[2][1] >= 0) {
                System.out.println(1);
                System.out.println(result[0][0]+" "+result[0][1]);
                System.out.println(result[1][0]+" "+result[1][1]);
                System.out.println(result[2][0]+" "+result[2][1]);
                check = false;
                break;
            }

        }

        if(check) {
            System.out.println(0);
        }
    }
}
