package com.jito.solved.kakao.mobility;

import java.util.*;

/*
문제 설명
소셜 미디어 상에서 친구일 가능성이 가장 높은 유저를 친구로 추천하는 기능을 만들려 합니다. 이때, 친구가 아닌 유저 중 mutual friend1가 많을수록 친구일 가능성이 높다고 봅니다.

예를 들어, 친구 관계가 다음과 같다면

david와 frank가 친구
demi와 david가 친구
frank와 james가 친구
demi와 james가 친구
claire와 frank가 친구
david와 james의 mutual friend는 2명(frank와 demi)
david와 claire의 mutual friend는 1명(frank)
이므로 david와 친구일 가능성이 가장 높은 유저는 james입니다. ( 이미 david와 친구인 frank와 demi는 추천 대상이 아닙니다 )

소셜 미디어 상에서 친구 관계를 담은 리스트 friends와 친구 추천 대상의 아이디 user_id가 주어질 때, 누구를 친구로 추천해야 하는지 구하는 함수, solution을 완성해주세요.

제한 사항
friends는 길이가 10,000 이하인 리스트입니다.
friends의 원소는 [x, y] 형태이며, 이는 아이디가 x인 유저와 아이디가 y인 유저가 소셜 미디어 상에서 친구라는 뜻입니다.
x와 y는 길이가 1 이상 20 이하인 소문자 문자열입니다.
동일한 친구관계가 중복해서 주어지지 않습니다.
user_id는 길이가 1 이상 20 이하인 소문자 문자열입니다.
친구가 없는 유저는 없습니다.
따라서 friends에서 적어도 한 번은 나오는 아이디가 user_id로 주어집니다.
모든 유저 아이디는 알파벳 소문자로만 이루어져 있습니다.
친구일 가능성이 가장 높은 유저가 여럿일 경우, 유저의 id를 오름차 순으로 정렬해 리턴합니다.
mutual friend가 한 명도 없는 경우는 주어지지 않습니다.
입출력 예
friends	user_id	return
[[david,frank], [demi, david], [frank, james], [demi, james], [claire, frank]]	david	[james]
[[david,demi], [frank, demi], [demi, james]]	frank	[david, james]
입출력 예 설명
입출력 예 #1
앞서 설명한 예시와 같습니다.

입출력 예 #2

frank와 david의 mutual friend는 1명(demi)
frank와 james의 mutual friend는 1명(demi)
따라서 이 경우에는 david와 james를 모두 추천해야 합니다.

서로 친구가 아닌 두 이용자와 동시에 친구인 다른 이용자가 있을 때, 이 이용자를 mutual friend라고 합니다. 예를 들어, A와 B가 친구이고 B와 C가 친구이지만, C와 A는 친구가 아닐 때 B는 A와 C의 mutual friend입니다. ↩
 */
public class Problem_02 {
    public static void main(String[] args) {
//        String[][] s = {{"david","frank"}, {"demi", "david"}, {"frank", "james"}, {"demi", "james"}, {"claire", "frank"}}; // [james]
//        String user_id = "david";
        String[][] friends2 = {{"david", "demi"}, {"frank", "demi"}, {"demi", "james"}};
        String user_id2 = "frank";
        System.out.println(solution(friends2, user_id2));
    }

    public static int[] dist; // 거리 저장 배열
    public static ArrayList<ArrayList<Integer>> graph = new ArrayList<>(); // 그래프
    public static ArrayList<String> solution(String[][] friends, String user_id) {
        HashSet<String> set = new HashSet<>(); // 중복 제거용 셋
        for (String[] s : friends) {
            set.add(s[0]);
            set.add(s[1]);
        }
        ArrayList<String> list = new ArrayList<>(set); // 유저를 그래프 형식 으로 연결 하기 위한 기초 리스트
        HashMap<String, Integer> map = new HashMap<>(); // 유저 별 인덱스 값을 저장함
        dist = new int[list.size()];
        for(int i=0; i<list.size(); i++) {
            graph.add(new ArrayList<>());
            map.put(list.get(i), i);
        }
        for (String[] f : friends) {
            int a = map.get(f[0]);
            int b = map.get(f[1]);
            graph.get(a).add(b);
            graph.get(b).add(a);
        }
        bfs(map.get(user_id));
        HashMap<String,Integer> map2 = new HashMap<>(); // 유저 별 연결 된 간선의 갯수를 저장함
        ArrayList<String> result = new ArrayList<>(); // 가장 많이 연결된 유저만 넣어줄 결과 값 리스트
        int max = 0;
        for(int i=0; i<dist.length; i++) {
            if(dist[i] == 2) {
                for(int j = 0; j < graph.get(i).size(); j++) {
                    int next = graph.get(i).get(j);
                    String key = getKey(map,next);
                    map2.put(key, map2.getOrDefault(key,0)+1);
                    map2.put(user_id, 0);
                    if(max < map2.get(key)) {
                        max = map2.get(key);
                        result = new ArrayList<>();
                        result.add(key);
                    } else if(max == map2.get(key)) {
                        result.add(key);
                    } else {
                        result = new ArrayList<>();
                        result.add(key);
                    }
                }
            }
        }
        Collections.sort(result);
        result.remove(user_id); // 자기 자신은 빼줌
        return result;
    }

    public static void bfs(int start) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(start);
        dist[start] = 1;
        while(!q.isEmpty()) {
            int now = q.poll();
            if(dist[now] > 1) continue;
            for(int i = 0; i < graph.get(now).size(); i++) {
                int next = graph.get(now).get(i);
                if(dist[next] != 0) continue;
                q.offer(next);
                dist[next] = dist[now]+1;
            }
        }
    }

    public static String getKey(HashMap<String, Integer> m, int value) {
        for(String s: m.keySet()) {
            if(m.get(s).equals(value))
                return s;
        }
        return null;
    }
}
