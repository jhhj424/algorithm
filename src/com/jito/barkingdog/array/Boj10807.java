package com.jito.barkingdog.array;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * 개수 세기 : https://www.acmicpc.net/problem/10807
 */
public class Boj10807 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        List<String> strings = Arrays.asList(sc.nextLine().split(" "));
        int v = Integer.parseInt(sc.nextLine());
        System.out.print(strings.stream().filter(s -> Integer.parseInt(s) == v).count());
    }
}
