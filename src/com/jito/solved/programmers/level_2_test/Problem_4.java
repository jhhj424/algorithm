package com.jito.solved.programmers.level_2_test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/*
프로그래머스 - 스택/큐 - 프린터 - 레벨2

https://programmers.co.kr/learn/courses/30/lessons/42587?language=java
 */
public class Problem_4 {
    public static void main(String[] args) {
        System.out.println(solution(new int[]{2,1,3,2}, 2)); // 1
        System.out.println(solution(new int[]{1, 1, 9, 1, 1, 1}, 0)); // 5
        System.out.println(solution(new int[]{3,3,4,2}, 3)); // 4
    }
    public static int solution(int[] priorities, int location) {
        int answer = 0;
        Queue<Doc> q = new LinkedList<>();
        ArrayList<Integer> list = new ArrayList<>();
        for(int i=0; i<priorities.length; i++) {
            q.offer(new Doc(i, priorities[i]));
            list.add(priorities[i]);
        }
        int cnt = 0;
        while(!q.isEmpty()) {
            Doc now = q.poll();
            list.remove(list.indexOf(now.priorities));

            // 이후 작업중에 뽑은것보다 우선순위가 없으면 cnt 1 증가
            boolean chk = false;
            for(int i=now.priorities+1; i<10; i++) {
                if(list.contains(i)) {
                    chk = true;
                    break;
                }
            }
            if(chk){
                q.offer(now);
                list.add(now.priorities);
            }
            else {
                cnt++;
                if(now.index == location)
                    return cnt;
            }
        }
        return answer;
    }
}
class Doc {
    int index;
    int priorities;
    Doc(int i, int p) {
        this.index = i;
        this.priorities = p;
    }
}