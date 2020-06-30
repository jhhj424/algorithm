package com.jito.solved;

public class java_solved_4_12 {
    public static void main(String[] args) {
        for(int i=2; i < 9;i+=3){
            for(int j=1; j < 4; j++){
                for(int k=0;k<3;k++){
                    if(i+k < 10){
                        System.out.print(i+k+"*"+j+"="+((i+k)*j)+"\t");
                    }
                }
                System.out.println();
            }
            System.out.println();
        }
    }
}
