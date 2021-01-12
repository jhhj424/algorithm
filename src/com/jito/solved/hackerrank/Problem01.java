package com.jito.solved.hackerrank;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Problem01 {

    public static int balancedSum(List<Integer> arr) {
        int start = 0, end = arr.size()-1, s=0, e=0;

        while(start < end) {
            if(s < e) {
                s += arr.get(start++);
            } else{
                e += arr.get(end--);
            }
        }
        return start;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Integer> list = new ArrayList<>();
        int len = sc.nextInt();
        for(int i=0; i<len; i++) {
            list.add(sc.nextInt());
        }

        int result = balancedSum(list);

        System.out.println(result);
    }
}
