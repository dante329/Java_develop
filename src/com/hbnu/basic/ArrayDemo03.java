package com.hbnu.basic;

import java.util.Scanner;

/**
 * 键盘录入数据,要求数据是六位的整数，现需要对数据进行加密
 * 加密规则如下：
 *   每位数字都加上5,然后除以10的余数代替该数字,再将第一位和第六位交
 *   换,第二位和第五位交换,第三位和第四位交换,请把加密后的数据输出到
 *   控制台
 *
 * @author kittychen
 * @Date 2026-09-03 11:25
 */
public class ArrayDemo03 {
    public static void main(String[] args) {
        // 1、创建键盘输入对象
        Scanner scanner = new Scanner(System.in);

        System.out.println("请输入一个6位整数：");
        // 2、获取键盘输入的位整数
        int numbers = scanner.nextInt();

        // 3、获取6位数的每一位数，并存入数组
        int[] num_array = new int[6];
        // num_array[0] = numbers / 100000;
        // num_array[1] = numbers / 10000 % 10;
        // num_array[2] = numbers / 1000 % 10;
        // num_array[3] = numbers / 100 % 10;
        // num_array[4] = numbers / 10 % 10;
        // num_array[5] = numbers % 10;
        for (int i = 0; i < num_array.length; i++) {
            num_array[i] = (int) (numbers / Math.pow(10, num_array.length - 1 - i) % 10);
        }

        // 4、开始加密
        for (int i = 0; i < num_array.length; i++) {
            num_array[i] += 5;
            num_array[i] %= 10;
        }

        // 5、交换位置
        int temp = 0;
        for (int i = 0; i < num_array.length / 2; i++) {
            temp = num_array[i];
            num_array[i] = num_array[num_array.length - 1 - i];
            num_array[num_array.length - 1 - i] = temp;
        }

        // 6、输出加密后的数
        System.out.println("加密后的数据：");
        for (int i = 0; i < num_array.length; i++) {
            System.out.print(num_array[i]);
        }
    }
}
