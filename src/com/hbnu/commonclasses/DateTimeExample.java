package com.hbnu.commonclasses;

import java.time.*;
import java.time.format.DateTimeFormatter;

public class DateTimeExample {
    public static void main(String[] args) {
        //1. 获取当前 日期+时间
        LocalDateTime now = LocalDateTime.now();
        System.out.println("当前时间：" + now);

        //2. 创建格式化器，定义格式模板
        DateTimeFormatter f = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        //格式化：时间对象 → 字符串
        String timeStr = now.format(f);
        System.out.println("格式化输出：" + timeStr);

        //其他常用API演示
        LocalDate date = LocalDate.now(); //仅日期
        System.out.println("当前日期：" + date);
        LocalTime time = LocalTime.now(); //仅时间
        System.out.println("当前时间：" + time);

        //时间加减（重点：返回新对象，原对象不变，且不可变）
        LocalDateTime nextDay = now.plusDays(1); //加1天
        LocalDateTime lastHour = now.minusHours(2); //减2小时
        System.out.println("明天此时：" + nextDay.format(f));
        System.out.println("2小时前：" + lastHour.format(f));

        //字符串 解析成 LocalDateTime
        String str = "2026-09-21 10:30:00";
        LocalDateTime parseTime = LocalDateTime.parse(str,f);
        System.out.println("字符串转时间对象："+parseTime);
    }
}
