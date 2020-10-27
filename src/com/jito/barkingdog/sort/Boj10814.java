package com.jito.barkingdog.sort;

import java.util.*;

/*
    나이순 정렬 : 정렬 : https://www.acmicpc.net/problem/10814
 */
public class Boj10814 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        ArrayList<People> list = new ArrayList<>();
        for(int i=0; i<n; i++) {
            int age = sc.nextInt();
            String name = sc.next();
            list.add(new People(age, name, i));
        }

        list.sort((p1, p2) -> {
            if(p1.age == p2.age) {
                return p1.regist - p2.regist;
            }
            return p1.age - p2.age;
        });

        for (People people : list) {
            System.out.println(people.age + " " + people.name);
        }
    }
}
class People {
    int age;
    String name;
    int regist;

    public People(int age, String name, int regist) {
        this.age = age;
        this.name = name;
        this.regist = regist;
    }

    @Override
    public String toString() {
        return "People{" +
                "age=" + age +
                ", name='" + name + '\'' +
                ", regist=" + regist +
                '}';
    }
}