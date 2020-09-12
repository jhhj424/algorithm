package com.jito.solved.kakao;

import java.util.*;

public class four {
    public static void main(String[] args) {
        int[][] arr = {{4, 1, 10}, {3, 5, 24}, {5, 6, 2}, {3, 1, 41}, {5, 1, 24}, {4, 6, 50}, {2, 4, 66}, {2, 3, 22}, {1, 6, 25}};
        System.out.println(solution(6,4,6,2,arr));
    }
    private static final int INF = (int) 1e9;
    private static ArrayList<ArrayList<Taxi>> list = new ArrayList<>();
    private static int[] d; // 최단거리 저장할 배열

    private static void dijkstra(int start) {
        PriorityQueue<Taxi> pq = new PriorityQueue<>();
        pq.offer(new Taxi(start, 0));
        d[start] = 0;

        while (!pq.isEmpty()) {
            Taxi Taxi = pq.poll();
            assert Taxi != null;
            int dist = Taxi.cost;
            int now = Taxi.index;

            if (d[now] < dist) continue;

            for (int i = 0; i < list.get(now).size(); i++) {
                Taxi next_Taxi = list.get(now).get(i);
                int cost = d[now] + next_Taxi.cost;
                if (d[next_Taxi.index] > cost) {
                    d[next_Taxi.index] = cost;
                    pq.offer(new Taxi(next_Taxi.index, cost));
                }
            }
        }
    }

    public static int solution(int n, int s, int a, int b, int[][] fares) {
        d = new int[n+1];
        Arrays.fill(d, INF);

        for(int i=0; i< n+1; i++) {
            list.add(new ArrayList<>());
        }

        for (int[] fare : fares) {
            list.get(fare[0]).add(new Taxi(fare[1], fare[2]));
            list.get(fare[1]).add(new Taxi(fare[0], fare[2]));
        }

        int min = INF;
        dijkstra(s);
        int[] sd = d.clone();
        Arrays.fill(d, INF);
        dijkstra(a);
        int[] ad = d.clone();
        Arrays.fill(d, INF);
        dijkstra(b);
        int[] bd = d.clone();
        for(int i=1; i<=n; i++) {
            int mid = sd[i];
            min = Math.min(min, mid +ad[i] + bd[i]);
        }
        return min;
    }
}

class Taxi implements Comparable<Taxi> {
    int index, cost;

    Taxi(int index, int cost) {
        this.cost = cost;
        this.index = index;
    }

    @Override
    public int compareTo(Taxi other) {
        return this.cost - other.cost;
    }
}