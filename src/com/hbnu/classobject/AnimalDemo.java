package com.hbnu.classobject;

/**
 * 多态：同一个行为，不通对象有不同实现；
 * 父类引用指向子类对象，调用方法时执行的是子类重写后的代码
 * 三个重要前提：1.有继承关系 2.有方法重写 3.有向上转型
 */

class Animal {
    public void shout(){
        System.out.println("动物叫");
    }
}

class Dog extends Animal{
    @Override
    public void shout(){
        System.out.println("汪汪汪");
    }
}

class Cat extends Animal{
    @Override
    public void shout(){
        System.out.println("喵喵喵");
    }
}

public class AnimalDemo {
    //多态的好处

    //1.代码通用性强
    //形参写父类Animal，所有Animal子类都可以传入，体现多态通用性
    public static void makeShout(Animal animal){
        animal.shout();
    }
    //2.易扩展：新增子类（比如 Bird），原有makeShout()代码完全不用改动 → 符合开闭原则
    //3.解耦：使用者只关心父类接口，不用关心子类具体实现

    //多态局限性：父类引用不能直接调用子类独有的方法！

    public static void main(String[] args) {
        // 多态写法：父类引用指向子类对象
        Animal a1 = new Dog();
        Animal a2 = new Cat();

        a1.shout(); //运行：汪汪汪 （运行看右边，执行子类Dog的shout）
        a2.shout(); //运行：喵喵喵（运行看右边，执行子类Cat的shout）

        //调用makeSpeak传入子类
        makeShout(new Dog());
        makeShout(new Cat());
        makeShout(new Animal()); //Animal本身的对象也可以传

    }
}