package com.hbnu.classobject;

/**
 * 匿名类：即匿名内部类，没有类名的局部内部类，一次性使用，
 * 定义类的同时直接创建对象，用完就丢，不能重复 new
 * 适用场景：继承抽象类或实现接口时，只需要用这个子类/实现类一次，不想单独写一个.java文件或者单独的class
 * 限制：匿名类不能写构造方法（匿名类没有名字，而构造方法必须和类名一致）
 *
 * 两种写法：实现接口/继承抽象类（也可以继承抽象类）
 *
 * 匿名类访问规则：
 * 1. 匿名类属于局部内部类，写在方法/代码块里面，访问方法里的局部变量要求是有效final
 * 2. 可以访问外部类所有成员（包括私有）
 * 3. 匿名类里面可以定义新增方法，但是外部调用不到
 */

//实现1：匿名类实现接口
interface Play {
    void game();
}

//实现2：匿名类继承抽象类
abstract class Fruit {
    //抽象方法
    public abstract void taste();

    //普通实例方法
    public void info() {
        System.out.println("这是水果");
    }
}

public class AnonymousClassDemo {
    public static void main(String[] args) {
        //实现1：匿名类实现接口
        Play playCellPhone = new Play() {
            @Override
            public void game() {
                System.out.println("玩原神");
            }
        };

        //调用重写方法，实现多态
        playCellPhone.game();

        //实现2：匿名类继承抽象类
        Fruit apple = new Fruit() {
            @Override
            public void taste() {
                System.out.println("苹果吃着爽啊");
            }
        };

        apple.info(); //调用父类中的普通实例方法（实例方法就是非静态方法）
        apple.taste(); //调用匿名类重写父类的方法，实现多态
    }
}
