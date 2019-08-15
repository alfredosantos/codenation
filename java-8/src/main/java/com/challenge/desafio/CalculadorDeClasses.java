package com.challenge.desafio;

import com.challenge.interfaces.Calculavel;
import java.math.BigDecimal;

@SuppressWarnings("ALL")
public class CalculadorDeClasses implements Calculavel {

  @Override
  public BigDecimal somar(BigDecimal somar) {
    if (somar == null) {
      return BigDecimal.ZERO;
    }
    return somar;
  }

  @Override
  public BigDecimal subtrair(BigDecimal subtrair) {
    if (subtrair == null) {
      return BigDecimal.ZERO;
    }
    return null;
  }

  @Override
  public BigDecimal totalizar(BigDecimal totalizar) {
    if (totalizar == null) {
      return BigDecimal.ZERO;
    }
    return null;
  }

}
