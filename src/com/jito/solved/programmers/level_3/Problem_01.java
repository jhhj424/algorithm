package com.jito.solved.programmers.level_3;

/*
    프로그래머스 - 월간 코드 챌린지 시즌1 - 풍선 터트리기 : https://programmers.co.kr/learn/courses/30/lessons/68646?language=java
 */
public class Problem_01 {
    public static void main(String[] args) {
        System.out.println(solution(new int[]{-16,27,65,-2,58,-92,-71,-68,-61,-33}));
    }
    public static int solution(int[] a) {
        int answer = 0;

        int l = 1000000000, r = 1000000000;

        for (int i = 0; i < a.length; i++) {
            if (a[i] < l) {
                answer++;
                l = a[i];
            }

            if (a[a.length - 1 - i] < r) {
                answer++;
                r = a[a.length - 1 - i];
            }

            if (l == r)
                break;
        }

        return answer + (l == r ? -1 : 0);
    }
}
