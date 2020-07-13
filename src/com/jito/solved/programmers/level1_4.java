package com.jito.solved.programmers;

public class level1_4 {
    public static void main(String[] args) {
        System.out.println(가운데글자가져오기2("shinjiho"));
        System.out.println(가운데글자가져오기("abcde"));
    }
    public static String 가운데글자가져오기(String s) {
        String answer = "";
        int len = s.length()/2;
        if(s.length()%2==0) { // 짝수
            answer = s.substring(len-1, len+1);
        }else {  // 홀수
            answer = s.substring(len, len+1);
        }
        return answer;
    }
    public static String 가운데글자가져오기2(String s) {
        return s.substring((s.length()-1) / 2, s.length()/2 + 1);
    }

}
