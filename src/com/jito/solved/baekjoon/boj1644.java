package com.jito.solved.baekjoon;

import java.util.*;

/**
 * Created by jhhj424@naver.com on 2020-11-03
 * Blog : https://jhhj424.tistory.com/
 * Github : http://github.com/jhhj424
 * 백준 1644번 소수의 연속합 : https://www.acmicpc.net/problem/1644
 */
public class boj1644 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int target = sc.nextInt();
        ArrayList<Integer> list = sosu(target);
        int s, e, sum, cnt;
        s = e = sum = cnt = 0;
        while(true) {
            if(sum >= target) {
                sum -= list.get(s++);
            } else if(e == list.size()) break;
            else {
                sum += list.get(e++);
            }
            if(sum == target)
                cnt++;
        }
        System.out.println(cnt);
        sc.close();
    }
    public static ArrayList<Integer> sosu(int n) {
        ArrayList<Integer> list = new ArrayList<>();
        boolean[] arr = new boolean[n+1];
        Arrays.fill(arr, true);
        for(int i=2; i<= Math.sqrt(n); i++){
            if(arr[i]) {
                int j=2;
                while(i*j <= n) {
                    arr[i*j] = false;
                    j += 1;
                }
            }
        }
        for(int i=2; i<=n; i++) {
            if(arr[i])
                list.add(i);
        }
        return list;
    }
}
