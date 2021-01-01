package com.jito.solved.toss;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;

public class Toss_3 {
    public static void main(String[] args) throws Exception {
        // [!!주의!!] Function.compute 함수는 이미 구현되어있지만, 숨김처리되어 있습니다. 호출해서 테스트 해주세요.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        int[] result = Server_3(input);
        for(int i: result) {
            System.out.print(i+" ");
        }
    }

    public static int[] Server_3(String input) {
        String[] arr = input.split(" ");
        ArrayList<Integer> list = new ArrayList<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        int[] result = new int[arr.length];
        for(String s: arr) {
            int num = Integer.parseInt(s);
            if(!list.contains(num)) {
                list.add(num);
                map.put(num,compute(num));
            }
        } // 중복제거한 list를 가지고있음
        for(int i=0; i<result.length; i++) {
            result[i] = map.get(Integer.parseInt(arr[i]));
        }
        return result;
    }
    public static int compute(int i) {
        return i*10;
    }
}
