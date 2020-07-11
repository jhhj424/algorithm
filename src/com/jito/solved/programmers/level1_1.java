package com.jito.solved.programmers;

import java.util.Arrays;

public class level1_1 {
    public static void main(String[] args) {
        String[] participant = {"leo", "kiki", "eden"};
        String[] completion = {"eden", "kiki"};
        String result = 완주하지못한선수(participant, completion);

        System.out.println(result);
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
}
