package com.hbnu.basic;

import java.util.Random;
import java.util.Scanner;

public class GuessNum {
    public static void main(String[] args) {
        Random random = new Random();
        Scanner scanner = new Scanner(System.in);
        int num = random.nextInt(100)+1;
        int count;
        char choice;
        do {
            count = 10;
            while(count > 0)
            {
                System.out.println("你有"+count+"次机会\n请输入猜测的数字：");
                int tmp = scanner.nextInt();
                count--;
                if(tmp > num) System.out.println("猜大了");
                else if(tmp < num) System.out.println("猜小了");
                else {
                    System.out.println("猜对了！！");
                    break;
                }
            }
            if(count == 0) System.out.println("机会耗尽！");
            System.out.println("还要再尝试一次吗？(Y/N)");
            choice = scanner.next().charAt(0);
        }while(choice=='Y');
        System.out.println("游戏结束！");
    }
}
