package com.hbnu.exception;

import java.util.Scanner;

public class ExceptionDemo {
    public static void main(String[] args) {
        //try-catch-finally演示
        //调用Scanner手动输入
//        Scanner sc = new Scanner(System.in);
//        System.out.println("请输入除数与被除数（两个整数）：");
//        System.out.println("结果为：" + divide(sc.nextInt(),sc.nextInt()));
        //写好两个数直接执行
        divide(100,50); //可以把第二个数改为0来演示异常

        //throw && throws 演示
        try {
            checkAge(15);
        }catch (IllegalArgumentException e) {
            e.printStackTrace();
        }

        //自定义异常
        int age = 16;
        if(age < 18) {
            throw new AgeException("未成年禁止访问");
        }
    }

    /**
     * 继承Exception就是受检异常；继承RuntimeException就是非受检异常，也称运行时异常。
     * 🌟真正区别：受检异常就是编译器会在编译时对异常做检查，必须在编译前要么try-catch捕获要么方法throws抛出；
     * 非受检异常就是编译器不检查，就算不捕获不在方法上写throws编译都可以通过，但是程序运行的时候异常就会抛出来，如果代码没有提前if判断避免这个异常或者提前写好捕获代码（if是提前判断，try-catch是事后兜底），就会异常退出程序。
     * 抛出之后的传播逻辑完全一样；差别只在编译期是否强制校验。
     * 补充：throws是给编译器做检查用的，故RuntimeException不需要写throws，因为编译器根本不检查它。
     *
     * 更深去理解：受检异常之所以受检，是因为单纯靠代码中的if判断无法完全规避出错的风险，所有Java要求编写者在编译前必须处理这个异常：try-catch或者throws。例如IOException。
     * 业务逻辑上：if判断处理预期内业务错误，try-catch捕获意料之外的故障。
     *
     * 🌟🌟🌟Q：为什么catch捕获异常之后不会使程序终止？
     * A：异常本质是一个中断信号，它顺着调用栈往上跑，如果跑到JVM那，JVM收到未捕获异常会执行操作：打印堆栈，终止程序。
     * 但是我们在代码中一般不会放任异常不管，异常一旦被catch成功捕获，异常向上传播的链条就断掉了，于是经过try-catch结构的努力，异常不会使程序终止，而是在执行完try-catch的代码后继续执行完剩余代码。
     */
    static class AgeException extends RuntimeException {
        public AgeException(String msg) {
            super(msg); //调用父类的构造方法
        }
    }

    /**
     * 用checkAge方法演示throws和throw的用法：
     * 1. throws：写在方法声明后（不能在类的定义上写），只是声明可能抛出异常，不捕获异常，是把异常交给调用者处理，多个异常逗号隔开。
     * 2. throw：写在方法内部，手动创建并抛出一个异常对象 throw new IllegalArgumentException("年龄小于18");
     * throw和return具有相似性：
     * return：正常返回，方法正常结束，给调用方返回结果。
     * throw：抛出异常，方法异常终止，向外抛出异常对象，需要捕获或者 throws 声明。
     * return的类型写在函数头中的返回值上；throw的异常类型写在函数头的throws后面。
     *
     * 🌟重要：对于异常，要么try-catch捕获；要么方法签名throws抛出，交给上层调用者处理，但是如果main方法上写了throws，异常不被main方法捕获，直接抛给JVM。JVM收到未捕获异常，直接打印堆栈，程序崩溃终止。
     */
    public static void checkAge(int age) throws IllegalArgumentException { //实际上throws IllegalArgumentException可以不写，因为IllegalArgumentException是非受检异常
        if(age < 18) {
            throw new IllegalArgumentException("年龄不足18岁");
        }
        System.out.println("年龄合法");
    }

    /**
     * 用divide方法演示try-catch-finally结构，注意事项：
     * 多个catch顺序：先小异常，后大异常
     * finally里面写return会覆盖try/catch里面的return，并且会吃掉异常信息（异常直接丢失，不会向外抛出），开发中禁止这么写
     * Q1:try-catch-finally必须同时出现吗？A:不是，它们可以组合。规则：try不能单独出现，它后面必须跟catch或finally或catch+finally
     * Q2:try-catch-resource是什么，怎么用？A:首先resource不是关键字，用法：放在try(...)括号里声明的资源对象，编译器会自动补全finally以及对应写在finally中的close代码，
     * 无论是正常结束还是异常，都会自动调用资源的close，无需手动释放资源。
     * Q2注意：try()小括号里可以写多个资源，用分号隔开；资源类必须实现AutoCloseable（例如FileReader）；小括号里定义的变量只能在try大括号里使用，catch和finally中访问不到；资源创建本身也会抛出异常，这个异常同样也可以被后面的catch捕获
     */
    public static int divide(int a, int b) {
        try {
            int ret = a / b;
//            System.exit(0); //System.exit(0);可以在try或者catch的{}内执行，执行之后就无法进入finally
            return ret;
        } catch (ArithmeticException e) {
            e.printStackTrace(); //打印完整堆栈（类名 + 消息 + 出错行号）
//            System.out.println(e); //调用e.toString()，返回“异常类名:消息”，需要手动打印
//            System.out.println(e.getMessage()); //只获取异常描述字符串，不打印堆栈
            return -1;
        } finally {
            System.out.println("finally执行"); //finally一定会执行，除非有System.exit ()的调用
//            return 115154; //会覆盖try和catch中return的值，不要这么写
        }
    }
}
