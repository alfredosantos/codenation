package br.com.codenation;

import br.com.codenation.desafio.annotation.Desafio;
import br.com.codenation.desafio.app.MeuTimeInterface;
import br.com.codenation.desafio.exceptions.CapitaoNaoInformadoException;
import br.com.codenation.desafio.exceptions.IdentificadorUtilizadoException;
import br.com.codenation.desafio.exceptions.JogadorNaoEncontradoException;
import br.com.codenation.desafio.exceptions.TimeNaoEncontradoException;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

public class DesafioMeuTimeApplication implements MeuTimeInterface {

  final Map<Long, Time> listTime = new HashMap<>();
  final Map<Long, Jogador> listJogadores = new HashMap<>();

  @Desafio("incluirTime")
  public void incluirTime(Long id, String nome, LocalDate dataCriacao, String corUniformePrincipal,
      String corUniformeSecundario) {
    List<Long> listIdTimes = buscarTimes();
    Time time = new Time();

    if (id == null) {
      throw new NoSuchElementException("No value present");
    } else {
      if (listIdTimes.contains(id)) {
        throw new IdentificadorUtilizadoException();
      }
    }

    time.setId(id);
    time.setNome(nome);
    time.setDataCriacao(dataCriacao);
    time.setCorUniformeSecundario(corUniformePrincipal);
    time.setCorUniformePrincipal(corUniformeSecundario);

    listTime.put(id, time);
  }

  @Desafio("incluirJogador")
  public void incluirJogador(Long id, Long idTime, String nome, LocalDate dataNascimento,
      Integer nivelHabilidade, BigDecimal salario) {
    Jogador jogador = new Jogador();

    if (listJogadores.containsKey(id)) {
      throw new IdentificadorUtilizadoException();
    }

    listTime
        .values()
        .stream()
        .filter(t -> t.getId()
            .equals(idTime))
        .findAny().orElseThrow(TimeNaoEncontradoException::new);

    jogador.setId(id);
    jogador.setId(idTime);
    jogador.setNome(nome);
    jogador.setDataNascimento(dataNascimento);
    jogador.setNivelHabilidade(nivelHabilidade);
    jogador.setSalario(salario);
    listJogadores.put(id, jogador);
  }

  @Desafio("definirCapitao")
  public void definirCapitao(Long idJogador) {
    Jogador jogador = listJogadores
        .values()
        .stream()
        .filter(j -> j.getId()
            .equals(idJogador))
        .findAny().orElseThrow(JogadorNaoEncontradoException::new);

    Time time;
    time = listTime
        .values()
        .stream()
        .filter(t -> t.getId()
            .equals(jogador.getIdTime()))
        .findAny().orElse(null);
    assert time != null;
    time.setCapitao(jogador.getId());
  }

  @Desafio("buscarCapitaoDoTime")
  public Long buscarCapitaoDoTime(Long idTime) {
    Time time =
        listTime
            .values()
            .stream()
            .filter(t -> t.getId()
                .equals(idTime))
            .findAny().orElseThrow(TimeNaoEncontradoException::new);

    if (time.getCapitao() == null) {
      throw new CapitaoNaoInformadoException();
    }

    return time.getCapitao();
  }

  @Desafio("buscarNomeJogador")
  public String buscarNomeJogador(Long idJogador) {
    Jogador jogador;
    if (listJogadores.containsKey(idJogador)) {
      throw new JogadorNaoEncontradoException();
    } else {
      jogador = listJogadores.get(idJogador);
      return jogador.getNome();
    }
  }

  @Desafio("buscarNomeTime")
  public String buscarNomeTime(Long idTime) {
    listTime
        .values()
        .stream()
        .filter(t -> t.getId()
            .equals(idTime))
        .findAny().orElseThrow(TimeNaoEncontradoException::new);
    return listTime.get(idTime).getNome();
  }

  @Desafio("buscarJogadoresDoTime")
  public List<Long> buscarJogadoresDoTime(Long idTime) {
    listTime
        .values()
        .stream()
        .filter(t -> t.getId()
            .equals(idTime))
        .findAny().orElseThrow(TimeNaoEncontradoException::new);
    return Collections.singletonList(listJogadores.get(idTime).getId());
  }

