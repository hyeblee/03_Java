package com.ohgiraffers.section01.jupiter;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/* JUnit5에서 제공하는 Assertions에 있는 메소드에 대해 이해하고 활용할 수 있다. */
class JupiterAssertionsTests {

  /* 1. assertEquals : 예상 값과 실제 값의 일치 여부를 동일성으로 판단한다. */
  @Test
  void testAssertEquals() {
    /*given*/
    int firstNum = 10;
    int secondNum = 20;
    int expectedNum = 30;
    /*when*/
    Calculator calc = new Calculator();
    int result = calc.plus(firstNum, secondNum);

    /*then*/
    /*delta: 오차 허용범위
    assertEquals(expectedNum, result, 1);*/
    assertEquals(expectedNum, result);
  }

  /* 2. assertNull : null 여부 테스트 */
  @Test
  @DisplayName("Null 여부 테스트")
  void testAssetNull() {
    String str = null;
    Assertions.assertNull(str);
//    Assertions.assertNull("hello world");
  }

  /* 3. assertAll : 한 번에 여러 검증을 수행할 수 있는 메소드 */
  @Test
  @DisplayName("동시에 여러 값에 대한 검증 테스트")
  void testAssetAll() {
    String firstName = "길동";
    String lastName = "홍";
    Person person = new Person(firstName, lastName);
    Assertions.assertAll(
        () -> Assertions.assertEquals("", person.getFirstName()),
        () -> Assertions.assertEquals(lastName, person.getFirstName())
    );
  }

  @Test
  @DisplayName("exception 발생 테스트")
  void testAssetException() {
    // given
    int firstNum = 10;
    int secondNum = 0;

    // when
    // then
    NumberValidation validator = new NumberValidation();

    Exception exception = Assertions.assertThrows(IllegalArgumentException.class,
        () -> validator.checkDivideablenubmers(firstNum, secondNum));

    Assertions.assertAll(
        () -> Assertions.assertInstanceOf(IllegalArgumentException.class, exception),
        () -> Assertions.assertEquals("0으로 나눌 수 없습니다.", exception.getMessage())
    );
  }
}