package com.jito.solved.programmers.kakao2022;

import java.util.Arrays;

public class 양궁대회 {
    public static void main(String[] args) {
        // expect [0,2,2,0,1,0,0,0,0,0,0]
        for (int i : solution(5, new int[]{2, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0})) {
            System.out.println("i = " + i);
        }
    }

    public static int[] solution(int n, int[] info) {
        int[] answer = new int[11];
        int max = 0;

        for (int i = 0; i < 1 << 10; i++) {
            int[] temp = new int[11];
            int ryan = 0, peach = 0, totalShoot = 0;
            // 1,0,0,0,0,0,0,0,0
            for (int j = 0; j < 10; j++) {
                // 자릿수마다 1로 켜져있는지 확인
                if ((i & 1 << j) != 0) { // 라이언 win
                    ryan += 10 - j;
                    temp[j] = info[j] + 1;
                    totalShoot += temp[j];
                } else {
                    if (info[j] > 0) { // 어피치 win
                        peach += 10 - j;
                    }
                }
            }

            if (totalShoot > n) continue;

            // 0점 표적 쏘는 경우 처리
            temp[10] = n - totalShoot;

            if (max == (ryan - peach)) {
                for (int j = 10; j >= 0; j--) {
                    if (temp[j] > answer[j]) {
                        answer = Arrays.copyOf(temp, temp.length);
                    }
                }
            } else if (max < (ryan - peach)) {
                max = ryan - peach;
                answer = Arrays.copyOf(temp, temp.length);
            }
        }

        if (max == 0) return new int[]{-1};
        return answer;
    }
}
