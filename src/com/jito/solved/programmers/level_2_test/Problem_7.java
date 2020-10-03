package com.jito.solved.programmers.level_2_test;

/*
탐욕법(Greedy) - 조이스틱 : https://programmers.co.kr/learn/courses/30/lessons/42860?language=java - [보류]
 */
public class Problem_7 {
    public static void main(String[] args) {
        System.out.println(solution("JEROEN")); // 56
//        System.out.println(solution("JAN")); // 56
//        System.out.println(solution("ABABAAAAABA")); // 56
    }
    public static int solution(String name) {
        int answer = -1;
        // 알파벳 범위 : 65(A) ~ 90(Z)
        String[] arr = name.split("");
        for(int i=0; i<arr.length; i++) {
            if(arr[i].charAt(0) == 'A') {
                if(i >= arr.length) {
                    continue;
                } else {
                    int a = find(arr, i);
                    if(i > a) {
                        answer += i + arr.length-3-a;
                        i = arr.length-2-a;
                    }else {
                        answer++;
                        continue;
                    }
                }
            }
            int move_cnt = Math.min(arr[i].charAt(0)-65, 91-arr[i].charAt(0));
            answer += move_cnt + 1;
        }
        return answer;
    }
    static int find(String[] arr, int i) {
        int ret = 0;
        for(; i<arr.length; i++) {
            ret++;
            if(arr[i].charAt(0) != 'A')
                break;
        }
        return ret;
    }
}
