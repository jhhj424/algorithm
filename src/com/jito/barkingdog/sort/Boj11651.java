package com.jito.barkingdog.sort;

import java.util.*;

/*
    좌표 정렬하기2 : 정렬 : https://www.acmicpc.net/problem/11651
 */
public class Boj11651 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        ArrayList<xy> list = new ArrayList<>();
        for(int i=0; i<n; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            list.add(new xy(x,y));
        }

        list.sort((p1, p2) -> {
            if(p1.y == p2.y) {
                return p1.x - p2.x;
            }
            return p1.y - p2.y;
        });

        for (xy xy : list) {
            System.out.println(xy.x + " " + xy.y);
        }
    }
}
class xy {
    int x;
    int y;

    public xy(int x, int y) {
        this.x = x;
        this.y = y;
    }
}