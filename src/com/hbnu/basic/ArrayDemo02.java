package com.hbnu.basic;

import java.util.Scanner;

/**
 * 在练习1输入数据的基础上，对数组进行升序排序，并输出排序后的结果。
 * <p>
 * 代码格式化快捷键：ctrl + alt + l
 *
 * @author kittychen
 * @Date 2026-09-03 10:52
 */
public class ArrayDemo02 {
    public static void main(String[] args) {
        // 1、创建键盘输入对象
        Scanner scanner = new Scanner(System.in);

        // 2、创建数组，用于存储键盘输入的数据
        int[] nums = new int[5];

        System.out.println("请输入5个整型数据：");
        // 3、获取键盘输入的数据，并存入数组，普通for循环，快捷键：fori + 回车
        for (int i = 0; i < nums.length; i++) {
            nums[i] = scanner.nextInt();
        }

        // 4、遍历数组，并将数组元素输出到控制台
        System.out.println("排序前数组元素：");
        for (int i = 0; i < nums.length; i++) {
            if (i == nums.length - 1) { // 表示遍历到数组最后一个元素
                System.out.println(nums[i]);  // 最后一个元素后面不加空格
                break;   // 结束循环
            }
            System.out.print(nums[i] + "  ");
        }

        // 5、开始对数组元素进行排序，采用冒泡排序
        int temp = 0;
        for (int i = nums.length - 1; i >= 0; i--) {
            for (int j = 0; j < i; j++) {
                if (nums[j] > nums[j + 1]) {
                    temp = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = temp;
                }
            }

        }

        // 6、排序后的数组
        System.out.println("排序后数组元素：");
        for (int i = 0; i < nums.length; i++) {
            if (i == nums.length - 1) { // 表示遍历到数组最后一个元素
                System.out.println(nums[i]);  // 最后一个元素后面不加空格
                break;   // 结束循环
            }
            System.out.print(nums[i] + "  ");
        }
    }
}
