package com.jito.solved.kakao;

import java.util.*;

public class second {
    public static void main(String[] args) {
        String[] arr = {"ABCFG", "AC", "CDE", "ACDE", "BCFG", "ACDEH"};
        int[] c = {2,3,4};
        String[] result = solution(arr, c);
        System.out.println(Arrays.toString(result));
    }
    private static ArrayList<String> list = new ArrayList<>();
    private static ArrayList<Food> answer = new ArrayList<>();
    private static HashMap<String, Integer> map = new HashMap<>();
    private static int max[] = new int[11];
    public static String[] solution(String[] orders, int[] course) {
        String[][] arr = new String[orders.length][];
        for(int i=0; i<orders.length; i++) {
            arr[i] = orders[i].split("");
            for (int aCourse : course) {
                perm(arr[i], 0, aCourse);
            }
            for(String s: list) {
                map.put(s,map.getOrDefault(s,0)+1);
            }
            list = new ArrayList<>();
        }
        for(String s: map.keySet()) {
            if(map.get(s)>1) {
                String order = s;
                int count = map.get(s);
                int len = s.length();
                answer.add(new Food(order,count,len));
                max[len] = Math.max(max[len], count);
            }
        }
        ArrayList<String> result = new ArrayList<>();
        for (Food d : answer) {
            if (max[d.len] == d.count) result.add(d.order);
        }
        String[] r = new String[result.size()];
        for(int i=0; i<result.size(); i++) {
            r[i] = result.get(i);
        }
        Arrays.sort(r);
        return r;
    }
    private static void perm(String[] arr, int depth, int k){
        if(depth==k){
            print(arr, k);
        }
        else{
            for(int i=depth; i<arr.length; i++){
                swap(arr, i, depth);
                perm(arr, depth+1, k);
                swap(arr, i, depth);
            }
        }
    }
    private static void swap(String[] arr, int i, int j){
        String temp=arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }
    private static void print(String[] arr, int k){
        StringBuilder s=new StringBuilder();
        for(int i=0;i<k;i++){
            s.append(arr[i]);
        }
        if(!list.contains(s.toString())) {
            for(int i=0; i<s.length(); i++) {
                String[] sarr = s.toString().split("");
                Arrays.sort(sarr);
                s=new StringBuilder();
                for(int a=0;a<k;a++){
                    s.append(sarr[a]);
                }
                if(!list.contains(s.toString())) {
                    list.add(s.toString());
                }
            }
        }
    }
}
class Food{
    String order;
    int count;
    int len;
    Food(String order, int count, int len) {
        this.order = order;
        this.count = count;
        this.len = len;
    }
}