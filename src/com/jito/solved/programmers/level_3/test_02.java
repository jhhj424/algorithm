package com.jito.solved.programmers.level_3;

import java.util.ArrayList;

/*
    프로그래머스 - 2018 KAKAO BLIND RECRUITMENT - [1차] 추석 트래픽 : https://programmers.co.kr/learn/courses/30/lessons/17676?language=java
 */
public class test_02 {
    public static void main(String[] args) {
        String[] s = {
                "2016-09-15 20:59:57.421 0.351s",
                "2016-09-15 20:59:58.233 1.181s",
                "2016-09-15 20:59:58.299 0.8s",
                "2016-09-15 20:59:58.688 1.041s",
                "2016-09-15 20:59:59.591 1.412s",
                "2016-09-15 21:00:00.464 1.466s",
                "2016-09-15 21:00:00.741 1.581s",
                "2016-09-15 21:00:00.748 2.31s",
                "2016-09-15 21:00:00.966 0.381s",
                "2016-09-15 21:00:02.066 2.62s"};
//        String[] s = {
//                "2016-09-15 01:00:04.002 2.0s", "2016-09-15 01:00:07.000 2s"
//        };
        System.out.println(solution(s));
    }
    public static int solution(String[] lines) {
        int answer = 0;
        ArrayList<Time> list = new ArrayList<>();
        for (String line : lines) {
            String[] split = line.split(" ");

            // end : 입력으로 주어졌던 작업 끝난시간
            double end = Double.parseDouble(split[1].substring(0, 2)) * 3600; // 시간
            end += Double.parseDouble(split[1].substring(3, 5)) * 60; // 분
            end += Double.parseDouble(split[1].substring(6, 12)); // 초

            // d : 작업소요시간
            double d = Double.parseDouble(split[2].substring(0, split[2].length() - 1)) - 0.001;

            // start : end - d 를 한 작업 시작시간
            double start = end - d;

            list.add(new Time(start,end));
        }

        // 반복을 돌면서 기준시간의 작업 끝난시간 + 0.999초 이내의 작업이 돌고있으면 카운트++
        for (int i=0; i<list.size(); i++) {
            int cnt = 0;
            double p = Math.round((list.get(i).end + 0.999) * 1000) / 1000.0;
            for(int j=i; j<list.size(); j++) {
                if(p >= list.get(j).end || p >= list.get(j).start) {
                    cnt++;
                }
            }
            answer = Math.max(answer, cnt);
        }
        return answer;
    }
}

class Time {
    double end;
    double start;
    Time(double s, double e) {
        start = s;
        end = e;
    }
}