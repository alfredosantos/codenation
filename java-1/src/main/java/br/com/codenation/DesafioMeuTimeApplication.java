package br.com.codenation;

import br.com.codenation.desafio.annotation.Desafio;
import br.com.codenation.desafio.app.MeuTimeInterface;
import br.com.codenation.desafio.exceptions.CapitaoNaoInformadoException;
import br.com.codenation.desafio.exceptions.IdentificadorUtilizadoException;
import br.com.codenation.desafio.exceptions.JogadorNaoEncontradoException;
import br.com.codenation.desafio.exceptions.TimeNaoEncontradoException;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.*;

public class DesafioMeuTimeApplication implements MeuTimeInterface {
    final Map<Long, Time> listTime = new HashMap<>();
    final Map<Long, Jogador> listJogador = new HashMap<>();
    final Map<Long, Time> listCapitaes = new HashMap<>();
    Time time;
    Jogador jogador;
    Capitao capitao;

    @Desafio("incluirTime")
    public void incluirTime(Long id, String nome, LocalDate dataCriacao, String corUniformePrincipal, String corUniformeSecundario) {
        time = new Time();

        if (id == null | id.equals(" ")) {
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
    public void incluirJogador(Long id, Long idTime, String nome, LocalDate dataNascimento, Integer nivelHabilidade, BigDecimal salario) {
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
        return Collections.singletonList(listJogador.get(idTime).getId());
    }

    @Desafio("buscarMelhorJogadorDoTime")
    public Long buscarMelhorJogadorDoTime(Long idTime) {
        if (listTime.containsKey(idTime)) {
            throw new TimeNaoEncontradoException();
            else{
                for (listTime.get(idTime).getJogador()) == listTime.get(idTime).getJogador().getSalario();
            }
        }

        @Desafio("buscarJogadorMaisVelho")
        public Long buscarJogadorMaisVelho (Long idTime){
            throw new UnsupportedOperationException();
        }

        @Desafio("buscarTimes")
        public List<Long> buscarTimes () {
            throw new UnsupportedOperationException();
        }

        @Desafio("buscarJogadorMaiorSalario")
        public Long buscarJogadorMaiorSalario (Long idTime){
            throw new UnsupportedOperationException();
        }

        @Desafio("buscarSalarioDoJogador")
        public BigDecimal buscarSalarioDoJogador (Long idJogador){
            throw new UnsupportedOperationException();
        }

        @Desafio("buscarTopJogadores")
        public List<Long> buscarTopJogadores (Integer top){
            throw new UnsupportedOperationException();
        }

        @Desafio("buscarCorCamisaTimeDeFora")
        public String buscarCorCamisaTimeDeFora (Long timeDaCasa, Long timeDeFora){
            throw new UnsupportedOperationException();
        }
    }