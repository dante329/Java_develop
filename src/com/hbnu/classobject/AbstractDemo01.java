package com.hbnu.classobject;

abstract class Tool {
    void show() {}
}

public class AbstractDemo01 {
    //匿名类
    public static void main(String[] args) {
        Tool tool = new Tool() {
            public void show() { //Q：为什么这里的方法必须要写public？A：抽象类的方法默认是public abstract，子类在重写父类的方法时，不能缩小权限，故必须写public
                System.out.println("锤子");
            }
        };
        tool.show();
    }
}
