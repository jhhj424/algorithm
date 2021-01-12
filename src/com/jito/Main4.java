package com.jito;
/*
어떤 숫자 n을 각 자리의 숫자로 나누었을 때, 나누어떨어지면 그 숫자로 분열 가능하다고 합니다.

예를 들어 2232이라는 숫자는 2와 3 두 개의 숫자로 구성되어 있습니다. 또한, 2232는 2로도 나누어떨어지고, 3으로도 나누어 떨어집니다. 따라서 분열 가능한 횟수는 2입니다.
2232의 예에서와같이 2가 여러 번 나오더라도 분열 가능한 횟수를 셀 때는 2 한 번, 3 한 번으로 세며 중복해서 나오는 숫자 2는 고려하지 않습니다.

숫자 n이 매개변수로 주어질 때, n이 분열 가능한 횟수를 return 하도록 solution 함수를 완성하세요.

[※ 숫자는 0으로 나눌 수 없음을 유의하세요.]

제한사항
n은 1015 이하의 자연수입니다.
 */
public class Main4 {

    public static void main(String[] args) {
        int n = 2322;
        System.out.println(solution(n)); // 2
    }
    public static int solution(long n) {
        int answer = 0;
        long copy = n;
        boolean[] arr = new boolean[10];
        while(n > 0) {
            int l = (int)(n % 10);
            n /= 10;
            if(l == 0) continue;
            else if(arr[l]) continue;
            else {
                arr[l] = true;
                if(copy % l == 0) answer++;
            }
        }
        return answer;
    }
}
