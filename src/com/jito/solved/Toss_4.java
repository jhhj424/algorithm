package com.jito.solved;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Stack;

public class Toss_4 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        String[] arr = input.split(" ");
        for(int i=0; i<arr.length; i++) {
            ArrayList<String> list = new ArrayList<>();
            int cnt =0;
            for(int j=i; j>=0; j--) {
                if(cnt == 5) break;
                if(j>0) {
                    if(!list.contains(arr[j])) {
                        if(!arr[j].equals(arr[j-1])) {
                            list.add(arr[j]);
                            cnt++;
                        }
                    }
                }else {
                    if(list.isEmpty()){
                        System.out.print(arr[j] + " ");
                    }
                    cnt++;
                }
            }
            for(String s: list) {
                System.out.print(s + " ");
            }
            System.out.println();
        }
    }
}
