package com.jito.solved.algorithm;

/*
구간 합 알고리즘 ( Prefix Sum )
 */
public class SumOfIntervals {
    public static void main(String[] args) {

        // 데이터의 개수 n과 데이터
        int n = 5;
        int[] data = {10, 20, 30, 40, 50};

        // Prefix Sum 배열 계산
        int sum = 0;
        int[] prefix_sum = new int[n+1];
        for(int i=1; i<=n; i++) {
            sum += data[i-1];
            prefix_sum[i] = sum;
        }

        // 구간
        int left = 3;
        int right = 4;

        // 구간합
        int result = prefix_sum[right] - prefix_sum[left-1];

        System.out.println(result);
    }
}
