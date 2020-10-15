package com.jito.solved.programmers.level_2_test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
    프로그래머스 - Summer/Winter Coding(~2018) - 영어 끝말잇기 : https://programmers.co.kr/learn/courses/30/lessons/12981?language=java
 */
public class Problem_24 {
    public static void main(String[] args) {
        String[] arr = {"tank", "kick", "know", "wheel", "land", "dream", "mother", "robot", "tank"};
        System.out.println(Arrays.toString(solution(3, arr))); // 3,3
    }
    public static int[] solution(int n, String[] words) {
        int[] answer = new int[2];
        List<String> list = new ArrayList<String>();
        boolean flag = true;

        for(int i=0; i<words.length; i++){
            if(list.contains(words[i])){   // 이전에 등장한 단어인경우
                answer[0] = (i%n) + 1;
                answer[1] = (i/n) + 1;
                flag = false;
                break;
            }

            list.add(words[i]); // 현재 단어 리스트에 넣기

            // 이전 끝단어와 현재 첫단어가 다른경우 - 끝말잇기가 아닌경우
            if(i>0 && words[i-1].charAt(words[i-1].length()-1) != words[i].charAt(0)){
                answer[0] = (i%n) + 1;
                answer[1] = (i/n) + 1;
                flag = false;
                break;
            }
        }
        if(flag) return new int[]{0, 0};
        return answer;
    }
}