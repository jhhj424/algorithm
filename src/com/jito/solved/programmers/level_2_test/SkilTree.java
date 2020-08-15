package com.jito.solved.programmers.level_2_test;

import java.util.*;

public class SkilTree {
    public int solution(String skill, String[] skill_trees) {
        int answer = 0;
        String[] advanceSkill = skill.split(""); // 선행스킬트리 배열

        // 유저들이 만든 스킬트리 배열 반복
        for(int i=0; i<skill_trees.length; i++) {
            boolean flag = true;

            // 선행 스킬트리 배열 반복
            for(int j=1; j<advanceSkill.length; j++) {

                // 선행스킬은 없는데 후행스킬트리가 있는경우
                if(skill_trees[i].indexOf(advanceSkill[j-1]) == -1 && skill_trees[i].indexOf(advanceSkill[j]) != -1) {
                    flag = false;
                }

                // 후행스킬이 있을때 선행스킬보다 후행스킬이 더 앞에있는경우
                if(skill_trees[i].indexOf(advanceSkill[j-1]) > skill_trees[i].indexOf(advanceSkill[j]) && skill_trees[i].indexOf(advanceSkill[j]) != -1) {
                    flag = false;
                }
            }
            if(flag) {
                System.out.println(skill_trees[i]);
                answer++;
            }
        }
        return answer;
    }
    public int solution2(String skill, String[] skill_trees) {
        int answer = 0;
        ArrayList<String> skillTrees = new ArrayList<>(Arrays.asList(skill_trees));
        Iterator<String> it = skillTrees.iterator();

        // skilTrees가 있으면 반복
        while (it.hasNext()) {
            // skilTrees 요소에서 replaceAll + 정규표현식을 사용하여 skill에 포함된 문자가 아니면 "" 로변환
            // 변환한 문자가 skill에 있는지 확인 그리고 순서대로인지 확인하기위해서 0번째 인덱스가 아니면 해당 list 요소는 삭제처리
            if (skill.indexOf(it.next().replaceAll("[^" + skill + "]", "")) != 0) {
                it.remove();
            }
        }
        answer = skillTrees.size();
        return answer;
    }
    public static void main(String[] args) {
        SkilTree st = new SkilTree();
        String s = "CBD";
        String arr[] = {"BACDE", "CBADF", "AECB", "BDA"};
        System.out.println(st.solution(s, arr));
        System.out.println(st.solution2(s, arr));
    }
}
