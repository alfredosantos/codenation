package com.challenge.desafio;

import com.challenge.annotation.Somar;
import java.math.BigDecimal;

public class SomaTest {

  @Somar
  BigDecimal somar1;

  @Somar
  BigDecimal somar2;

  @Somar
  BigDecimal somar3;

  @Somar
  BigDecimal somar4;

  @Somar
  BigDecimal somar5;


  public BigDecimal getSomar1() {
    return somar1;
  }

  public void setSomar1(BigDecimal somar1) {
    this.somar1 = somar1;
  }

  public BigDecimal getSomar2() {
    return somar2;
  }

  public void setSomar2(BigDecimal somar2) {
    this.somar2 = somar2;
  }

  public BigDecimal getSomar3() {
    return somar3;
  }

  public void setSomar3(BigDecimal somar3) {
    this.somar3 = somar3;
  }

  public BigDecimal getSomar4() {
    return somar4;
  }

  public void setSomar4(BigDecimal somar4) {
    this.somar4 = somar4;
  }

  public BigDecimal getSomar5() {
    return somar5;
  }

  public void setSomar5(BigDecimal somar5) {
    this.somar5 = somar5;
  }
}