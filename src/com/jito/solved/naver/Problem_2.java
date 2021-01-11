package com.jito.solved.naver;

import java.util.ArrayList;
import java.util.Arrays;

public class Problem_2 {
    public static void main(String[] args) {
    }
}
class Solution2 {
    static int INF = (int)1e9;
    static int[][] input;
    static ArrayList<Integer> list = new ArrayList<>();
    public ArrayList<Integer> solution(int[][] blocks) {
        input = new int[blocks.length][blocks.length];
        for(int i=0; i<input.length; i++) {
            Arrays.fill(input[i], INF);
            input[i][blocks[i][0]] = blocks[i][1];
        }

        insert(1);
        for(int i=1; i<input.length; i++) {
            insert(i);
            input[i][0] = input[i-1][0] - input[i][1];
        }

        makeList(input);

        return list;
    }

    void insert(int start) {
        for(int i=start; i<input.length; i++) {
            for(int j=1; j<=i; j++) {
                // 이미 숫자가 있으면 continue;
                if(input[i][j] != INF)
                    continue;

                int leftup = input[i-1][j-1];
                int rightup = input[i-1][j];
                int left = INF;
                int right = INF;
                if(j > 0)
                    left = input[i][j-1];
                if(j < i)
                    right = input[i][j+1];

                if(left != INF) {
                    input[i][j] = leftup - left;
                } else if(right != INF) {
                    input[i][j] = rightup - right;
                } else {
                    input[i][j] = INF;
                }
            }
        }
    }

    void makeList(int[][] arr) {

        for(int i=0; i<arr.length; i++) {
            for(int j=0; j<=i; j++) {
                list.add(arr[i][j]);
            }
        }
    }
}