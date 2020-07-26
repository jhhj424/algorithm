package com.jito.solved.programmers;

import java.util.Arrays;

/**
 * 문제 설명
 * 두 수를 입력받아 두 수의 최대공약수와 최소공배수를 반환하는 함수, solution을 완성해 보세요. 배열의 맨 앞에 최대공약수, 그다음 최소공배수를 넣어 반환하면 됩니다. 예를 들어 두 수 3, 12의 최대공약수는 3, 최소공배수는 12이므로 solution(3, 12)는 [3, 12]를 반환해야 합니다.
 *
 * 제한 사항
 * 두 수는 1이상 1000000이하의 자연수입니다.
 */
public class GCD_LCM_2 {
    public int[] gcdlcm(int a, int b) {
        int[] answer = new int[2];
        int big,small;
        if(a>b){
            big = a;
            small = b;
        }else {
            big = b;
            small = a;
        }
        int gcd = gcd(big, small);
        answer[0] = gcd;
        answer[1] = a*b / gcd;
        return answer;
    }

    /**
     최대공약수 - 유클리드 호재법
     A와 B 사이의 최대공약수는
     => if(A>B)이고 A를 B로 나눈 나머지 = r 이라고 한다면
     => B와 r의 최대공약수랑 같다.
     */
    public static int gcd(int big, int small) {
        int r = big%small;
        if(r == 0) {
            return small;
        }
        return gcd(small, r);
    }

    // 아래는 테스트로 출력해 보기 위한 코드입니다.
    public static void main(String[] args) {
        GCD_LCM_2 c = new GCD_LCM_2();
        System.out.println(Arrays.toString(c.gcdlcm(3, 12)));
    }
}
