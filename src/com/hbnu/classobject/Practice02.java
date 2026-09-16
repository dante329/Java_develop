package com.hbnu.classobject;

class Car_ {
    private String brand;
    Car_(String brand) {
        this.brand = brand;
    }

    class Engine {
        public void start() {
            System.out.println("汽车品牌为：" + brand);
            System.out.println("发动机启动");
        }
    }

    public void startCar() {
        Engine engine = new Engine();
        engine.start();
    }
}

public class Practice02 {
    public static void main(String[] args) {
        Car_ car = new Car_("Benz");
        car.startCar();
    }
}
