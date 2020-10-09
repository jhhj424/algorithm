package com.jito.solved.baekjoon;

import java.io.*;

/*
    백준 1913번 문제 : 달팽이 : https://www.acmicpc.net/problem/1913
 */
public class boj1913 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        br.close();

        int x, y, a, b;
        x = y = a = b= 0;
        int num = n*n;
        int t = n;
        int[][] arr = new int[n+1][n+1];
        for(int i=0; i<n*n; i++) {
            for(int j = 0; j<t; j++) {
                if(i % 4 ==0) { // 아래
                    x++;
                }else if(i % 4 == 1) {  // 오른쪽
                    y++;
                }else if(i % 4 == 2) {  // 위
                    x--;
                }else {  // 왼쪽
                    y--;
                }
                // 찾는 수라면 좌표를 저장함
                if(num == m) {
                    a = x;
                    b = y+1;
                }
                arr[x][y] = num--;
            }
            if(i % 2 == 0) {
                t--;
            }
        }
        StringBuilder s = new StringBuilder(2 * n * n + 2 * n);
        for(int i=1; i<arr.length; i++) {
            for(int j=0; j<arr.length-1; j++) {
                s.append(arr[i][j]).append(' ');
            }
            s.append('\n');
        }
        System.out.print(s);
        System.out.println(a + " " + b);
    }
}
