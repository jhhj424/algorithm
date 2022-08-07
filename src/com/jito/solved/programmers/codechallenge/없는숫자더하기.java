package com.jito.solved.programmers.codechallenge;

import java.util.ArrayList;

public class 없는숫자더하기 {
    public static void main(String[] args) {
        System.out.println(solution(new int[]{1, 2, 3, 4, 6, 7, 8, 0}));
    }

    public static int solution(int[] numbers) {
        ArrayList<Integer> nums = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            nums.add(i);
        }

        for (int number : numbers) {
            if (nums.contains(number)) {
                nums.remove(nums.indexOf(number));
            }
        }

        return nums.stream().mapToInt(i -> i).sum();
    }
}
