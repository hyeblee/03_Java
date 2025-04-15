package com.ohgiraffers.section01;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class lifecycleTest {

  @BeforeAll
  static void beforeAll() {
    System.out.println("시작합니다.");
  }

  @BeforeEach
  void beforeEach() {
    System.out.println("beforeEach 동작");
  }

  @AfterAll
  static void afterAll() {
    System.out.println("afterall 동작");
  }

  @AfterEach
  static void afterEach() {
    System.out.println("afterEach 동작");
  }

  @Test
  void test1(){
    System.out.println("테스트코드 1");
  }

  @Test
  void test2(){
    System.out.println("테스트코드 2");
  }
}