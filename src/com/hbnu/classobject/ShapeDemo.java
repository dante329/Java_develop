package com.hbnu.classobject;

//抽象类实例

//所有图形都有 求面积 这个能力，但不同图形计算逻辑不一样。
//抽象类Shape：规定所有子类必须实现getArea()求面积，还设置一个打印面积的公共方法，不强制要求子类重写
abstract class Shape { //用abstract修饰的类叫抽象类，抽象类不一定有抽象方法
    public abstract double getArea(); //用abstract修饰的方法叫抽象方法，有抽象方法的类一定是抽象类

    //普通实例方法
    public void showArea(){
        System.out.println("图形面积 = " + getArea());
    }
}
// 子类：圆形，继承抽象类Shape
class Circle extends Shape {
    private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    @Override
    public double getArea() {
        return Math.PI * radius * radius;
    }
}

// 子类：矩形，继承抽象类Shape
class Rectangle extends Shape {
    private double width;
    private double height;

    public Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }

    @Override
    public double getArea() {
        return width * height;
    }
}

// 测试主类，演示多态
public class ShapeDemo {
    // 形参写抽象类Shape，所有Shape子类都能传进来
    public static void printShapeInfo(Shape shape) {
        shape.showArea();
    }

    public static void main(String[] args) {
        // 多态：抽象类引用指向子类对象
        Shape c = new Circle(5.2);
        Shape r = new Rectangle(50,20);
        printShapeInfo(c);
        printShapeInfo(r);

        // Shape s = new Shape();  // ❌ 抽象类不能直接new
    }
}