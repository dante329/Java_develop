package com.hbnu.basic;

import java.util.Scanner;

public class WhichDay {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int year,month,day;
        System.out.println("请输入年月日:(XXXX XX XX)");
        year = scanner.nextInt();
        month = scanner.nextInt();
        day = scanner.nextInt();

        int[] monthDays = {31,28,31,30,31,30,31,31,30,31,30,31};
        //判断闰年
        boolean isLeapYear;
        if(year % 400 == 0 || year % 4 == 0 && year % 100 != 0) {
            monthDays[1] += 1;
        }
        int ret = 0;
        for (int i = 0; i < month-1; i++) {
            ret += monthDays[i];
        }
        ret += day;

        System.out.println("当前日期是一年中第"+ret+"天");
    }
}
