package com.jito.solved.programmers;

import java.util.Arrays;
import java.util.HashMap;

public class level1_1 {
    public static void main(String[] args) {
        String[] participant = {"marina", "josipa", "nikola", "vinko", "filipa"};
        String[] completion = {"josipa", "filipa", "marina", "nikola"};

//        String[] participant2 = {"mislav", "stanko", "mislav", "ana"};
//        String[] completion2 = {"stanko","mislav", "ana"};
//        String result = 완주하지못한선수(participant, completion);
        String result = solution(participant, completion);
//        String result2 = solution(participant2, completion2);

        System.out.println(result);
//        System.out.println(result2);
    }
    public static String 완주하지못한선수(String[] participant, String[] completion) {
        String answer = "";
        Arrays.sort(participant);
        Arrays.sort(completion);
        int i =0;
        for(i =0; i<completion.length;i++){
            if(!participant[i].equals(completion[i])){
                return participant[i];
            }
        }
        return participant[i];
    }
    public static String solution(String[] participant, String[] completion) {
        HashMap<String,Integer> map = new HashMap<>();
        for(String p: participant) {
            if(map.containsKey(p)) {
                map.replace(p, map.get(p)+1);
            }else {
                map.put(p,1);
            }
        }
        // 전부다 1 , 중복일 경우 2
        for(String c: completion) {
            map.replace(c,map.get(c)-1);
        }
        // 포함된 항목은 전부다 -1, 중복일경우 1
        for(String m: map.keySet()) {
            if(map.get(m)==1) {
                return m;
            }
        }
        return null;
    }
}
