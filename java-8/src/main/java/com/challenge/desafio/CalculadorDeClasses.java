package com.challenge.desafio;

import com.challenge.annotation.Somar;
import com.challenge.annotation.Subtrair;
import com.challenge.interfaces.Calculavel;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.math.BigDecimal;

public class CalculadorDeClasses implements Calculavel {

  @Override
  public BigDecimal somar(Object classeCalcular) {
    return getExecutarOperacao(classeCalcular, Somar.class, TipoOperacao.SOMAR);
  }

  @Override
  public BigDecimal subtrair(Object classeCalcular) {
    return getExecutarOperacao(classeCalcular, Subtrair.class, TipoOperacao.SUBTRAIR);
  }

  @Override
  public BigDecimal totalizar(Object classeCalcular) {
    return somar(classeCalcular).add(subtrair(classeCalcular));
  }

  private BigDecimal getExecutarOperacao(Object classeCalcular,
      Class<? extends Annotation> annotationClass, TipoOperacao tipoOperacao) {
    if (classeCalcular == null) {
      return BigDecimal.ZERO;
    }
    BigDecimal operador = BigDecimal.ZERO;
    for (Field field : classeCalcular.getClass().getDeclaredFields()) {
      if (BigDecimal.class.isAssignableFrom(field.getType()) &&
          field.isAnnotationPresent(annotationClass)) {
        try {
          field.setAccessible(true);

          final BigDecimal augend =
              field.get(classeCalcular) != null ? (BigDecimal) field.get(classeCalcular)
                  : BigDecimal.ZERO;
          operador = tipoOperacao.equals(TipoOperacao.SOMAR) ?
              operador.add(augend) :
              operador.subtract(augend);
        } catch (IllegalAccessException e) {
          e.printStackTrace();
        }
      }
    }
    return operador;
  }

  private enum TipoOperacao {
    SOMAR,
    SUBTRAIR
  }
}
