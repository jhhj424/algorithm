package com.jito.solved.programmers;

import java.util.LinkedList;
import java.util.Queue;

/*
* 다리를 지나는 트럭
* 문제 설명
트럭 여러 대가 강을 가로지르는 일 차선 다리를 정해진 순으로 건너려 합니다. 모든 트럭이 다리를 건너려면 최소 몇 초가 걸리는지 알아내야 합니다. 트럭은 1초에 1만큼 움직이며, 다리 길이는 bridge_length이고 다리는 무게 weight까지 견딥니다.
※ 트럭이 다리에 완전히 오르지 않은 경우, 이 트럭의 무게는 고려하지 않습니다.
*/
public class bridgeTruck {
    public static void main(String[] args) {
        int[] arr = {7,4,5,6};
        int result = solved(2, 10, arr);
        System.out.println(result);
    }
    public static int solved(int bridge_length, int weight, int[] truck_weights) {
        int total_weight = 0;
        int time = 0;
        Queue<Truck> trucks = new LinkedList<>();
        Queue<Truck> bridge = new LinkedList<>();
        for(int i: truck_weights) {
            trucks.offer(new Truck(i, 0));
        }
        while(!trucks.isEmpty() || !bridge.isEmpty()) {
            time++;
            if(!bridge.isEmpty()) {
                Truck bridgeInTruck = bridge.peek();
                if(time - bridgeInTruck.time == bridge_length) {
                    total_weight -= bridge.peek().weigth;
                    bridge.poll();
                    System.out.println("bridge:" + time);
                }
            }
            if(!trucks.isEmpty()) {
                if(trucks.peek().weigth+total_weight <= weight) {
                    total_weight += trucks.peek().weigth;
                    bridge.offer(new Truck(trucks.poll().weigth,time));
                    System.out.println("truck:" + time);
                }
            }


        }

        return time;
    }
}

class Truck{
    int weigth;
    int time;
    Truck(int weigth, int location){
        this.weigth = weigth;
        this.time = location;
    }
}