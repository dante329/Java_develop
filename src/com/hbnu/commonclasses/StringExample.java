package com.hbnu.commonclasses;

/**
 * 1. String
 *    - 内容不可变，每次拼接都会新建对象
 *    - 频繁拼接大量字符串，性能差，产生很多垃圾对象
 *    - 适合：字符串很少修改的场景
 * 2. StringBuilder
 *    - 内容可变，在原数组上直接修改，不大量新建对象
 *    - 线程不安全，多线程并发会出问题
 *    - 速度最快，单线程频繁拼接首选
 * 3. StringBuffer
 *    - 内容可变
 *    - 线程安全：方法加了`synchronized`锁，多线程不会乱
 *    - 加锁带来开销，速度比 StringBuilder 慢
 *    - 适合：多线程环境字符串拼接
 */

public class StringExample {
    public static void main(String[] args) {
        // ========== String 演示 ==========
        String str = "Hello, World!";
        System.out.println("字符串长度length()：" + str.length()); //13

        // charAt：按索引取字符，索引从0开始
        char c = str.charAt(0);
        System.out.println("charAt(0)第一个字符：" + c); //H

        // substring(start, end) 左闭右开
        String sub = str.substring(0,5);
        System.out.println("substring(0,5)截取：" + sub); //Hello

        // indexOf 查找子串位置
        int idx = str.indexOf("World");
        System.out.println("World的起始索引："+idx); //7

        // replace替换
        String newStr = str.replace("World","Java");
        System.out.println("replace替换："+newStr); //Hello, Java!
        System.out.println("原字符串str："+str); //原字符串不变！体现不可变性

        // equals 比较内容 vs ==比较地址
        String s1 = "abc";
        String s2 = "abc";
        String s3 = new String("abc");
        System.out.println("s1==s2："+(s1==s2)); //true，常量池复用
        System.out.println("s1==s3："+(s1==s3)); //false，s3是堆中新对象
        System.out.println("s1.equals(s3)："+s1.equals(s3)); //true，比较内容

        //split使用
        String str1 = "Hello,Java,World";
        String[] arr1 = str1.split(","); //按逗号切割
        //增强for遍历
        for(String s : arr1){
            System.out.println(s);
        }
        String str2 = "www.baidu.com";
        String[] arr2 = str2.split("\\."); //注意split的第一个参数是正则表达式，"."在正则表达式里表示任意字符，要在前面加\\转义
        for(String s : arr2){
            System.out.println(s);
        }
        String str3 = "1-2-3-4-5";
        String[] arr3 = str3.split("-",3); //第二个参数限制最多切几段
        for(String s : arr3){
            System.out.println(s);
        }

        System.out.println("===== StringBuilder 可变字符串 =====");
        // ========== StringBuilder：可变字符串，线程不安全，速度快（单线程首选） ==========
        StringBuilder sb = new StringBuilder("Hello");
        sb.append(" ");    //追加，直接修改自身，不产生新对象
        sb.append("Java");
        System.out.println("StringBuilder拼接结果："+sb);
        sb.replace(0,5,"Hi"); //替换
        System.out.println("替换后："+sb);

        //转成String
        String res = sb.toString();
        System.out.println("转为String："+res);

        System.out.println("===== StringBuffer 演示 =====");
        // ========== StringBuffer：可变字符串，线程安全，速度慢（多线程用） ==========
        StringBuffer sbf = new StringBuffer("Hello");
        sbf.append(" Buffer");
        System.out.println("StringBuffer拼接："+sbf);
    }
}
