package com.jito.solved.programmers.challenge;

import java.util.*;

/*
문제 설명
n개의 점으로 이루어진 트리가 있습니다. 이때, 트리 상에서 다음과 같은 것들을 정의합니다.

어떤 두 점 사이의 거리는, 두 점을 잇는 경로 상 간선의 개수로 정의합니다.
임의의 3개의 점 a, b, c에 대한 함수 f(a, b, c)의 값을 a와 b 사이의 거리, b와 c 사이의 거리, c와 a 사이의 거리, 3개 값의 중간값으로 정의합니다.
트리의 정점의 개수 n과 트리의 간선을 나타내는 2차원 정수 배열 edges가 매개변수로 주어집니다. 주어진 트리에서 임의의 3개의 점을 뽑아 만들 수 있는 모든 f값 중에서, 제일 큰 값을 구해 return 하도록 solution 함수를 완성해주세요.

제한 사항
n은 3 이상 250,000 이하입니다.
edges의 행의 개수는 n-1 입니다.
edges의 각 행은 [v1, v2] 2개의 정수로 이루어져 있으며, 이는 v1번 정점과 v2번 정점 사이에 간선이 있음을 의미합니다.
v1, v2는 각각 1 이상 n 이하입니다.
v1, v2는 다른 수입니다.
입력으로 주어지는 그래프는 항상 트리입니다.
입출력 예
n	edges	result
4	[[1,2],[2,3],[3,4]]	2
5	[[1,5],[2,5],[3,5],[4,5]]	2
입출력 예 설명
입출력 예 #1

다음 그림은 입력으로 주어진 트리를 나타낸 것입니다.
ex1.png

다음 표는 주어진 트리에서 나올 수 있는 모든 f값의 경우를 나열한 것입니다. (단, a, b, c의 순서만 다른 경우는 f값이 동일하기 때문에 표에서 제외)
a	b	c	a ~ b 거리	b ~ c 거리	c ~ a 거리	f(a, b, c)
1	2	3	1	1	2	1
1	2	4	1	2	3	2
1	3	4	2	1	3	2
2	3	4	1	1	2	1
따라서, 2를 return 해야 합니다.
입출력 예 #2

다음 그림은 입력으로 주어진 트리를 나타낸 것입니다.
ex2.png

f값에 사용될 3개의 점으로 (1, 2, 3), (2, 3, 4) 등을 고를 때 가장 큰 값인 2를 얻을 수 있으므로, 2를 return 해야 합니다.
 */
public class oct3 {
    public static void main(String[] args) {
//        int[][] edges = {{1,5},{2,5},{3,5},{4,5}};
        int[][] edges = {{1,2},{2,3},{3,4}};
        System.out.println(solution(5, edges)); // 2;
    }

    public static final int INF = (int) 1e9;
    public static int[][] graph;
    public static int solution(int n, int[][] edges) {
        int m = edges.length;
        graph  = new int[n+1][n+1];

        for (int i = 0; i < n+1; i++) {
            Arrays.fill(graph[i], INF);
        }

        for (int a = 1; a <= n; a++) {
            for (int b = 1; b <= n; b++) {
                if (a == b) graph[a][b] = 0;
            }
        }

        for (int i = 0; i < m; i++) {
            int a = edges[i][0];
            int b = edges[i][1];
            graph[a][b] = 1;
            graph[b][a] = 1;
        }

        ArrayList<Integer> list;
        int max = 0;

        for (int k = 1; k <= n; k++) {
            for (int a = 1; a <= n; a++) {
                list = new ArrayList<>();
                int sum = 0;
                for (int b = 1; b <= n; b++) {
                    graph[a][b] = Math.min(graph[a][b], graph[a][k] + graph[k][b]);

                    if (graph[a][b] != INF) {
                        list.add(graph[a][b]);
                    }
                }
                Collections.sort(list, Collections.reverseOrder());
                for(int i=0; i<list.size(); i++) {
                    sum += list.get(i);
                    if(i == 2)
                        break;
                }
                max = Math.max(max, sum);
            }
        }

        return max/3;


    }
}
