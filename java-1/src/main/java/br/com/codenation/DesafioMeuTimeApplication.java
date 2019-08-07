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
  final Map<Long, Jogador> listJogador = new HashMap<>();
  final Map<Long, Time> listCapitaes = new HashMap<>();
  Time time;
  Jogador jogador;
  Capitao capitao;

  @Desafio("incluirTime")
  public void incluirTime(Long id, String nome, LocalDate dataCriacao, String corUniformePrincipal,
      String corUniformeSecundario) {
    time = new Time();

    if (id == null) {
      throw new NoSuchElementException("No value present");
    } else {
      time.setId(id);
    }

    time.setNome(nome);
    time.setDataCriacao(dataCriacao);
    time.setCorUniformeSecundario(corUniformePrincipal);
    time.setCorUniformePrincipal(corUniformeSecundario);

    if (listTime.containsKey(id)) {
      throw new IdentificadorUtilizadoException();
    } else {
      listTime.put(id, time);
    }
  }

  @Desafio("incluirJogador")
  public void incluirJogador(Long id, Long idTime, String nome, LocalDate dataNascimento,
      Integer nivelHabilidade, BigDecimal salario) {
    jogador = new Jogador();
    jogador.setId(id);

    if (listTime.containsKey(idTime)) {
      throw new TimeNaoEncontradoException();
    } else {
      listJogador.put(id, jogador);
    }

    jogador.setNome(nome);
    jogador.setDataNascimento(dataNascimento);
    jogador.setNivelHabilidade(nivelHabilidade);
    jogador.setSalario(salario);

    if (listJogador.containsKey(id)) {
      throw new JogadorNaoEncontradoException();
    } else {
      listJogador.put(id, jogador);
    }

  }

  @Desafio("definirCapitao")
  public void definirCapitao(Long idJogador) {
    capitao = new Capitao();

    if (listCapitaes.containsKey(idJogador)) {
      throw new CapitaoNaoInformadoException();
    } else {
      capitao.setJogador(listJogador.get(idJogador));
      capitao.setCapitao(Boolean.TRUE);
      listCapitaes.put(idJogador, listTime.get(capitao.getJogador().getIdTime()));
    }
  }

  @Desafio("buscarCapitaoDoTime")
  public Long buscarCapitaoDoTime(Long idTime) {
    Time capitaoAntigo;
    if (listCapitaes.containsKey(idTime)) {
      capitaoAntigo = listCapitaes.get(listJogador.get(idTime));
      listCapitaes.remove(capitaoAntigo);
    }

    if (listTime.containsKey(idTime)) {
      listCapitaes.get(idTime);
    } else {
      capitao.setJogador(listJogador.get(listTime.get(idTime)));
      capitao.setCapitao(Boolean.TRUE);
      listCapitaes.put(idTime, listTime.get(capitao.getJogador().getIdTime()));
    }
    return listCapitaes.get(idTime).getId();
  }

  @Desafio("buscarNomeJogador")
  public String buscarNomeJogador(Long idJogador) {
    if (listJogador.containsKey(idJogador)) {
      throw new JogadorNaoEncontradoException();
    } else {
      jogador = listJogador.get(idJogador);
      return jogador.getNome();
    }
  }

  @Desafio("buscarNomeTime")
  public String buscarNomeTime(Long idTime) {
    if (listTime.containsKey(idTime)) {
      throw new IdentificadorUtilizadoException();
    } else {
      time = listTime.get(idTime);
      return time.getNome();
    }
  }

  @Desafio("buscarJogadoresDoTime")
  public List<Long> buscarJogadoresDoTime(Long idTime) {
    if (listTime.containsKey(idTime)) {
      throw new TimeNaoEncontradoException();
    }
    return Collections.singletonList(listJogador.get(idTime).getId());
  }

  @Desafio("buscarMelhorJogadorDoTime")
  public Long buscarMelhorJogadorDoTime(Long idTime) {
    if (listTime.containsKey(idTime)) {
      throw new TimeNaoEncontradoException();
    }
    Comparator<? super Jogador> comparator = new Comparator<Jogador>() {
      @Override
      public int compare(Jogador jogador, Jogador t1) {
        return t1.getNivelHabilidade().compareTo(jogador.getNivelHabilidade());
      }
    };
    Collections.sort(listTime.get(idTime).getJogadores(), comparator);
    return listTime.get(idTime).getJogadores().get(0).id;
  }

  @Desafio("buscarJogadorMaisVelho")
  public Long buscarJogadorMaisVelho(Long idTime) {
    if (listTime.containsKey(idTime)) {
      throw new TimeNaoEncontradoException();
    }
    Comparator<? super Jogador> comparator = new Comparator<Jogador>() {
      @Override
      public int compare(Jogador jogador, Jogador t1) {
        return t1.getDataNascimento().compareTo(jogador.getDataNascimento());
      }
    };
    Collections.sort(listTime.get(idTime).getJogadores(), comparator);
    return listTime.get(idTime).getJogadores().get(0).id;
  }

  @Desafio("buscarTimes")
  public List<Long> buscarTimes() {
    return listTime.values().stream()
        .map(Time::getId)
        .sorted()
        .collect(Collectors.toList());
  }

  @Desafio("buscarJogadorMaiorSalario")
  public Long buscarJogadorMaiorSalario(Long idTime) {
    if (listTime.containsKey(idTime)) {
      throw new TimeNaoEncontradoException();
    }
    Comparator<? super Jogador> comparator = new Comparator<Jogador>() {
      @Override
      public int compare(Jogador jogador, Jogador t1) {
        return t1.getSalario().compareTo(jogador.getSalario());
      }
    };
    Collections.sort(listTime.get(idTime).getJogadores(), comparator);
    return listTime.get(idTime).getJogadores().get(0).id;
  }

  @Desafio("buscarSalarioDoJogador")
  public BigDecimal buscarSalarioDoJogador(Long idJogador) {
    if (listJogador.containsKey(idJogador)) {
      throw new JogadorNaoEncontradoException();
    }
    return listJogador.get(idJogador).getSalario();
  }

  @Desafio("buscarTopJogadores")
  public List<Long> buscarTopJogadores(Integer top) {
    if (listJogador.containsKey(top)) {
      throw new JogadorNaoEncontradoException();
    }
    Comparator<? super Jogador> comparator = new Comparator<Jogador>() {
      @Override
      public int compare(Jogador jogador, Jogador t1) {
        return jogador.getNivelHabilidade().compareTo(t1.getNivelHabilidade());
      }
    };
    Collections.sort(listTime.get(top).getJogadores(), comparator);
    return Collections.singletonList(listTime.get(top).getJogadores().get(0).id);
  }

  @Desafio("buscarCorCamisaTimeDeFora")
  public String buscarCorCamisaTimeDeFora(Long timeDaCasa, Long timeDeFora) {
    Time timeCasa =
        listTime
            .values()
            .stream()
            .filter(t ->
                t.getId().equals(timeDaCasa)).findAny().orElse(null);
    if (timeCasa == null) {
      throw new TimeNaoEncontradoException();
    }

    Time timefora = listTime
        .values()
        .stream()
        .filter(t ->
            t.getId().equals(timeDeFora)).findAny().orElse(null);
    if (timefora == null) {
      throw new TimeNaoEncontradoException();
    }

    return (timeCasa
        .getCorUniformePrincipal()
        .equals(timefora
            .getCorUniformePrincipal())) ? timefora
        .getCorUniformeSecundario() : timefora.getCorUniformePrincipal();
  }
}