package com.ohgiraffers.section01.exception;

public class ExceptionTest {

    public void checkEnougMoney(int price, int money) throws Exception {

        System.out.println("가지고 계신 돈은 " + money + "원 입니다.");

        if (money >= price) {
            System.out.println("상품을 구입하기 위한 금액이 충분합니다.");
        } else {
            System.out.println("상품을 구입하기 위한 금액이 부족합니다.");
        }
//        System.out.println("즐거운 쇼핑 하세요~~");
        throw  new Exception(); // 예외발생구문 이하 구문은 동작하지 않고 종료된다.
    }
}
