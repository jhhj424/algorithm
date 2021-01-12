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
public class Problem_05 {

    public static void main(String[] args) {
        String[][] friends = {{"david","frank"}, {"demi", "david"}, {"frank", "james"}, {"demi", "james"}, {"claire", "frank"}}; // [james]
        String user_id = "david";

        String[][] friends2 = {{"david", "demi"}, {"frank", "demi"}, {"demi", "james"}}; // [david, james]
        String user_id2 = "frank";
        String[] solution = solution(friends, user_id);
        System.out.println(Arrays.toString(solution));
    }

    public static String[] solution(String[][] friends, String user_id) {
        Map<String, FriendInfo> friendInfoMap = new HashMap<>();
        for (String[] friendRelation : friends) {
            for (String name : friendRelation) {
                if (!friendInfoMap.containsKey(name))
                    friendInfoMap.put(name, new FriendInfo());
            }
            friendInfoMap.get(friendRelation[0]).insertFriend(friendRelation[1]);
            friendInfoMap.get(friendRelation[1]).insertFriend(friendRelation[0]);
        }

        FriendInfo targetFriendInfo = friendInfoMap.get(user_id);
        for (String friend : targetFriendInfo.directFriends) {
            FriendInfo directFriendInfo = friendInfoMap.get(friend);
            Set<String> mutualFriendsOfTarget = directFriendInfo.directFriends;
            for (String mutualFriendName : mutualFriendsOfTarget) {
                if (!mutualFriendName.equals(user_id) && !targetFriendInfo.directFriends.contains(mutualFriendName)) {
                    targetFriendInfo.insertMutualFriend(mutualFriendName);
                }
            }
        }

        List<String> keySetList = new ArrayList<>(targetFriendInfo.mutualFriends.keySet());

        Collections.sort(keySetList, Comparator.comparing(o -> targetFriendInfo.mutualFriends.get(o)));

        TreeSet<String> maxMutualFriend = new TreeSet<>();
        Integer mutualCount = null;
        for (String key : targetFriendInfo.mutualFriends.keySet()) {
            if (mutualCount == null)
                mutualCount = targetFriendInfo.mutualFriends.get(key);
            if (targetFriendInfo.mutualFriends.get(key) == mutualCount)
                maxMutualFriend.add(key);
        }

        return maxMutualFriend.toArray(new String[maxMutualFriend.size()]);
    }

    static class FriendInfo {
        Set<String> directFriends = new HashSet<>();
        HashMap<String, Integer> mutualFriends = new HashMap<>();
        public void insertFriend(String friendName) {
            directFriends.add(friendName);
        }

        public void insertMutualFriend(String friendName) {
            mutualFriends.put(friendName, mutualFriends.getOrDefault(friendName,0) + 1);
        }
    }
}
