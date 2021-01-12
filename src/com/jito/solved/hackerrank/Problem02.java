package com.jito.solved.hackerrank;

import java.util.Scanner;

public class Problem02 {


    public static String lastLetters(String word) {
        StringBuilder sb = new StringBuilder();
        String[] split = word.split("");
        sb.append(split[split.length-2].toUpperCase()).append(" ").append(split[split.length-1].toUpperCase());
        return sb.toString();
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String word = sc.nextLine();
        System.out.println(lastLetters(word));
    }
}
