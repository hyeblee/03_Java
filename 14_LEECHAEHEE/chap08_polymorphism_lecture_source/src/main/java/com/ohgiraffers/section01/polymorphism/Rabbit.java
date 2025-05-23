package com.ohgiraffers.section01.polymorphism;

public class Rabbit extends Animal {
    @Override
    public void eat() {
        System.out.println("토끼가 풀을 뜯어먹고 있다");
    }

    @Override
    public void run() {
        System.out.println("토끼가 달려간당");
    }

    @Override
    public void cry() {
        System.out.println("토끼가 울음소리를 냅니다. 끼익~ 끼익");
    }

    public void jump() {
        System.out.println("토끼가 점프합니다. 쩜프!");
    }
}
