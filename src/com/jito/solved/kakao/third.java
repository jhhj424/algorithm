package com.jito.solved.kakao;

import java.util.*;

public class third {
    public static void main(String[] args) {
        String info[] = {"java backend junior pizza 150","python frontend senior chicken 210","python frontend senior chicken 150","cpp backend senior pizza 260","java backend junior chicken 80","python backend senior chicken 50"};
        String query[] = {"java and backend and junior and pizza 100","python and frontend and senior and chicken 200","cpp and - and senior and pizza 250","- and backend and senior and - 150","- and - and - and chicken 100","- and - and - and - 150"};
        System.out.println(Arrays.toString(solution(info,query)));
    }
    static ArrayList<developer> dlist = new ArrayList<>();
    static ArrayList<query> qlist = new ArrayList<>();
    public static int[] solution(String[] info, String[] query) {
        int[] answer = new int[query.length];
        for(int i=0; i<info.length; i++) {
            String[] s = info[i].split(" ");
            dlist.add(new developer(s[0],s[1],s[2],s[3],s[4]));
        }
        for(int i=0; i<query.length; i++) {
            String[] s = new String[5];
            String[] q = query[i].split(" and ");
            String[] a = q[3].split(" ");
            s[0] = q[0];
            s[1] = q[1];
            s[2] = q[2];
            s[3] = a[0];
            s[4] = a[1];
            qlist.add(new query(s[0],s[1],s[2],s[3],s[4]));
        }
        int cnt = 0;
        int index = 0;
        dlist.sort(Comparator.comparingInt(o -> -o.score));
        for(query q: qlist) {
            for(developer d: dlist) {
                if((d.score>=q.score)) {
                    if((d.lan.equals(q.lan) || q.lan.equals("-"))
                            && (d.job.equals(q.job) || q.job.equals("-"))
                            && (d.career.equals(q.career) || q.career.equals("-"))
                            && (d.food.equals(q.food) || q.food.equals("-"))){
                        cnt++;
                    }
                }else {
                    break;
                }
            }
            answer[index++] = cnt;
            cnt = 0;
        }
        return answer;
    }
}
class developer{
    String lan;
    String job;
    String career;
    String food;
    int score;

    developer(String lan, String job, String career, String food, String score) {
        this.lan = lan;
        this.job = job;
        this.career = career;
        this.food = food;
        this.score = Integer.parseInt(score);
    }
}
class query{
    String lan;
    String job;
    String career;
    String food;
    int score;

    query(String lan, String job, String career, String food, String score) {
        this.lan = lan;
        this.job = job;
        this.career = career;
        this.food = food;
        this.score = Integer.parseInt(score);
    }
}
