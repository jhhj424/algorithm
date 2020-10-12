package com.jito.solved.programmers.dev_matching;

import java.util.*;

/*
문제 설명
세계에서 가장 멋진 디자인의 자동차를 뽑기 위한 콘테스트가 열렸습니다. 예선은 인터넷 투표로 진행되었으며, 전 세계인들이 각자 생각하는 가장 멋진 디자인의 자동차 이름을 적어서 주최 측에 보냈습니다. 예선에서 상위권에 오른 몇 개의 자동차를 전시한 후, 현장에서 직접 투표하는 방식으로 본선을 진행하려고 합니다.
하지만 예선에서 너무 많은 자동차가 표를 받아서, 본선에 진출하는 자동차를 선정하는데 어려움이 있습니다. 이에, 주최 측은 다음과 같은 방식으로 예선에서 탈락시킬 자동차를 고르려고 합니다.

가장 표를 적게 받은 하위 순위의 자동차부터 차례대로 탈락시킵니다. 만약 득표수가 같다면 알파벳 사전식 순서로 뒤쪽에 위치한 자동차가 먼저 탈락합니다. 단, 탈락시키는 자동차의 득표수 합이 상위 순위 k개 자동차의 득표수 합보다 작을 때까지만 이 작업을 반복합니다.

아래는 예선 투표 결과의 한 예시입니다.
AVANT, PRIDO, SONATE, RAIN, MONSTER, GRAND, SONATE, AVANT, SONATE, RAIN, MONSTER, GRAND, SONATE, SOULFUL, AVANT, SANTA

만약 k=2라면, 상위 순위 2개 자동차의 득표수 합은 7입니다(SONATE 4표, AVANT 3표)
따라서, 하위 순위인 SOULFUL(1표), SANTA(1표), PRIDO(1표), RAIN(2표)가 차례대로 탈락합니다. MONSTER(2표)까지 탈락시키면, 탈락시킨 자동차의 득표수 합(1+1+1+2+2)이 7 이상이 되므로, 주어진 조건을 만족하지 못합니다. 따라서 마지막으로 탈락하는 자동차는 RAIN입니다.

예선 투표 결과를 담은 배열 votes, 자연수 k가 매개변수로 주어질 때, 예선에서 마지막으로 탈락하는 자동차의 이름을 return 하도록 solution 함수를 완성해주세요.

제한사항
votes의 길이는 2 이상 100,000 이하입니다.
votes의 원소는 길이 1 이상 10 이하인 문자열입니다.
votes의 원소는 알파벳 대문자로만 이루어져 있습니다.
k는 1 이상 100,000 이하인 자연수입니다. 단, k는 votes의 길이보다 작거나 같습니다.
예선에서 탈락하는 자동차가 하나도 없는 경우는 입력으로 주어지지 않습니다.
입출력 예
votes	k	result
["AVANT", "PRIDO", "SONATE", "RAIN", "MONSTER", "GRAND", "SONATE", "AVANT", "SONATE", "RAIN", "MONSTER", "GRAND", "SONATE", "SOULFUL", "AVANT", "SANTA"]	2	"RAIN"
["AAD", "AAA", "AAC", "AAB"]	4	"AAB"
입출력 예 설명
입출력 예 #1
문제 예시와 같습니다.

입출력 예 #2
모든 자동차가 1표씩 득표하였습니다. 따라서 상위 4개 자동차의 득표수 합은 4입니다.
득표수가 같다면 알파벳 사전식 순서로 뒤쪽에 위치하는 것부터 탈락하므로, AAD, AAC, AAB가 차례대로 탈락합니다. 마지막에 탈락하는 AAB를 return 해 주어야 합니다. AAA까지 탈락시키면 탈락하는 자동차의 득표수 합이 4 이상이 되므로, 탈락시키지 않음을 유의합니다.
 */

public class Problem2 {
    public static void main(String[] args) {
        String[] v = {"AAD", "AAA", "AAC", "AAB"};
        int k = 4;
        System.out.println(solution(v,k)); // RAIN

    }
    public static String solution(String[] votes, int k) {

        HashMap<String, Integer> map = new HashMap<>();
        for (String vote : votes) {
            map.put(vote, map.getOrDefault(vote, 0) + 1);
        }
        ArrayList<Car> cars = new ArrayList<>();
        map.forEach((key, value) -> {
            cars.add(new Car(key, value));
        });
        Collections.sort(cars, ((o1, o2) ->  {
            if(o1.vote == o2.vote) {
                return -o1.name.compareTo(o2.name);
            }
            return o1.vote - o2.vote;
        }));
        int sum = 0;
        for(int i=1; i<=k; i++) {
            sum += cars.get(cars.size()-i).vote;
        }
        int outSum = 0;
        for(int i=0; i<cars.size(); i++) {
            outSum += cars.get(i).vote;
            if(outSum >= sum) {
                return cars.get(i-1).name;
            }
        }
        return "";
    }

}
class Car {
    String name;
    int vote;
    Car(String name, int vote) {
        this.name = name;
        this.vote = vote;
    }

    @Override
    public String toString() {
        return "Car{" +
                "name='" + name + '\'' +
                ", vote=" + vote +
                '}';
    }
}
