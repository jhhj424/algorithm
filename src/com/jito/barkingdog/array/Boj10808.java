package com.jito.barkingdog.array;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 알파벳 개수 : https://www.acmicpc.net/problem/10808
 */
public class Boj10808 {
    public static void main(String[] args) {
        int[] arr = new int[26];
        Scanner sc = new Scanner(System.in);
        Arrays.asList(sc.nextLine().split("")).forEach(s -> arr[s.charAt(0) - 'a']++);
        for (int i : arr) System.out.print(i+" ");
    }
}
