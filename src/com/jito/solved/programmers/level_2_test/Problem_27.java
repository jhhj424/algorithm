package com.jito.solved.programmers.level_2_test;

import java.util.*;
import java.util.stream.Collectors;

/*
프로그래머스 - 2018 KAKAO BLIND RECRUITMENT - [3차] 파일명 정렬 : https://programmers.co.kr/learn/courses/30/lessons/17686
 */
public class Problem_27 {
    public static void main(String[] args) {
        String[] arr = {"img12.png", "img10.png", "img02.png", "img1.png", "IMG01.GIF", "img2.JPG"};
        System.out.println(solution(arr));
    }

    public static List<String> solution(String[] files) {
        ArrayList<File> list = new ArrayList<>();
        for (String fileName : files) {
            int headIdx = findHeadIdx(fileName);
            String head = fileName.substring(0, headIdx);
            int numberIdx = findNumberIdx(fileName, headIdx);
            String number = fileName.substring(headIdx, numberIdx);
            String tail = fileName.substring(numberIdx);
            list.add(new File(head, number, tail, fileName));
        }
        list.sort((f1, f2) -> { // 세번째 조건은 이미 들어온 순서임
            if(f1.head.equalsIgnoreCase(f2.head)) { // 두번째 조건
                return Integer.parseInt(f1.number) - Integer.parseInt(f2.number);
            } else { // 첫번째 조건
                return f1.head.toUpperCase().compareTo(f2.head.toUpperCase());
            }
        });
        return list.stream().map(file -> file.fileName).collect(Collectors.toList());
    }

    static int findHeadIdx(String s) {
        int ret = 0;
        for(int i=0; i<s.length(); i++) {
            if(s.charAt(i) >= '0' && s.charAt(i) <= '9')
                return i;
        }
        return ret;
    }

    static int findNumberIdx(String s, int start) {
        int ret = s.length();
        for(int i=start; i<s.length(); i++) {
            if(s.charAt(i) < '0' || s.charAt(i) > '9')
                return i;
        }
        return ret;
    }
}

class File {
    String head;
    String number;
    String tail;
    String fileName;

    public File(String head, String number, String tail, String fileName) {
        this.head = head;
        this.number = number;
        this.tail = tail;
        this.fileName = fileName;
    }

    @Override
    public String toString() {
        return "File{" +
                ", head='" + head + '\'' +
                ", number='" + number + '\'' +
                ", tail='" + tail + '\'' +
                ", fileName='" + fileName + '\'' +
                '}';
    }
}