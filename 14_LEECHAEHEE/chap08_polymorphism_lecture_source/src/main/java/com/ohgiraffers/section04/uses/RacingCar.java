package com.ohgiraffers.section04.uses;

public class RacingCar extends Car {
    @Override
    public void go() {
        System.out.println("레이싱카가 달려갑니다. 개빠름");
    }

    @Override
    public void stop() {
        System.out.println("레이싱카가 멈춥니다. 끼이이익");
    }
}
