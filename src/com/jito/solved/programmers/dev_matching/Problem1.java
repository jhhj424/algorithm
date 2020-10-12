package com.jito.solved.programmers.dev_matching;

/*
문제 설명
12시간 단위로 표시되는 시계가 있습니다. 오전일 경우 AM , 오후일 경우 PM으로 표시되며, 시간은 시:분:초로 표시됩니다.
예를 들어, 오전 11시 27분 35초일 경우 AM 11:27:35 로 표시가 되며, 오후 8시 20분 4초일 경우 PM 08:20:04 로 표시가 됩니다.
이제부터, 우리는 시계에 표시된 시간에서 N초 후의 시간을 구하려고 합니다.
단, N초 후의 시간 표시를 12시간 단위에서 24시간 단위 표시로 변경하려고 합니다.
24시간 단위로 표시되므로 오전과 오후를 나타내는 AM, PM과 같은 문자열은 표시되지 않으며, 시:분:초만 표시됩니다.

예를 들어,

12시간 단위 시계로 표시된 PM 01:00:00 에서 10초 후의 시간을 24시간 단위 표시로 변경하면 13:00:10 로 표시하게 됩니다.
12시간 단위 시계로 표시된 PM 11:59:59 에서 1초 후의 시간을 24시간 단위 표시로 변경하면 00:00:00 로 표시하게 됩니다.
12시간 단위로 표시된 현재 시각 P와 N이 매개변수로 주어졌을 때, N초 후의 시간 표시를 24시간 단위 표시로 변경하는 solution 함수를 완성해 주세요. 단, 변경된 시각을 return 할 때는 string형으로 return 해주세요.

제한사항
현재 시각 P는 string형으로 주어집니다. 오전과 오후는 각각 문자열 AM, PM으로 표시하고, 시간은 12시간 단위로 표시되며, :를 기준으로 시, 분, 초를 나눠 시:분:초로 표시됩니다. 시, 분, 초는 각각 두자리 숫자로 이루어져 있으며, 24시간 단위 표시로 변환한 결과도 각각 두자리 숫자여야 합니다. 한자리 숫자일 경우, 앞에 0을 붙이면 됩니다. (ex. 오후 5시 5분 5초를 12시간 단위로 표시하면 PM 5:5:5가 아닌 PM 05:05:05로 표시되며, 24시간 단위로 표시하면 17:05:05로 표시됩니다.)
AM 12:01:00은 24시간 단위 표시로 00:01:00 입니다.
PM 12:01:00은 24시간 단위 표시로 12:01:00 입니다.
N은 200,000 이하인 자연수입니다.
입출력 예
P	N	answer
PM 01:00:00	10	13:00:10
PM 11:59:59	1	00:00:00
입출력 예 설명
입출력 예 #1, 2
문제의 예시와 같습니다.
 */

public class Problem1 {
    public static void main(String[] args) {
        String p = "AM 12:59:59";
        int n = 1;
        for(int i=1; i<100; i++) {
            System.out.println(solution(p,n * i));
        }
    }

    public static String solution(String p, int n) {
        String ap = p.substring(0, 2); // 오전, 오후
        int t = Integer.parseInt(p.substring(3, 5)); // 시
        int m = Integer.parseInt(p.substring(6, 8)); // 분
        int s = Integer.parseInt(p.substring(9)); // 초
        int time = 0;
        if(ap.equals("PM")) {
            time += 12 * 3600;
        }
        else {
            if(t == 12)
                t = 0;
        }
        time += t * 3600;
        time += m * 60;
        time += s;

        time += n;
        StringBuilder sb = new StringBuilder();
        String str = time/3600+"";
        if((time/3600) > 24) {
            str = time/3600%24 + "";
        }
        if(str.length()==1) {
            sb.append(0);
        }
        if(str.equals("24")) {
            str = "00";
        }
        sb.append(str).append(":");
        time %= 3600;
        str = time/60 + "";
        if(str.length()==1) {
            sb.append(0);
        }
        sb.append(str).append(":");
        time %= 60;
        str = time + "";
        if(str.length()==1) {
            sb.append(0);
        }
        sb.append(time);
        return sb.toString();
    }
}
