package br.com.codenation;

import java.math.BigDecimal;
import java.time.LocalDate;
import org.junit.Before;
import org.junit.Test;

public class DesafioMeuTimeApplicationTest {

  @Before
  public void incluirTime() {
    final Jogador jogador1 = new Jogador();
    jogador1.setId(1L);
    jogador1.setDataNascimento(LocalDate.of(1979, 02, 01));
    jogador1.setIdTime(1L);
    jogador1.setNivelHabilidade(200);
    jogador1.setNome("Cristiano Ronaldo");
    jogador1.setSalario(BigDecimal.valueOf(1000000));

    final Jogador jogador2 = new Jogador();
    jogador2.setId(2L);
    jogador2.setDataNascimento(LocalDate.of(1988, 02, 01));
    jogador2.setIdTime(1L);
    jogador2.setNivelHabilidade(199);
    jogador2.setNome("Ronaldo Fenomeno");
    jogador2.setSalario(BigDecimal.valueOf(1000000));

    final Jogador jogador3 = new Jogador();
    jogador3.setId(3L);
    jogador3.setDataNascimento(LocalDate.of(199, 03, 25));
    jogador3.setIdTime(1L);
    jogador3.setNivelHabilidade(100);
    jogador3.setNome("Neymar JR");
    jogador3.setSalario(BigDecimal.valueOf(1000000));

    final Time time = new Time();
    time.setCorUniformePrincipal("Azul");
    time.setCorUniformeSecundario("Preto");
    time.setDataCriacao(LocalDate.of(2001, 01, 01));
    time.setId(1L);
    time.getJogadores().add(jogador1);
    time.getJogadores().add(jogador2);
    time.getJogadores().add(jogador3);
    time.setNome("Time 1");
  }


  @Test
  public void buscarMelhorJogadorDoTime() {
    DesafioMeuTimeApplication testeBus = null;
    incluirTime();
    testeBus.buscarMelhorJogadorDoTime(1L);
  }
}
