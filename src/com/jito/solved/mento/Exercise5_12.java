package com.jito.solved.mento;

import java.util.Scanner;

public class Exercise5_12 {
    public static void main(String[] args) {
        String[][] words = {
                {"chair","의자"},
                {"computer","컴퓨터"},
                {"integer","정수"}
        };
        int score = 0;
        Scanner scanner = new Scanner(System.in);
        for(int i=0;i<words.length;i++) {
            System.out.printf("Q%d. %s의 뜻은? \n",i+1,words[i][0]);
            String tmp = scanner.nextLine();
            if(tmp.equals(words[i][1])) {
                System.out.printf("정답입니다.\n\n");
                score++;
            } else {
                System.out.printf("틀렸습니다. 정답은 %s입니다.\n\n",words[i][1]);
            }
        }
        System.out.printf("전체 %d문제 중 %d문제 맞추셨습니다. %n", words.length, score);
    }
}

