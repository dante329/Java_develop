package com.hbnu.commonclasses;

//演示Object类中的常见方法：equals、hashCode、toString、getClass

import java.util.Objects;

class Person {
    private String name;
    private int age;

    public Person(String name, int age) {
        this.age = age;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    //可用ctrl+enter快捷键选中toString自动重写
    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    //重写equals和hashCode
    @Override
    public boolean equals(Object o) {
        //如果o是空指针或者o的类型和本类的类型不一样返回false
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        //Objects.equals是Objects类中的静态方法，另外还可以写this.name.equals(person.name);，因为String类的equals重写过了，可用来进行值比较
        return age == person.age && Objects.equals(name, person.name);
    }

    //hashCode没重写前仅有一条声明：public native int hashCode();没有方法体。
    //native关键字表示：这个方法的方法声明写在 Java 里，但是方法体不是用 Java 写的，是 C/C++ 写的，放在 JVM 底层，看不到实现代码。
    @Override
    public int hashCode() {
        //Object.hash()是Object类的静态方法，接收多个属性，自动合并计算哈希值，专门用来简化重写 hashCode
        return Objects.hash(name, age);
    }
}

public class PersonDemo {
    public static void main(String[] args) {
        Person person1 = new Person("张三", 18);
        Person person2 = new Person("张三", 18);

        /**
         * toString()：返回对象的字符串描述
         * 默认实现是：类名@十六进制哈希码，此处为com.hbnu.commonclasses.Person@5f184fc6，可读性差
         * 可以手动重写，使其返回想要的内容
         * System.out.println(对象名);会自动调用toString()，没必要显式写对象名.toString()
         */
        System.out.println(person1);

        /**
         * equals(对象)默认比较两个对象的地址，等价于==，因为在重写前equals底层的实现就是==
         * 如果想完成值比较，就要重写equals
         * 约定：重写equals，必须重写hashCode，因为Java 约定：如果a.equals(b) == true，那么a.hashCode()必须等于b.hashCode()
         * 如果重写 equals 但不改 hashCode，上面这条规则就被破坏，HashMap 等集合会出 bug。
         * 注意：两个对象 equals 相等 → 它们的 hashCode 必须相等；hashCode 相等，对象不一定 equals 相等（哈希碰撞）
         */

        System.out.println(person1 == person2); // false，==比较地址，person1和person2是两个不同对象
        System.out.println(person1.equals(person2)); // true，值比较
        System.out.println(person1.hashCode());
        System.out.println(person2.hashCode()); // 两个hashCode相同

        /**
         * getClass()：返回运行时对象的 Class 类型对象，是反射的入口。
         * 反射：在程序运行期间，动态获取类的信息、操作属性/方法
         * getClass() 是 Object 类中定义的 final 实例方法
         * 返回的是运行时真实类型，不是引用变量的类型。
         */

        Person person = new Person("浩弟",15);
        /**
         * Class是一个普通的Java类 源码：public final class Class<T> {// 里面存放一个类的全部元信息：类名、方法、成员变量、构造器}
         * Class<?> clazz：表示clazz是Class类的实例对象，叫做类模版对象，用来记录类本身的信息。
         * <?>是泛型通配符，表示这个Class可以是任意类型的类，但不确定具体是什么类，就写Class<?>
         * Class<?> clazz = p.getClass(); clazz描述Person这个类本身，保存 Person 的类名、有哪些成员变量、有哪些方法、构造器等元信息。
         */
        Class<?> clazz = person.getClass();
        System.out.println(clazz.getName());
        System.out.println(clazz.getSimpleName());

        /**
         * finalize() 过时，了解即可
         * 作用：对象被 GC 垃圾回收之前，JVM 会调用这个方法，用来释放资源
         * 缺点：什么时候执行不确定，不保证一定会执行，容易内存泄漏
         * Java9 标记废弃，现在不推荐使用，资源释放改用try-with-resources。
         */

    }
}