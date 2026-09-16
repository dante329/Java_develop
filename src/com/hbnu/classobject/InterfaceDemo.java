package com.hbnu.classobject;

import java.security.Key;

/**
 * interface 定义接口，代表行为规范
 * java8以前：接口里面只能有抽象方法、常量，没有普通方法、成员变量
 * 重要🌟java8：添加default默认方法（实例方法，要用default关键字）、static静态方法（属于接口本身，只能用“接口名.方法名()”调用）；它们都是有方法体的。
 * 类用 implements 实现接口、一个类可以同时实现多个接口（弥补java单继承的短板）
 * 接口不能new，实现类必须重写接口里面全部抽象方法
 * 接口和接口之间可以多继承
 *
 * 设计思想：接口描述能力（能做什么），体现“has-a”或“can-do”关系，侧重行为规范，不关心是谁。
 * 比如USB设备，不管是鼠标、键盘、U盘，都要实现work()
 */

// 接口：USB规范，规定必须实现work方法
interface USB {
    //接口变量默认修饰符为public static final，不用谢
    int MAX = 100; //等价于 public static final int MAX = 100;
    //抽象方法，默认public abstract，不用写
    void work();
    //default方法（需要用实现类的对象调用）
    default void check() {
        System.out.println("检查成功");
    }
}

// 鼠标实现USB interface
class Mouse implements USB {
    @Override
    public void work() {
        System.out.println("鼠标：光标移动");
    }
}

// 键盘实现USB interface
class Keyboard implements USB {
    public void work() {
        System.out.println("键盘：输入文字");
    }
}

// U盘实现USB interface
class UDisk implements USB {
    @Override
    public void work() {
        System.out.println("U盘：读写数据");
    }
}

public class InterfaceDemo {
    // 形参写接口类型，传入实现类对象时，自动发生向上转型（接口引用指向实现类实例）
    // ，在方法内部调用接口的实例方法，触发动态绑定，从而实现多态。
    public static void plugIn(USB usbDevice) {
        usbDevice.work();
    }

    public static void main(String[] args) {
        plugIn(new Mouse());
        plugIn(new Keyboard());
        plugIn(new UDisk());

        // USB usb = new USB(); // ❌ 接口不能直接实例化

        Mouse mouse = new Mouse();
        mouse.check(); //用实现类Mouse创建的对象调用接口中的default函数
    }
}
