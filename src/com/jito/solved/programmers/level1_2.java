package com.jito.solved.programmers;

import java.util.Arrays;

public class level1_2 {
    public static void main(String[] args) {
        int[] array = {1, 5, 2, 6, 3, 7, 4};
        int[][] commands = {{2, 5, 3}, {4, 4, 1}, {1, 7, 3}};
        int[] result = K번째수(array, commands);

        for(int i: result)
            System.out.println(i);
    }
    public static int[] K번째수(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        for(int i=0; i<commands.length; i++) {
            int[] a = Arrays.copyOfRange(array, commands[i][0]-1, commands[i][1]);
            Arrays.sort(a);
            answer[i] = a[commands[i][2]-1];
        }
        return answer;
    }
}