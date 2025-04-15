package com.ohgiraffers.section02.additional;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.ClassOrderer.OrderAnnotation;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.Timeout;

import java.util.concurrent.TimeUnit;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

// @Order 어노테이션의 기능이 활성화 되기 위해서는 클래스 레벨에 어노테이션 선언이 필요하다
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class AdditionalAnntationTestsTest {

  @Disabled
  @Test
  void testIgnore(){
    System.out.println("실행 확인");
  }

  @Disabled
  @Test
  @Timeout(value=1000, unit= TimeUnit.MILLISECONDS)
  void testTime(){
    try{
      Thread.sleep(900);
    } catch (InterruptedException e) {
      throw new RuntimeException(e);
    }
  }

  @Test
  @Order(1)
  void testFirst(){
    System.out.println("first");
  }

  @Test
  @Order(3)
  void testThird(){
    System.out.println("third");
  }

  @Test
  @Order(2)
  void testSecond(){
    System.out.println("second");
  }

  @RepeatedTest(10)
  void testRepetition(){
    System.out.println("repetition");
  }

}