package com.jito.solved.programmers.level_2_test;

import java.util.*;

/**
 * 문제 설명
 * 0 또는 양의 정수가 주어졌을 때, 정수를 이어 붙여 만들 수 있는 가장 큰 수를 알아내 주세요.
 *
 * 예를 들어, 주어진 정수가 [6, 10, 2]라면 [6102, 6210, 1062, 1026, 2610, 2106]를 만들 수 있고, 이중 가장 큰 수는 6210입니다.
 *
 * 0 또는 양의 정수가 담긴 배열 numbers가 매개변수로 주어질 때, 순서를 재배치하여 만들 수 있는 가장 큰 수를 문자열로 바꾸어 return 하도록 solution 함수를 작성해주세요.
 *
 * 제한 사항
 * numbers의 길이는 1 이상 100,000 이하입니다.
 * numbers의 원소는 0 이상 1,000 이하입니다.
 * 정답이 너무 클 수 있으니 문자열로 바꾸어 return 합니다.
 */
public class LargestNumber {
    public String solution(int[] numbers) {
        String[] arr = new String[numbers.length];
        for(int i=0; i<numbers.length; i++) {
            arr[i] = String.valueOf(numbers[i]);
        }

        // Comparable 인터페이스를 구현(익명 구현 객체를 통해 구현)해서 o1, o2를 + 해주고 더 큰 문자열을 return 해주는 식으로 정렬을함
        // a, b 순서로 있을 때 (b+a).compareTo(a+b) 을 했을 경우 'b+a'가 더 크다면 자리를 바꿔줌 // 내림차순으로 정렬함
        Arrays.sort(arr, (s1, s2) -> (s2 + s1).compareTo(s1 + s2));
//        Arrays.sort(arr, new Comparator<String>() {
//            @Override
//            public int compare(String s1, String s2) {
//                return ((s2+s1).compareTo(s1+s2));
//            }
//        });

        if(arr[0].equals("0")) return "0";
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<arr.length; i++) {
            sb.append(arr[i]);
        }
        return sb.toString();
    }
    public static void main(String[] args) {
        LargestNumber ln = new LargestNumber();
        int numbers[] = {3, 30, 34, 5, 9};
        System.out.println(ln.solution(numbers));
    }
}
