package com.hbnu.basic;

import java.util.Scanner;

public class ArrayDemo01 {
    public static void main(String[] args) {
        //1、创建键盘输入对象
        Scanner scanner = new Scanner(System.in);
        //2、创建数组，用于存储键盘输入的数据
        int[] nums = new int[5];
        //3、获取键盘输入的数据，并存入数组
        for(int i=0;i<nums.length;i++){
            nums[i] = scanner.nextInt();
        }
        //4、遍历数组，并将数组元素输出到控制台
        for (int num : nums) {
            System.out.println(num);
        }
    }
}