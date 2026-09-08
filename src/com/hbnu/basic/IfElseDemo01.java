package com.hbnu.basic;

import java.util.Scanner;

public class IfElseDemo01 {
    public static void main(String[] args) {
        int height;
        long wealth;
//        String outlook = new String(""); //字符串不好判断
        boolean handsome;

        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入身高：");
        height = scanner.nextInt();

        System.out.println("请输入存款：");
        wealth = scanner.nextLong();

        System.out.println("请输入长相：");
        handsome = scanner.nextBoolean();

        if(height > 180 && wealth > 10000000 && handsome){
            System.out.println("我一定要嫁给他！！！");
        } else if(height > 180 || wealth > 10000000 || handsome) {
            System.out.println("嫁吧");
        } else {
            System.out.println("不嫁");
        }
    }
}
