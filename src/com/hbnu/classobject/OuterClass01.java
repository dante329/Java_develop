package com.hbnu.classobject;

public class OuterClass01 {
    private String username;
    private String address;

    OuterClass01(String username) {
        this.username = username;
    }

    public void method1() {
        System.out.println("外部类方法");
    }

    public class InnerClass {
        private String gender;
        private String username;

        InnerClass(String username) {
            this.username = username;
        }

        public void method2() {
            String username = "Daven";
            System.out.println("内部类访问外部类私有属性：" + address);
            System.out.println("内部类访问内部类同名局部属性" + username);
            System.out.println("内部类访问内部类同名成员属性" + this.username);
            System.out.println("内部类访问外部类同名私有属性：" + OuterClass01.this.username);
            method1(); //内部类访问外部类的方法
        }
    }

    public static void main(String[] args) {
        // InnerClass inner = new InnerClass(); // 不能直接创建内部类对象，内部类对象的创建依赖外部类
        OuterClass01 outerClass = new OuterClass01("张三");
        InnerClass innerClass = outerClass.new InnerClass("李四");
        System.out.println("外部类访问内部类私有属性" + innerClass.gender);
        innerClass.method2();
    }
}
