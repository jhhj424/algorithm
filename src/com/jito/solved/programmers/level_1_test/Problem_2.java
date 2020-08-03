package com.jito.solved.programmers.level_1_test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem_2 {
    public static void main(String[] args) {
        int[] array = {1, 5, 2, 6, 3, 7, 4};
        int[][] commands = {{2, 5, 3}, {4, 4, 1}, {1, 7, 3}};
        int[] result = solution2(array, commands);
        for (int i : result) {
            System.out.println(i);
        }
    }

    public static int[] solution2(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        for (int i = 0; i < commands.length; i++) {
            List list = new ArrayList<Integer>();
            for (int k = commands[i][0]; k <= commands[i][1]; k++) {
                list.add(array[k - 1]);
            }
            Collections.sort(list);
            answer[i] = (int) list.get(commands[i][2] - 1);
        }
        return answer;
    }
}
