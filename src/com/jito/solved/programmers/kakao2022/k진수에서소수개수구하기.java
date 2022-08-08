package com.jito.solved.programmers.kakao2022;

/*
*
n	k	result
437674	3	3
110011	10	2
* */
public class k진수에서소수개수구하기 {
    public static void main(String[] args) {
        System.out.println("solution(437674, 3) = " + solution(437674, 3));
    }

    public static int solution(int n, int k) {
        int answer = 0;

        // 진법 변환
        String num = convert(n, k);
        String[] nums = num.split("0+");

        // 소수 찾기
        for (String s : nums) {
            if (isPrime(Long.parseLong(s))) {
                answer++;
            }
        }


        // 소수 개수 반환
        return answer;
    }

    private static String convert(int n, int k) {
        int num = n / k, r = n % k;
        if (num != 0)
            return convert(num, k) + r;
        else
            return String.valueOf(r);
    }

    private static boolean isPrime(long num) {
        if (num == 2) return true;
        if (num == 1 || num % 2 == 0) return false;
        for (long i = 3; i * i <= num; i += 2) {
            if (num % i == 0) return false;
        }
        return true;
    }
}
