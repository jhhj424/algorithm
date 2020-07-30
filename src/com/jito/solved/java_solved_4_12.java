package com.jito.solved;
257c8cd3d70a152f499d9e85e05674912db0ac9b
/*
* 구구단 출력문제
* 정답포맷 :
2*1=2	3*1=3	4*1=4
2*2=4	3*2=6	4*2=8
2*3=6	3*3=9	4*3=12

5*1=5	6*1=6	7*1=7
5*2=10	6*2=12	7*2=14
5*3=15	6*3=18	7*3=21

8*1=8	9*1=9
8*2=16	9*2=18
8*3=24	9*3=27

* */
public class java_solved_4_12 {
    public static void main(String[] args) {
//        for(int i=2; i < 9;i+=3){
//            for(int j=1; j < 4; j++){
//                for(int k=0;k<3;k++){
//                    if(i+k < 10){
//                        System.out.print(i+k+"*"+j+"="+((i+k)*j)+"\t");
//                    }
//                }
//                System.out.println();
//            }
//            System.out.println();
//        }

        for(int i=2; i<10; i=i+3) {
            for(int j=1; j<4; j++) {
                System.out.print(i+"*"+j+"="+i*j+"\t");
                if(i+1<10) {
                    System.out.print(i+1+"*"+j+"="+i+1*j+"\t");
                }
                if(i+2<10) {
                    System.out.print(i+2+"*"+j+"="+i+2*j+"\t");
                }
                System.out.println();
            }
            System.out.println();
        }
    }
}
