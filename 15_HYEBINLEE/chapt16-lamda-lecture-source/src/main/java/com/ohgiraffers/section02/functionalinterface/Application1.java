package com.ohgiraffers.section02.functionalinterface;

import java.time.LocalTime;
import java.util.Random;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.IntConsumer;
import java.util.function.ObjIntConsumer;

public class Application1 {

  public static void main(String[] args) {
    /* JDK 8에서 빈번하게 사용되는 함수적 인터페이스를 표준 API로 제공하고 있다.
     *  Consumer : 리턴값이 없는 accept() 메소드를 가지고 있다.
     *  Supplier : 매개변수가 없고 리턴 값이 있는 getXXX() 메소드를 가지고 있다.
     *  Function : 매개변수와 리턴값이 있는 applyXXX() 메소드를 가지고 있다. (매개변수를 리턴값으로 매핑하는 역할)
     *  Operator : Function과 똑같이 applyXXX() 메소드를 가지고 있다. 차이점은 매개변수로 연산을 한 후 통일타입으로 리턴한다.
     *  Predicate : 매개변수와 boolean 값을 반환하는 testXXX()를 가지고 있다. (매개변수를 활용하여 boolean 반환)
     * */

    Consumer<String> c = new Consumer<String>() {
      @Override
      public void accept(String s) {
        System.out.println(s + "(이)가 입력됨");
      }
    };
    c.accept("hello world");
    Consumer<String> consumer = (str) -> System.out.println(str + "(이)가 입력됨");
    consumer.accept("hello world");

    BiConsumer<String, LocalTime> biConsumer = (str1, time) -> System.out.println(
        str1 + "(이)가" + time + "에 입력됨");
    biConsumer.accept("홍길동", LocalTime.now());

    IntConsumer intConsumer = num -> System.out.println("입력하신 숫자는 " + num + "입니다.");
    intConsumer.accept(1);

    ObjIntConsumer<Random> objIntConsumer =
        (random, bound) -> System.out.println(
            "0부터 " + bound + "전 까지의 난수 발생: " + random.nextInt(bound));
    objIntConsumer.accept(new Random(), 10);
  }
}
