package com.hbnu.classobject;

interface Playable {
    void play();
}

class Guitar implements Playable {
    public void play() {
        System.out.println("吉他声");
    }
}

class Piano implements Playable {
    public void play() {
        System.out.println("钢琴声");
    }
}

public class Practice01 {
    public static void main(String[] args) {
        Playable playable1 = new Guitar();
        Playable playable2 = new Piano();
        playable1.play();
        playable2.play();
    }
}
