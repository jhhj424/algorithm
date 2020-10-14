package com.jito.solved.programmers.dev_matching;

import java.util.Arrays;

/*
문제 설명
n개의 전구가 1번부터 n번까지 번호가 붙여져서 일렬로 나열되어 있습니다. 꺼져 있는 n개의 전구를 최소한의 작업으로 모두 켜진 상태로 바꾸려고 합니다. 아래 그림은 n = 10 인 경우 입니다.

bulb.png

전구를 켜는 작업은 사전에 정해진 그룹 작업과 정해지지 않은 단일 작업으로 나눌 수 있습니다. 그룹 작업은 시작 번호와 끝 번호를 지정하여 그 범위 안의 전구를 모두 켜는 작업입니다. 위 그림에서는 빨간, 노란, 주황, 초록 선으로 표시된 4개의 그룹 작업이 있습니다. 단일 작업은 임의의 전구를 하나 켜는 작업입니다.

그룹 작업 1번 [1, 5] : 1번부터 5번 전구까지 켭니다.
그룹 작업 2번 [2, 7] : 2번부터 7번 전구까지 켭니다.
그룹 작업 3번 [4, 8] : 4번부터 8번 전구까지 켭니다.
그룹 작업 4번 [3, 6] : 3번부터 6번 전구까지 켭니다.

만약 그룹 작업 1번, 3번을 실행하고 단일 작업으로 9, 10번 전구를 각각 켜면 4번의 작업으로 모든 전구를 켤 수 있습니다. 한 번 켜진 전구는 꺼지지 않으므로, 작업들을 어떤 순서로 진행하든 최종 결과는 모두 같습니다.
전구의 개수를 나타내는 정수형 변수 n, 그룹 작업을 담은 2차원 배열 groups가 매개변수로 주어집니다. 이때, 전구를 모두 켜기 위한 최소한의 작업 횟수를 구해서 return 하도록 solution 함수를 완성해주세요.

제한사항
n은 1 이상 5,000 이하인 자연수입니다.
groups의 길이는 1,000 이하입니다.
groups의 원소는 [a, b] 형식입니다.
1번 그룹 작업의 정보부터 차례대로 저장되어 있습니다.
a, b는 그룹 작업으로 켜는 전구의 시작 번호와 끝 번호를 나타냅니다.
1 ≤ a < b ≤ n 이며, a와 b는 모두 자연수 입니다.
입출력 예
n	groups	result
10	[[1, 5],[2, 7],[4, 8],[3, 6]]	4
7	[[6, 7],[1, 4],[2, 4]]	3
100	[[1, 50],[1,100],[51, 100 ]]	1
입출력 예 설명
입출력 예 #1
문제 예시와 같습니다.

입출력 예 #2
그룹 작업 1번, 2번을 실행하고, 단일 작업으로 5번 전구를 켜면 총 3회의 작업으로 7개의 전구를 켤 수 있습니다.

입출력 예 #3
그룹 작업 2번을 실행하면, 총 1회의 작업으로 100개의 전구를 켤 수 있습니다.
 */

public class Problem3 {
    public static void main(String[] args) {
        int n = 10;
        int[][] g = {{1, 5},{2, 7},{4, 8},{3, 6}};
        int n2 = 7;
        int[][] g2 = {{6, 7},{1, 4},{2, 4}};
        System.out.println(solution(n,g)); // 4
//        System.out.println(solution(n2,g2)); // 3
    }
    static boolean[] fill;
    public static int solution(int n, int[][] groups) {
        int answer = 0;
        fill = new boolean[n+1];
        for(int i=0; i<groups.length; i++) {
            int start = groups[i][0];
            int end = groups[i][1];
            for(int j=i; j<groups.length; j++) {
                int s = groups[j][0];
                int e = groups[j][0];
                if(fill(s,e)< fill(start, end)) {
                    answer++;
                } else {
                    fillBack(s,e);
                }
                System.out.println(Arrays.toString(fill));
            }
        }
        return answer;
    }
    static int fill(int a, int b) {
        for(int j=a; j<=b; j++) {
            fill[j] = true;
        }
        int cnt = 0;
        for(boolean bo : fill) {
            if(bo == true)
                cnt++;
        }
        return cnt;
    }
    static void fillBack(int a, int b) {
        for(int j=a; j<=b; j++) {
            fill[j] = false;
        }
    }
}
