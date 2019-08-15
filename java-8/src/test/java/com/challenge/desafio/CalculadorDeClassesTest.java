package com.challenge.desafio;

import java.math.BigDecimal;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CalculadorDeClassesTest {

  private CalculadorDeClasses calculadorDeClasses;

  @Before
  public void setUp() {
    calculadorDeClasses = new CalculadorDeClasses();
  }

  // Soma Tests
  @Test
  public void sucessSomaNullTest() {
    Assert.assertEquals(BigDecimal.ZERO, calculadorDeClasses.somar(new SomaTest()));
  }

  @Test
  public void sucessSomaTest() {
    final SomaTest classeCalcular = new SomaTest();
    classeCalcular.setSomar1(BigDecimal.valueOf(15));
    classeCalcular.setSomar2(BigDecimal.valueOf(5));
    classeCalcular.setSomar3(BigDecimal.valueOf(2));
    classeCalcular.setSomar4(BigDecimal.valueOf(10));
    classeCalcular.setSomar5(BigDecimal.valueOf(7));
    Assert.assertEquals(BigDecimal.valueOf(39), calculadorDeClasses.somar(classeCalcular));
  }

  @Test
  public void sucessSomaNoBigDecimalTest() {
    final SomaNotBigTest classeCalcular = new SomaNotBigTest();
    classeCalcular.setSomar1(15);
    classeCalcular.setSomar2(5);
    classeCalcular.setSomar3(2);
    classeCalcular.setSomar4(10);
    classeCalcular.setSomar5(7);
    Assert.assertEquals(BigDecimal.valueOf(0), calculadorDeClasses.somar(classeCalcular));
  }

  @Test
  public void sucessSomaNotAnotTest() {
    final SomaNotAnotTest classeCalcular = new SomaNotAnotTest();
    classeCalcular.setSomar1(15);
    classeCalcular.setSomar2(5);
    classeCalcular.setSomar3(2);
    classeCalcular.setSomar4(10);
    classeCalcular.setSomar5(7);
    Assert.assertEquals(BigDecimal.valueOf(0), calculadorDeClasses.somar(classeCalcular));
  }

  // Subtrair Tests
  @Test
  public void sucessSubtrairNullTest() {
    Assert.assertEquals(BigDecimal.ZERO, calculadorDeClasses.subtrair(new SubtrairTest()));
  }

  @Test
  public void sucessSubtrairTest() {
    final SubtrairTest classeCalcular = new SubtrairTest();
    classeCalcular.setSubtrair1(BigDecimal.valueOf(2));
    classeCalcular.setSubtrair2(BigDecimal.valueOf(5));
    classeCalcular.setSubtrair3(BigDecimal.valueOf(2));
    classeCalcular.setSubtrair4(BigDecimal.valueOf(10));
    classeCalcular.setSubtrair5(BigDecimal.valueOf(7));
    Assert.assertEquals(BigDecimal.valueOf(-26), calculadorDeClasses.subtrair(classeCalcular));
  }

  @Test
  public void sucessSubtrairNotAnotTest() {
    final SubtrairNotAnotTest classeCalcular = new SubtrairNotAnotTest();
    classeCalcular.setSubtrair1(BigDecimal.valueOf(2));
    classeCalcular.setSubtrair2(BigDecimal.valueOf(5));
    classeCalcular.setSubtrair3(BigDecimal.valueOf(2));
    classeCalcular.setSubtrair4(BigDecimal.valueOf(10));
    classeCalcular.setSubtrair5(BigDecimal.valueOf(7));
    Assert.assertEquals(BigDecimal.ZERO, calculadorDeClasses.subtrair(classeCalcular));
  }

  @Test
  public void sucessSubtrairNotBigTest() {
    final SubtrairNotBigTest classeCalcular = new SubtrairNotBigTest();
    classeCalcular.setSubtrair1(2);
    classeCalcular.setSubtrair2(5);
    classeCalcular.setSubtrair3(2);
    classeCalcular.setSubtrair4(10);
    classeCalcular.setSubtrair5(7);
    Assert.assertEquals(BigDecimal.ZERO, calculadorDeClasses.subtrair(classeCalcular));
  }

  // Totalizar Tests
  @Test
  public void sucessTotalizarNullTest() {
    TotalizarTest classeCalcular = new TotalizarTest();
    Assert.assertEquals(BigDecimal.ZERO, calculadorDeClasses.totalizar(classeCalcular));
  }

  @Test
  public void sucessTotalTest() {
    TotalizarTest classeCalcular = new TotalizarTest();
    classeCalcular.setSomar1(BigDecimal.valueOf(15));
    classeCalcular.setSomar2(BigDecimal.valueOf(5));
    classeCalcular.setSomar3(BigDecimal.valueOf(2));
    classeCalcular.setSomar4(BigDecimal.valueOf(10));
    classeCalcular.setSomar5(BigDecimal.valueOf(7));

    classeCalcular.setSubtrair1(BigDecimal.valueOf(2));
    classeCalcular.setSubtrair2(BigDecimal.valueOf(5));
    classeCalcular.setSubtrair3(BigDecimal.valueOf(2));
    classeCalcular.setSubtrair4(BigDecimal.valueOf(10));
    classeCalcular.setSubtrair5(BigDecimal.valueOf(7));
    Assert.assertEquals(BigDecimal.valueOf(13),
        calculadorDeClasses.totalizar(classeCalcular));
  }
}