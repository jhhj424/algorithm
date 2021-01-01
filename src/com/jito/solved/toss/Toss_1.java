package com.jito.solved.toss;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Toss_1 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        System.out.println(Server_1(input));
    }
    public static boolean Server_1(String input) {
        char[] c = input.toCharArray();
        if(c[c.length-1] == '1') return false;
        for(int i=1; i<c.length; i++) {
            if(c[i-1]=='1') {
                if(c[i] != '2'){
                    return false;
                }
            }
        }
        return true;
    }
}
