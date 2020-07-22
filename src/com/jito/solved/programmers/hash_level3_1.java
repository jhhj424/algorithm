package com.jito.solved.programmers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

/**
 문제 설명
 스트리밍 사이트에서 장르 별로 가장 많이 재생된 노래를 두 개씩 모아 베스트 앨범을 출시하려 합니다. 노래는 고유 번호로 구분하며, 노래를 수록하는 기준은 다음과 같습니다.

 속한 노래가 많이 재생된 장르를 먼저 수록합니다.
 장르 내에서 많이 재생된 노래를 먼저 수록합니다.
 장르 내에서 재생 횟수가 같은 노래 중에서는 고유 번호가 낮은 노래를 먼저 수록합니다.
 노래의 장르를 나타내는 문자열 배열 genres와 노래별 재생 횟수를 나타내는 정수 배열 plays가 주어질 때, 베스트 앨범에 들어갈 노래의 고유 번호를 순서대로 return 하도록 solution 함수를 완성하세요.

 제한사항
 genres[i]는 고유번호가 i인 노래의 장르입니다.
 plays[i]는 고유번호가 i인 노래가 재생된 횟수입니다.
 genres와 plays의 길이는 같으며, 이는 1 이상 10,000 이하입니다.
 장르 종류는 100개 미만입니다.
 장르에 속한 곡이 하나라면, 하나의 곡만 선택합니다.
 모든 장르는 재생된 횟수가 다릅니다.

 ...풀이중...
 */
public class hash_level3_1 {

    public static int[] solution(String[] genres, int[] plays) {
        HashMap<String, Integer> bestMap1 = new HashMap<>();
        HashMap<String, Integer> bestMap2 = new HashMap<>();
        for(int i=0; i<genres.length;i++) {
            if(!bestMap1.containsKey(genres[i])) { // 베스트앨범1에 해당 장르의 곡이 없을때
                bestMap1.put(genres[i], plays[i]); // 1에 넣어줌
            }else { // 베스트앨범1에 해당 장르의 곡이 있을때
                if(!bestMap2.containsKey(genres[i])){ // 베스트앨범2에 해당 장르의 곡이 없을때
                    if(bestMap1.get(genres[i]) >= plays[i]){
                        bestMap2.put(genres[i], plays[i]); // 2에 넣어줌
                    }else { // 재생수가 더 클때
                        bestMap2.put(genres[i], bestMap1.get(genres[i])); // 2로 옮겨줌
                        bestMap1.put(genres[i], plays[i]); // 1에는 더 큰 값을 넣어줌
                    }
                }else {  // 베스트앨범2에 해당 장르의 곡이 있을때
                    if(bestMap2.get(genres[i]) < plays[i]) {
                        bestMap2.put(genres[i], plays[i]); // 2에 넣어줌
                        if(bestMap1.get(genres[i]) < bestMap2.get(genres[i]) ) {
                            bestMap2.put(genres[i], bestMap1.get(genres[i])); // 2로 옮겨줌
                            bestMap1.put(genres[i], plays[i]); // 1에는 더 큰 값을 넣어줌
                        }
                    } else {
                        continue;
                    }

                }
            }
        } // 장르,재생횟수 쌍의 베스트앨범 맵 2개가 만들어짐
        HashMap<String, Integer> cntMap = new HashMap<>(); // 장르별 총 재생횟수를 가진 해시맵
        HashMap<Integer, String> genresMap = new HashMap<>(); // 총 재생횟수별 장르를 가진 해시맵
        for(String s: bestMap1.keySet()) {
            cntMap.put(s,bestMap1.get(s)+bestMap2.getOrDefault(s,0));
            genresMap.put(bestMap1.get(s)+bestMap2.getOrDefault(s,0),s);
        }
        List<Integer> cntList = new ArrayList<>();
        for(String s: cntMap.keySet()) {
            cntList.add(cntMap.get(s));
        }
        Collections.sort(cntList);//오름차순정렬
        Collections.reverse(cntList);//뒤집기

        List<Integer> playCnt = new ArrayList<>();
        for(Integer i: cntList) {
            // 재생횟수가 많은 장르부터 1,2번 순서로 꺼냄
            playCnt.add(bestMap1.get(genresMap.get(i)));
            if(bestMap2.get(genresMap.get(i)) == null) {
                continue;
            }
            playCnt.add(bestMap2.getOrDefault(genresMap.get(i),0));
        }
        int[] answer = new int[playCnt.size()];
        int index = 0;
        for(Integer playsCnt : playCnt) {
            for(int i=0; i<plays.length;i++) {
                if(plays[i] == playsCnt) {
                    answer[index] = i;
                    index++;
                }
            }
        }


        return answer;
    }

    public static void main(String[] args) {
        String[]genres = {"classic", "pop", "pop", "pop", "pop"};
        int[]plays = {6, 1, 8, 2, 9};
        for(int i: solution(genres, plays)) {
            System.out.println(i);
        }
    }
}
