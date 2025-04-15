package com.ohgiraffers.section02.functionalinterface;

import java.time.LocalDateTime;
import java.util.function.BooleanSupplier;
import java.util.function.Supplier;
import java.io.*;
import java.util.*;

public class Application2 {
  public static void main(String[] args) {
    Supplier<LocalDateTime> supplier = () -> LocalDateTime.now();
  }

  BooleanSupplier booleanSupplier = () -> {
    int random = (int)(Math.random() * 2);
    return random ==0? false: true;
  };

  System.out.println("램덤"+booleanSupplier.getAsBoolean());
}
