package com.ohgiraffers.section02.problem2;

public class Application {
    public static void main(String[] args) {
        Monster monster = new Monster();
//        monster.name = "드라큘라";
//        monster.hp = 200;
//
//        System.out.println("monster2의 이름 : " + monster.name);
//        System.out.println("monster2의 체력 : " + monster.hp);

        monster.setInfo1("프랑켄슈타인");
        monster.setInfo2(200);

        System.out.println(monster.kinds);
    }
}
