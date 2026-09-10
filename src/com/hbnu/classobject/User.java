package com.hbnu.classobject;

public class User {
    String name;
    public User(String name){
        this.name = name;
    }
    public void method(){
//        String name = "张三"; //局部变量，生命周期随方法调用结束而结束
        name = "张三"; //修改的是类对象中的成员变量
        System.out.println(this.name);
    }

    public static void main(String[] args) {
        User u1 = new User("李四");
        u1.method();
    }

}