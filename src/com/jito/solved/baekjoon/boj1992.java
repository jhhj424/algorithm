package com.jito.solved.baekjoon;

import java.util.Arrays;
import java.util.Scanner;

/*
    [백준] 분할정복 - 쿼드트리 : https://www.acmicpc.net/problem/1992
 */
public class boj1992 {
    static int[][] input;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int size = Integer.parseInt(sc.nextLine());
        input = new int[size][size];
        for(int i=0; i<size; i++) {
            String line = sc.nextLine();
            for(int j=0; j<line.length(); j++) {
                input[i][j] = line.charAt(j) - '0';
            }
        }

        System.out.println(Arrays.deepToString(input));
        quadTree(0,0,size);

        System.out.println(sb.toString());
    }

    static void quadTree(int a, int b, int size){
        int i,j, flag = 0;
        int first = input[a][b];

        for(i=0; i<size; i++) {
            for(j=0; j<size; j++) {
                if(first != input[a+i][b+j]) {
                    flag = 1;
                    break;
                }
            }
            if(j != size) {
                flag=1;
                break;
            }
        }
        if(flag == 0) {
            sb.append(first);
        }
        else {
            sb.append("(");
            size /= 2;
            quadTree(a, b, size);
            quadTree(a, b+size, size);
            quadTree(a+size, b, size);
            quadTree(a+size, b+size, size);
            sb.append(")");
        }
    }
}
