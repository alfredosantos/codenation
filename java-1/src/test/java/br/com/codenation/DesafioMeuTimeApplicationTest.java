package br.com.codenation;

import br.com.codenation.desafio.exceptions.CapitaoNaoInformadoException;
import br.com.codenation.desafio.exceptions.IdentificadorUtilizadoException;
import br.com.codenation.desafio.exceptions.JogadorNaoEncontradoException;
import br.com.codenation.desafio.exceptions.TimeNaoEncontradoException;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class DesafioMeuTimeApplicationTest {

  final DesafioMeuTimeApplication testeBus = new DesafioMeuTimeApplication();

  @Before
  public void incluirTimeTest() {

    final Jogador jogador1 = new Jogador(1L, 1L, "Cristiano Ronaldo", LocalDate.of(1979, 02, 01),
        200, BigDecimal.valueOf(1000000));

    final Jogador jogador2 = new Jogador();
    jogador2.setId(2L);
    jogador2.setDataNascimento(LocalDate.of(1901, 02, 01));
    jogador2.setIdTime(1L);
    jogador2.setNivelHabilidade(199);
    jogador2.setNome("Ronaldo Fenomeno");
    jogador2.setSalario(BigDecimal.valueOf(153000));

    final Jogador jogador3 = new Jogador();
    jogador3.setId(3L);
    jogador3.setDataNascimento(LocalDate.of(1999, 03, 25));
    jogador3.setIdTime(1L);
    jogador3.setNivelHabilidade(999);
    jogador3.setNome("Neymar JR");
    jogador3.setSalario(BigDecimal.valueOf(125000));

    final Time time1 = new Time(1L, "Time 1", LocalDate.of(2001, 01, 01), "Azul", "Laranja");

    final Time time2 = new Time();
    time2.setCorUniformePrincipal("Amarelo");
    time2.setCorUniformeSecundario("Branco");
    time2.setDataCriacao(LocalDate.of(1900, 12, 11));
    time2.setId(2L);
    time2.setNome("Time 2");
    testeBus.listTime.put(time1.getId(), time1);
    testeBus.listTime.put(time2.getId(), time2);
    testeBus.listJogadores.put(jogador1.getId(), jogador1);
    testeBus.listJogadores.put(jogador2.getId(), jogador2);
    testeBus.listJogadores.put(jogador3.getId(), jogador3);
  }

  @Test
  public void incluirTimeTeste() {
    testeBus.incluirTime(3L, "Time 3", LocalDate.of(1979, 02, 01), "Azul", "Preto");
  }

  @Test(expected = IdentificadorUtilizadoException.class)
  public void incluirTimeTesteErro() {
    testeBus.incluirTime(1L, "Time 4", LocalDate.of(1979, 02, 01), "Azul", "Preto");
  }

  @Test
  public void incluirJogadorTest() {
    testeBus.incluirJogador(4L, 1L, "Jogador", LocalDate.of(1999, 03, 25), 133,
        BigDecimal.valueOf(1000000));
    Assert.assertNotNull(testeBus.listJogadores.get(4L));
  }

  @Test(expected = TimeNaoEncontradoException.class)
  public void incluirJogadorTimeInexistenteErro() {
    testeBus.incluirJogador(5L, 999L, "Jogador", LocalDate.of(1999, 03, 25), 133,
        BigDecimal.valueOf(1000000));
  }

  @Test(expected = IdentificadorUtilizadoException.class)
  public void incluirJogadorJaInclusoErro() {
    testeBus.incluirJogador(1L, 1L, "Jogador", LocalDate.of(1999, 03, 25), 133,
        BigDecimal.valueOf(1000000));
  }

  @Test
  public void definirCapitao() {
    testeBus.definirCapitao(1L);
    final Jogador jogador = testeBus.listJogadores.get(1L);
    final Long idJogador = testeBus.buscarCapitaoDoTime(jogador.idTime);

    Assert.assertEquals(1l, idJogador.longValue());
  }

  @Test(expected = JogadorNaoEncontradoException.class)
  public void definirCapitaoJogadorNaoExistente() {
    testeBus.definirCapitao(999L);
  }

  @Test
  public void buscarCapitaoDoTime() {
    testeBus.definirCapitao(1L);
    Assert.assertEquals(1l, testeBus.buscarCapitaoDoTime(1L).longValue());
  }

  @Test(expected = TimeNaoEncontradoException.class)
  public void buscarCapitaoDoTimeNaoEncontrado() {
    testeBus.buscarCapitaoDoTime(999L);
  }

  @Test(expected = CapitaoNaoInformadoException.class)
  public void buscarCapitaoDoTimeNaoDefinido() {
    testeBus.buscarCapitaoDoTime(1L);
  }

  @Test
  public void buscarNomeJogadorDoTime() {
    Assert.assertEquals("Cristiano Ronaldo", testeBus.buscarNomeJogador(1L));
  }

  @Test(expected = JogadorNaoEncontradoException.class)
  public void buscarNomeJogadorDoTimeNaoEncontrado() {
    testeBus.buscarNomeJogador(999L);
  }

  @Test
  public void buscarNomeTime() {
    Assert.assertEquals("Time 1", testeBus.buscarNomeTime(1L));
  }

  @Test(expected = TimeNaoEncontradoException.class)
  public void buscarNomeTimeNaoEncontrado() {
    testeBus.buscarNomeTime(999L);
  }

  @Test
  public void buscarJogadoresTime() {
    Assert.assertEquals(Arrays.asList(1L, 2L, 3L), testeBus.buscarJogadoresDoTime(1L));
  }

  @Test(expected = TimeNaoEncontradoException.class)
  public void buscarJogadoresTimeNaoEncontrado() {
    testeBus.buscarJogadoresDoTime(999L);
  }

  @Test
  public void buscarMelhorJogadorDoTime() {
    Assert.assertEquals(3l, testeBus.buscarMelhorJogadorDoTime(1L).longValue());
  }

  @Test(expected = TimeNaoEncontradoException.class)
  public void buscarMelhorJogadorDoTimeErro() {
    Assert.assertEquals(3l, testeBus.buscarMelhorJogadorDoTime(5L).longValue());
  }

  @Test
  public void buscarJogadorMaisVelho() {
    Assert.assertEquals(2L, testeBus.buscarJogadorMaisVelho(1L).longValue());
  }

  @Test(expected = TimeNaoEncontradoException.class)
  public void buscarJogadorMaisVelhoErro() {
    Assert.assertEquals(2l, testeBus.buscarJogadorMaisVelho(5L).longValue());
  }

  @Test
  public void buscarTimes() {
    List<Long> a = new ArrayList<>();
    a.add(1L);
    a.add(2L);
    Assert.assertEquals(a, testeBus.buscarTimes());
  }

  @Test
  public void buscarJogadorMaiorSalario() {
    Assert.assertEquals(1l, testeBus.buscarJogadorMaiorSalario(1L).longValue());
  }

  @Test(expected = TimeNaoEncontradoException.class)
  public void buscarJogadorMaiorSalarioError() {
    Assert.assertEquals(1l, testeBus.buscarJogadorMaiorSalario(8L).longValue());
  }

  @Test
  public void buscarSalarioJogador() {
    Assert.assertEquals(1000000, testeBus.buscarSalarioDoJogador(1L).longValue());
  }

  @Test(expected = JogadorNaoEncontradoException.class)
  public void buscarSalarioJogadorNaoEncontrado() {
    testeBus.buscarSalarioDoJogador(999L);
  }

  @Test
  public void buscarTopJogadores() {
    List<Long> a = new ArrayList<>();
    a.add(3L);
    a.add(1L);
    Assert.assertEquals(a, testeBus.buscarTopJogadores(2));
  }

  @Test
  public void buscarTopJogadoresVazio(){
    Assert.assertEquals(Collections.emptyList(), new DesafioMeuTimeApplication().buscarTopJogadores(2));
  }

  @Test
  public void buscarCorCamisaTime1DeFora() {
    Assert.assertEquals("Azul", testeBus.buscarCorCamisaTimeDeFora(2L, 1L));
  }

  @Test
  public void buscarCorCamisaTime1DeForaIgual() {
    testeBus.listTime.get(2L).setCorUniformePrincipal("Azul");
    Assert.assertEquals("Laranja", testeBus.buscarCorCamisaTimeDeFora(2L, 1L));
  }

  @Test
  public void buscarCorCamisaTime2DeFora() {
    Assert.assertEquals("Amarelo", testeBus.buscarCorCamisaTimeDeFora(1L, 2L));
  }

  @Test
  public void buscarCorCamisaTime2DeForaIgual() {
    testeBus.listTime.get(1L).setCorUniformePrincipal("Amarelo");
    Assert.assertEquals("Branco", testeBus.buscarCorCamisaTimeDeFora(1L, 2L));
  }

}