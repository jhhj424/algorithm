package com.jito.solved.kakao;

public class first {
    public static void main(String[] args) {
        System.out.println(solution("...!@...BaT#*..y.abcd..efg.hijklm")); // bat.y.abcdefghi
//        System.out.println(solution("123_.def"));
    }
    static String solution(String new_id) {
        // 1단계
        new_id = new_id.toLowerCase();
        // 2단계
        new_id = new_id.replaceAll("[^a-z0-9-_.]", "");
        // 3단계
        StringBuilder p = new StringBuilder();
        int n = new_id.length();
        int m = new_id.length();
        for(int a = 0; a <= m; a++) {
            for (int i=0; i<n; i++) {
                p.append(".");
            }
            if(p.toString().equals(".")) break;
            while (new_id.contains(p.toString())) {
                new_id = new_id.replace(p.toString(),".");
            }
            n--;
            p = new StringBuilder();
        }
        // 4단계
        if(new_id.charAt(0) == '.') {
            if(new_id.length()!=1)
                new_id = new_id.substring(1);
            else
                new_id = "";
        }
        int idx = new_id.length()-1==-1?0:new_id.length()-1;
        if(idx!=0) {
            if(new_id.charAt(idx) == '.') new_id = new_id.substring(0,idx);
        }
        // 5단계
        if(new_id.isEmpty()) new_id = "a";
        // 6단계
        if(new_id.length() >= 16) {
            new_id = new_id.substring(0,15);
            if(new_id.charAt(14) == '.') {
                new_id = new_id.substring(0,14);
            }
        }
        // 7단계
        if(new_id.length()<=2) {
            String last = new_id.substring(new_id.length()-1);
            while(new_id.length()<3) {
                new_id += last;
            }
        }
        return new_id;
    }
}
