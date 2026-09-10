package com.hbnu.classobject;

public class Car {
    private String brand;
    private String color;
    private double speed;

    //快捷键：ctrl+enter --> getter and setter
    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public double getSpeed() {
        return speed;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }

    public Car(String brand, String color, double speed) {

    }

    public void speedUp() {
    }

    public void speedDown() {
    }

}
