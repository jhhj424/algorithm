package com.jito.solved.programmers.kakao2022;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class 주차요금계산 {

    public static void main(String[] args) {
        int[] fee = {180, 5000, 10, 600};
        String[] records = {"05:34 5961 IN", "06:00 0000 IN", "06:34 0000 OUT", "07:59 5961 OUT", "07:59 0148 IN", "18:59 0000 IN", "19:09 0148 OUT", "22:59 5961 IN", "23:00 5961 OUT"};
//        result: [14600, 34400, 5000]
        System.out.println(solution(fee, records));
    }

    public static List<Integer> solution(int[] fees, String[] records) {
        // map 으로 관리

        HashMap<String, Car> carMap = new HashMap<>();
        for (String record : records) {
            String[] r = record.split(" ");
            Car car = carMap.getOrDefault(r[1], new Car(r[1]));
            if (r[2].equals("IN")) {
                car.in(r[0]);
            } else {
                car.out(r[0]);
            }
            carMap.put(r[1], car);
        }

        List<String> keys = carMap.keySet().stream().sorted().collect(Collectors.toList());
        ArrayList<Integer> answer = new ArrayList<>();

        for (String key : keys) {
            Car car = carMap.get(key);
            if (car.inOut) {
                car.out("23:59");
            }
            answer.add(calculateFee(car, fees));
        }

        return answer;
    }

    private static Integer calculateFee(Car car, int[] fees) {
        int baseTime = fees[0];
        int baseFee = fees[1];
        int addTime = fees[2];
        int addFee = fees[3];
        int totalTime = car.totalTime;

        if (totalTime <= baseTime) return baseFee;
        return baseFee + (int) Math.ceil((double) (totalTime - baseTime) / addTime) * addFee;
    }


    // car 클래스 (num, time, inOut, totalTime)
    static class Car {
        String num;
        String time;
        boolean inOut; // in: true, out: false
        int totalTime;

        Car(String n) {
            num = n;
            time = "00:00";
            inOut = true;
            totalTime = 0;
        }

        void in(String t) {
            time = t;
            inOut = true;
        }

        void out(String t) {
            calculateTime(t);
            inOut = false;
        }

        void calculateTime(String t) {
            String[] inTime = time.split(":");
            String[] outTime = t.split(":");

            int hour = Integer.parseInt(outTime[0]) - Integer.parseInt(inTime[0]);
            int minute = Integer.parseInt(outTime[1]) - Integer.parseInt(inTime[1]);

            totalTime += (hour * 60) + minute;
        }
    }
}
