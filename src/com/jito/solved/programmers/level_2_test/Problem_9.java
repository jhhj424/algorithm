package com.jito.solved.programmers.level_2_test;

import java.util.Arrays;

/*
    프로그래머스 - 탐욕법(Greedy) - 구명보트 : https://programmers.co.kr/learn/courses/30/lessons/42885?language=java
 */
public class Problem_9 {
    public static void main(String[] args) {
        int[] people = {70, 80, 50};
        int limit = 100;
        System.out.println(solution(people, limit));
    }
    public static int solution(int[] people, int limit) {
        int answer = 0;
        Arrays.sort(people);
        for(int i=0, j=people.length-1; i<j; j--) {
            int boat = 0;
            boat += people[i];
            boat += people[j];
            System.out.println(people[i] + " + " + people[j]);
            System.out.println(boat);
            if(boat > limit) {
                answer++;
                j--;
            } else {
                answer++;
                i++;
                j--;
            }
            if(i == j) {
                answer++;
            }
        }
        return answer;
    }
}
