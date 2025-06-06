package com.ohgiraffers.section01.level01.basic;

import java.util.Scanner;

public class Application2 {

    public static void main(String[] args) {

        /* 길이가 5인 String 배열을 선언하고
         * "딸기", "바나나", "복숭아", "키위", "사과" 로 초기화를 하고
         * 스캐너로 0부터 4까지의 정수를 입력 받아
         * 해당 정수의 인덱스에 있는 과일을 출력하세요
         *
         * 단, 배열의 인덱스 범위를 벗어나는 경우 "준비된 과일이 없습니다." 를 출력하세요
         *
         * -- 입력 예시 --
         * 0부터 4까지의 정수를 입력하세요 : 2
         *
         * -- 출력 예시 --
         * 복숭아
         *
         * -- 입력 예시 --
         * 0부터 4까지의 정수를 입력하세요 : 5
         *
         * -- 출력 예시 --
         * 준비된 과일이 없습니다.
         * */

        String[] sArr = new String[5];
        sArr[0] = "딸기";
        sArr[1] = "바나나";
        sArr[2] = "복숭아";
        sArr[3] = "키위";
        sArr[4] = "사과";

        Scanner sc = new Scanner(System.in);
        System.out.println("0부터 4까지의 정수를 입력하세요 : ");

        int num = sc.nextInt();

        switch (num) {
            case 1:
                System.out.println(sArr[0]);
                break;
                case 2:
                    System.out.println(sArr[1]);
                    break;
                    case 3:
                        System.out.println(sArr[2]);
                        break;
                        case 4:
                            System.out.println(sArr[3]);
                            break;
                            case 5:
                                System.out.println(sArr[4]);
                                break;
                                default:
                                    System.out.println("준비된 과일이 없습니다.");
                                    break;
        }
    }
}
