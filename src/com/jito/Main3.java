package com.jito;

import java.util.ArrayList;
import java.util.Arrays;

public class Main3 {

    public static void main(String[] args) {
        Integer[] a = {0,3,3,0,7,0,2,0};
        Integer[] a2 = {0, 3, 3, 0, 7, 2, 0, 2};

        ArrayList<Integer> arrayList = new ArrayList<>(Arrays.asList(a));

        System.out.println(isStart(arrayList));
        arrayList = new ArrayList<>(Arrays.asList(a2));
        System.out.println(isStart(arrayList));
    }
    static boolean isStart(ArrayList<Integer> arr) {
        int[] m = new int[2];
        if(arr.size() % 2 != 0) return false;
        System.out.println(arr);
        m[0] = arr.get(0);
        m[1] = arr.get(1);
        boolean flag = false;
        for(int i=2; i<arr.size(); i += 2) {
            int a = arr.get(i);
            int b = arr.get(i+1);
            if(m[0] == a || m[0] ==b) {
                flag = true;
            }
            if(m[1] == a || m[1] == b) {
                flag = true;
            }
            if (!flag) return false;
            flag = false;
        }
        return true;
    }

}
