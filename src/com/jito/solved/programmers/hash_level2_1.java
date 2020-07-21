package com.jito.solved.programmers;


import java.util.Arrays;

public class hash_level2_1 {
    public static void main(String[] args) {
        String[] arr = {"119", "97674223", "1195524421"};
        String[] arr2 = {"123", "456", "789"};
        System.out.println(solution2(arr));
        System.out.println(solution2(arr2));
    }
    public static boolean solution(String[] phone_book) {
        if(phone_book == null || phone_book.length==0) {
            return true;
        }

        for(int i=0; i<phone_book.length-1; i++) {
            for(int j=i+1; j<phone_book.length; j++) {
                if(phone_book[i].startsWith(phone_book[j])) return false;
                if(phone_book[j].startsWith(phone_book[i])) return false;
            }
        }

        return true;
    }

    public static boolean solution2(String[] phone_book) {
        if(phone_book == null || phone_book.length==0) {
            return true;
        }

        Arrays.sort(phone_book);
        for(int i=0; i<phone_book.length-1; i++) {
            if(phone_book[i+1].startsWith(phone_book[i])) return false;
        }

        return true;
    }
}
