package com.hbnu.commonclasses;

/**
 * Java有8个基本数据类型，它们不是对象，没有方法
 * 包装类就是基本类型对应的类，包装类可以实现把基本类型的值包装成一个对象
 *
 * 核心作用：1. 基本类型不是对象，不能放进集合（ArrayList、HashMap）
 * ArrayList<int> list; // 报错！不能放int基本类型
 * ArrayList<Integer> list; // 可以，Integer是包装类（对象）
 * 2. 包装类是对象，可以调用方法
 * 基本类型 int num = 10 ，只是一个数字，没有任何方法。Integer num = 10 是对象，可以调用包装类自带静态方法：
 * Integer.parseInt("123"); //字符串转int，返回时是int，可以用一个int变量接收
 * Integer.toString(100);  //数字转字符串
 * Integer.MAX_VALUE;       //获取int最大值常量
 * 3. 可以存 null
 * Integer a = null; // 合法
 * int b = null;     // 编译报错
 *
 * 语法糖：自动装箱 和 自动拆箱
 * 编译器帮你自动转换，代码写起来简化，底层依然会执行转换。
 * 1. 自动装箱：基本类型 → 包装类
 * Integer num1 = 10; //编译器底层自动帮你写成：Integer num1 = Integer.valueOf(10);
 * 2. 自动拆箱：包装类 → 基本类型
 * int num2 = num1; //编译器底层自动帮你写成：int num2 = num1.intValue();
 *
 * Integer.valueOf() 会缓存 -128 ~ 127 的数字。
 * 在这个区间内，Integer对象复用同一个地址
 */

public class WrapperExample {
    public static void main(String[] args) {
        //1. 自动装箱：基本类型 → 包装类对象
        // 底层：Integer num1 = Integer.valueOf(10);
        Integer num1 = 10;
        Double d1 = 3.14;
        Character ch1 = 'A';
        Boolean bool1 = true;

        System.out.println("自动装箱后Integer对象：" + num1);

        //2. 自动拆箱：包装类对象 → 基本类型
        // 底层：int num2 = num1.intValue();
        int num2 = num1;
        double d2 = d1;
        char c2 = ch1;
        boolean bool2 = bool1;
        System.out.println("自动拆箱得到int值：" + num2);

        System.out.println("------------------------");

        //3. 重点：集合只能放包装类，不能放基本类型
        // ArrayList<int> listErr; // 编译报错！泛型必须是引用类型
        java.util.ArrayList<Integer> list = new java.util.ArrayList<>();
        list.add(100); // 自动装箱，把int 100转成Integer对象存入集合
        list.add(200);
        int val = list.get(0); // 自动拆箱，取出Integer转为int
        System.out.println("集合取出的值：" + val);

        System.out.println("------------------------");

        //4. 包装类可以存null（基本类型不能null）
        Integer data = null;
        // int data2 = null; // 直接编译报错！基本类型不能为null
        System.out.println("包装类赋值null演示：" + data);
        // 注意：如果data是null，下面拆箱会抛出空指针异常
        // int test = data; // NullPointerException

        System.out.println("------------------------");

        //Integer缓存池 -128 ~ 127
        Integer a1 = 100;
        Integer a2 = 100;
        System.out.println("a1=100,a2=100，a1 == a2 ? " + (a1 == a2)); // true，复用缓存对象

        Integer b1 = 200;
        Integer b2 = 200;
        System.out.println("b1=200,b2=200，b1 == b2 ? " + (b1 == b2)); // false，超出缓存，新建对象

        // 比较数值用equals
        System.out.println("b1.equals(b2) ? " + b1.equals(b2)); // true，比较里面的数字

        System.out.println("------------------------");

        //6. 包装类工具方法：字符串转数字
        String numStr = "666";
        int parseInt = Integer.parseInt(numStr); // String转int
        double parseDouble = Double.parseDouble("99.9");
        System.out.println("字符串转int结果：" + parseInt);
    }
}
