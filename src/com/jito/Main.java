package com.jito;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        int[] arr = {5,2,3,3,5,3};
        int[] a = {0,3,3,0,7,2,0,2,2,0};
        System.out.println(solution(arr));
    }

    public static int solution(int[] a) {
        int answer = 0;
        int len = a.length%2 == 0? a.length : a.length-1;
        for(int i=len; i>=2; i -= 2) {
            makeCombination(a, i, new Integer[i], 0, 0);
            for(int j=list.size()-1; j >= 0; j--) {
                int startToLen = startToLen(list.get(j));
                if(startToLen != 0) return startToLen;
            }
        }
        return answer;
    }
    static int startToLen(ArrayList<Integer> arr) {
        if(!isNotEquals(arr)) return 0;
        if(!isStart(arr)) return 0;
        return arr.size();
    }

    static ArrayList<ArrayList<Integer>> list = new ArrayList<>();
    private static void makeCombination(int[] arr, int r, Integer[] temp, int current, int start) {
        if (r == current) {
            ArrayList<Integer> ar = new ArrayList<>(Arrays.asList(temp));
            list.add(ar);
        } else {
            for (int i = start; i < arr.length; i++) {
                temp[current] = arr[i];
                makeCombination(arr, r, temp, current + 1, i + 1);
            }
        }
    }

    static boolean isStart(ArrayList<Integer> arr) {
        int[] m = new int[2];
        if(arr.size() % 2 != 0) return false;
        m[0] = arr.get(0);
        m[1] = arr.get(1);
        boolean flag = false;
        for(int i=2; i<arr.size(); i += 2) {
            int a = arr.get(i);
            int b = arr.get(i+1);
            if(m[0] == a || m[0] ==b) {
                flag = true;
            }else if(m[1] == a || m[1] == b) {
                flag = true;
            }
            if (!flag) return false;
            flag = false;
        }
        return true;
    }

    static boolean isNotEquals(ArrayList<Integer> a) {
        for(int i=0; i<a.size()-1; i += 2) {
            if(a.get(i).equals(a.get(i + 1))) return false;
        }
        return true;
    }
}
