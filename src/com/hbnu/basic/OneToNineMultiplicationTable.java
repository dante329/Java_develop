package com.hbnu.basic;

public class OneToNineMultiplicationTable {
    public static void main(String[] args) {
        for (int i = 1; i <= 9; i++) {
            for (int j = 1; j <= 9; j++) {
                if(i>j) continue;
                System.out.print(i+"*"+j+"="+(i*j)+'\t');
            }
            System.out.println();
        }
    }
}
