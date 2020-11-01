package com.jito.solved.baekjoon;

import java.util.Scanner;

/*
    백준 : 수들의 합 2 : 슬라이딩 윈도우 : https://www.acmicpc.net/problem/2003
 */
public class boj2003 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int target = sc.nextInt();
        int[] arr = new int[n];
        for(int i=0; i<n; i++) {
            arr[i] = sc.nextInt();
        }// 예제 입력 끝

        int result = 0; // 결과값 저장 변수

        // m : 슬라이딩 윈도우 - 몇개씩 탐색할 것인지..
        for(int m=0; m<n; m++) {
            int left = 0, right = m; // left부터 right까지: 윈도우의 범위 index
            int sum = 0; // 윈도우 범위의 부분합

            // 초기 sum값 세팅 -> 윈도우 범위만큼의 값을 최초에 가짐
            for(int i=0; i<=right; i++) {
                sum += arr[i];
            }
            if(sum == target) result++;
            right++;

            // right 인덱스의 범위가 n을 벗어나기 전까지 반복
            while(right < n) {
                // [윈도우] 의 다음 범위는 [윈도우] - arr[left] + arr[right] 임.
                sum -= arr[left++];
                sum += arr[right++];
                // target 값과 비교하여 같다면 result 값 1 증가
                if(sum == target) result++;
            }
        }
        System.out.println(result);
    }
}