package com.jito.barkingdog.sort;

import java.io.*;
import java.util.*;
/*
    단어 정렬 : https://www.acmicpc.net/problem/1181
 */
public class Boj1181 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        int i = 0;

        ArrayList<String> list = new ArrayList<>();

        while (i < n) {
            list.add(br.readLine());
            i++;
        }

        list.sort((o1, o2) -> {
            if (o1.length() == o2.length()) {
                return o1.compareTo(o2);
            }
            return o1.length() - o2.length();
        });

        LinkedHashSet<String> set = new LinkedHashSet<>(list);
        for (String s : set) {
            sb.append(s).append("\n");
        }
        System.out.println(sb.toString());
    }
}