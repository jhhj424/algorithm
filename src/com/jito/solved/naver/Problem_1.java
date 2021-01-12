package com.jito.solved.naver;

public class Problem_1 {
    public static void main(String[] args) {
        Solution s =new Solution();
        System.out.println(s.solution("kkaxbycyz", "abc")); // kkxyyz
    }
}

class Solution {
    public String solution(String m, String k) {
        StringBuilder sb = new StringBuilder();
        int index = 0;
        for(int i=0; i<k.length(); i++) {
            for(int j=index; j<m.length(); j++) {
                if(k.charAt(i) != m.charAt(j)) {
                    sb.append(m.charAt(j));
                }else {
                    index = j+1;
                    break;
                }
            }
        }
        for(int i=index; i<m.length(); i++) {
            sb.append(m.charAt(i));
        }
        return sb.toString();
    }
}