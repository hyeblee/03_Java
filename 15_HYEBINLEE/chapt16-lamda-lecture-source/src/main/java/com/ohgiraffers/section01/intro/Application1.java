package com.ohgiraffers.section01.intro;

public class Application1 {
  public static void main(String[] args) {
    /*
    * 람다식에서 매개변수의 타입은 추론이 가능하기 때문에 명시적으로 작성하지 않아도 된다.
    * 또한 매개변수가 한개만 존재한느 경우 ()를 생략할 수도 있으며,
    * 실행문이 한 줄인 경우 {}는 생략 가능하다.
    * */

    Calculator c1 = new CalculatorImpl();
    System.out.println(c1.sumTwoNumbers(10,20));

    // 2. 익명클래스를 활용하여 메소드 재정의 후 사용하는 방법
    Calculator c2 = new Calculator() {
      @Override
      public int sumTwoNumbers(int a, int b) {
        return a + b;
      }
    };
    System.out.println(c2.sumTwoNumbers(10,20));

    Calculator c3 = (x,y)->x+y;
    System.out.println(c3.sumTwoNumbers(10,20));
  }
}
