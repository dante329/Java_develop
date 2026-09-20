package com.hbnu.practice.topic02;

interface NetworkConnectable {
    void connectNetwork();
}

abstract class SmartDevice {
    private String deviceName;
    private boolean isPowerOn;
    //抽象父类可以有自己的构造方法，子类在调用自己的构造方法时，可以显式地用super调用父类的构造方法，这并不意味着创建了父类的对象
    //构造方法的权限修饰符：希望在任意包能都能调用用public；默认default只能在此包内调用
    SmartDevice(String deviceName) {
        this.deviceName = deviceName;
    }

    //getter && setter
    public String getDeviceName() {
        return deviceName;
    }

    public void setDeviceName(String deviceName) {
        this.deviceName = deviceName;
    }

    public boolean isPowerOn() {
        return isPowerOn;
    }

    public void setPowerOn(boolean powerOn) {
        isPowerOn = powerOn;
    }

    //公共方法
    public void powerSwitch() {
        this.isPowerOn = !this.isPowerOn; //每次取反（注意boolean类型取反用!）
        if(this.isPowerOn) System.out.println(this.deviceName + "设备已开机");
        else System.out.println(this.deviceName + "设备已关机");
    }

    public abstract void work();
}

class SmartTV extends SmartDevice implements NetworkConnectable {
    SmartTV(String deviceName) {
        super(deviceName);
    }

    @Override
    public void work() {
//        System.out.println(SmartDevice.this.deviceName + "：正在播放高清视频");  类名.this 这个语法，只用于内部类，用来指代外部类对象。
        System.out.println(getDeviceName() + "：正在播放高清视频"); //父类的deviceName是private的，要通过get方法来获取
        //如果要使用的父类成员变量是public的，直接写父类的成员变量名即可，如果子类中定义了与父类相同的成员变量名，要使用super.变量名
    }

    @Override
    public void connectNetwork() {
        System.out.println(getDeviceName() + "：已连接5G Wi-Fi");
    }
}

class SmartLight extends SmartDevice implements NetworkConnectable {
    SmartLight(String deviceName) {
        super(deviceName);
    }

    @Override
    public void work() {
        System.out.println(getDeviceName() + "：正在调节灯光颜色");
    }

    @Override
    public void connectNetwork() {
        System.out.println(getDeviceName() + "：已连接蓝牙网关");
    }
}

public class DeviceTest {
    public static void main(String[] args) {
        SmartDevice[] smartDevices = new SmartDevice[2];
        smartDevices[0] = new SmartTV("客厅大屏电视");
        smartDevices[1] = new SmartLight("卧室氛围灯");

        for (SmartDevice smartDevice : smartDevices) {
            smartDevice.powerSwitch();
            if(smartDevice instanceof NetworkConnectable) {
                //向下转型：父类引用指向更具体的子类型/子接口
                NetworkConnectable nc = (NetworkConnectable) smartDevice;
                nc.connectNetwork();
            }
            smartDevice.work();
        }
    }
}
