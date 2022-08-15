package com.jito.solved.programmers.kakao2022;

public class 비트부분집합 {
    public static void main(String[] args) {
        System.out.println(bitSolve(new int[]{1, 2, 3, 4, 5, 6}, 2, 6));
    }

    private static int bitSolve(int[] nums, int k, int t) {
        int count = 0;
        for (int i = 0; i < 1 << nums.length; i++) {
            if (Integer.bitCount(i) != k) continue;

            int sum = 0;
            for (int j = 0; j < nums.length; j++) {
                if ((i & 1 << j) != 0) {
                    sum += nums[j];
                }
            }
            if (sum == t) count++;
        }
        return count;
    }
}
