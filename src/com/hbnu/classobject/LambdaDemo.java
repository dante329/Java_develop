package com.hbnu.classobject;

/**
 * lambda表达式：简化“函数式接口”的匿名内部类写法。
 * 函数式接口：有且只有一个抽象方法的接口，可以加注解 @FunctionalInterface 校验。
 * lambada表达式使用的限制：只能用于函数式接口（即接口中只能有一个抽象方法）。
 * Lambda不是匿名内部类，底层机制不一样。匿名内部类会生成独立 class 文件；Lambda 不一定生成新类。
 *
 * 语法：(参数列表) -> {方法体}
 * ():放抽象方法的形参，只有一个参数时，()可以省略
 * ->:箭头符号，固定写法
 * {}:放方法体代码：只有一行代码时，{}可以省略；
 *
 * TODO:演示三种Lambda表达式的使用方法
 */

//演示1:无参函数式接口
@FunctionalInterface
interface Runnable {
    void run();
}

//演示2:带参数、有返回值的函数式接口
@FunctionalInterface
interface Calc {
    int sum(int a, int b);
}

//演示3:用于演示lambda表达式作为参数传给函数
@FunctionalInterface
interface DEVICE {
    void work(String name);
}

public class LambdaDemo {
    //将lambda作为方法参数传入（多态）
    public static void keyboardPlugIn(DEVICE device) {
        device.work("键盘");
    }

    public static void main(String[] args) {
        //匿名内部类写法
        Runnable r1 = new Runnable() {
            @Override
            public void run() {
                System.out.println("匿名内部类：线程执行");
            }
        };
        r1.run(); //创建完r1后要调用run()才能执行重写方法

        //Lambda简化写法
        Runnable r2 = () -> System.out.println("Lambda：线程执行");
        r2.run();
        /**
         * 注意比较Lambda表达式与匿名内部类写法的不同点在哪
         * Lambda表达式不需要写new关键字以及类名，而是用一个“() ->”代替
         * ，同时public void run()这样需要唯一重写的的方法头也省略了，而是用{函数体}代替，直接写在“->”后面
         */


        //带参数、有返回值的Lambda表达式
        Calc calc = (a,b) -> a + b;
        int res = calc.sum(10,20);
        System.out.println(res);

        //如果方法体多行，必须写 {} + return
        Calc calc2 = (a,b) -> {
            System.out.println("计算");
            return a + b;
        };
        System.out.println(calc2.sum(5,6));

        //方法参数传入Lambda，代替匿名内部类
        keyboardPlugIn((deviceName) -> System.out.println(deviceName + "开始工作"));
    }
}