  @Desafio("buscarMelhorJogadorDoTime")
  public Long buscarMelhorJogadorDoTime(Long idTime) {
    listTime
        .values()
        .stream()
        .filter(t -> t.getId()
            .equals(idTime))
        .findAny().orElseThrow(TimeNaoEncontradoException::new);

    List<Jogador> jogadorList = listJogadores
        .values()
        .stream()
        .filter(j -> j.getIdTime()
            .equals(idTime))
        .collect(Collectors.toList());

    jogadorList.sort(Comparator.comparing(Jogador::getNivelHabilidade)
        .reversed().thenComparing(Jogador::getId));

    return jogadorList.get(0).getId();
  }

  @Desafio("buscarJogadorMaisVelho")
  public Long buscarJogadorMaisVelho(Long idTime) {
    listTime
        .values()
        .stream()
        .filter(t -> t.getId()
            .equals(idTime))
        .findAny().orElseThrow(TimeNaoEncontradoException::new);

    final List<Jogador> jogadores = listJogadores
        .values()
        .stream()
        .filter(j -> j.getIdTime()
            .equals(idTime))
        .collect(Collectors.toList());

    Comparator<? super Jogador> comparator =
        (Comparator<Jogador>) (jogador, t1)
            -> t1.getDataNascimento().compareTo(jogador.getDataNascimento());
    Collections.sort(jogadores, comparator.reversed());
    return jogadores.get(0).getId();
  }

  @Desafio("buscarTimes")
  public List<Long> buscarTimes() {
    return listTime
        .values()
        .stream()
        .map(Time::getId)
        .sorted()
        .collect(Collectors.toList());
  }

  @Desafio("buscarJogadorMaiorSalario")
  public Long buscarJogadorMaiorSalario(Long idTime) {
    listTime
        .values()
        .stream()
        .filter(t -> t.getId()
            .equals(idTime))
        .findAny().orElseThrow(TimeNaoEncontradoException::new);

    final List<Jogador> jogadores = listJogadores
        .values()
        .stream()
        .filter(j -> j.getIdTime()
            .equals(idTime))
        .collect(Collectors.toList());

    Comparator<? super Jogador> comparator = new Comparator<Jogador>() {
      @Override
      public int compare(Jogador jogador, Jogador t1) {
        return t1.getSalario().compareTo(jogador.getSalario());
      }
    };
    Collections.sort(jogadores, comparator.reversed());
    return jogadores.get(0).getId();
  }

  @Desafio("buscarSalarioDoJogador")
  public BigDecimal buscarSalarioDoJogador(Long idJogador) {
    if (listJogadores.containsKey(idJogador)) {
      throw new JogadorNaoEncontradoException();
    }
    return listJogadores.get(idJogador).getSalario();
  }

  @Desafio("buscarTopJogadores")
  public List<Long> buscarTopJogadores(Integer top) {
    Comparator<Jogador> jogadorComparator =
        Comparator.comparingLong(Jogador::getNivelHabilidade).reversed()
        .thenComparingLong(Jogador::getId);

    return listJogadores
        .values()
        .stream()
        .sorted(jogadorComparator)
        .map(Jogador::getId)
        .limit(top)
        .collect(Collectors.toList());
  }

  @Desafio("buscarCorCamisaTimeDeFora")
  public String buscarCorCamisaTimeDeFora(Long timeDaCasa, Long timeDeFora) {
    Time timeCasa =
        listTime
            .values()
            .stream()
            .filter(t -> t.getId()
                .equals(timeDaCasa))
            .findAny().orElseThrow(TimeNaoEncontradoException::new);

    Time timefora =
        listTime
            .values()
            .stream()
            .filter(t -> t.getId()
                .equals(timeDeFora))
            .findAny().orElseThrow(TimeNaoEncontradoException::new);

    return (timeCasa
        .getCorUniformePrincipal()
        .equals(timefora
            .getCorUniformePrincipal())) ? timefora
        .getCorUniformeSecundario() : timefora.getCorUniformePrincipal();
  }
}