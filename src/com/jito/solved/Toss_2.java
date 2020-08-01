package com.jito.solved;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Toss_2 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        System.out.println(Server_2(input));
    }
    public static boolean Server_2(String input) {
        String[] arr = input.split(" ");
        int[] inputToInt = new int[arr.length];
        if(inputToInt.length != 6) return false;
        for (int i=0; i<arr.length; i++) {
            inputToInt[i] = Integer.parseInt(arr[i]);
        }
        for(int i=0; i<inputToInt.length; i++) {
            if(inputToInt[i]<1 || inputToInt[i]>45) return false;
            if(i>0) {
                if(inputToInt[i-1] >= inputToInt[i]) return false;
            }
        }
        return true;
    }
}
