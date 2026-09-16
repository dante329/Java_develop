package com.hbnu.classobject;

public class Outerclass02 {
    private String name;
    private String address;

    public void method() {
        String hobby = "吃烤肉";
        System.out.println("外部类成员方法");
        //局部内部类不能使用修饰词
        class InnerClass {
            private String gender;
            private int age;

            public void method2() {
                System.out.println("局部内部类访问外部类成员变量：" + name);
                System.out.println("局部内部类访问自己的成员变量：" + gender);
                System.out.println("局部内部类访问所在方法的局部变量：" + hobby);
            }
        }

        //局部内部类先定义，后使用
        InnerClass innerClass = new InnerClass();
        System.out.println("外部类在其成员方法中通过局部内部类的实例化对象访问局部内部类的成员变量" + innerClass.gender);
    }

}
