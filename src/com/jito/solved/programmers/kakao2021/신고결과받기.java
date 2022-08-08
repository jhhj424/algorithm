package com.jito.solved.programmers.kakao2021;


import java.util.*;

/*
* id_list	report	k	result
["muzi", "frodo", "apeach", "neo"]	["muzi frodo","apeach frodo","frodo neo","muzi neo","apeach muzi"]	2	[2,1,1,0]
["con", "ryan"]	["ryan con", "ryan con", "ryan con", "ryan con"]	3	[0,0]
* */
public class 신고결과받기 {


    public static void main(String[] args) {
        String[] idList = {"con", "ryan"};
        String[] report = {"ryan con", "ryan con", "ryan con", "ryan con"};
        int k = 3;

        System.out.println("solution(idList, report, k) = " + solution(idList, report, k));


        String[] idList2 = {"muzi", "frodo", "apeach", "neo"};
        String[] report2 = {"muzi frodo", "apeach frodo", "frodo neo", "muzi neo", "apeach muzi"};
        int k2 = 2;

        System.out.println("solution(idList, report, k) = " + solution(idList2, report2, k2));
    }


    public static List<Integer> solution(String[] id_list, String[] report, int k) {
        ArrayList<Integer> answer = new ArrayList<>();

        Map<String, Set> userMap = new HashMap<>();
        Map<String, Set<String>> idListMap = new HashMap<>();
        for (String id : id_list) {
            idListMap.put(id, new HashSet<>());
            userMap.put(id, new HashSet());
        }

        // map 에 매핑하기
        for (String r : report) {
            String[] s = r.split(" ");
            String a = s[0]; // 신고자
            String b = s[1]; // 신고 당한자

            // 신고 한 유저 map
            idListMap.get(a).add(b);

            // 신고 횟수 map
            userMap.get(b).add(a);
        }

        // map 중에 value 의 size 가 k 이상인 경우 key 값은 신고 된 사용자
        ArrayList<String> users = new ArrayList<>();
        for (String key : userMap.keySet()) {
            if (userMap.get(key).size() >= k) {
                users.add(key);
            }
        }

        for (String id : id_list) {
            int count = 0;
            for (String targetUser : idListMap.get(id)) {
                if (users.contains(targetUser)) {
                    count++;
                }
            }

            answer.add(count);
        }

        return answer;
    }
}
