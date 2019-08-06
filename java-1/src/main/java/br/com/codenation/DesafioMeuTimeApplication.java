package br.com.codenation;

import br.com.codenation.desafio.annotation.Desafio;
import br.com.codenation.desafio.app.MeuTimeInterface;
import br.com.codenation.desafio.exceptions.IdentificadorUtilizadoException;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DesafioMeuTimeApplication implements MeuTimeInterface {
    final Map<Long, Time> listTime = new HashMap<>();

    @Desafio("incluirTime")
    public void incluirTime(Long id, String nome, LocalDate dataCriacao, String corUniformePrincipal, String corUniformeSecundario) {
        Time time = new Time();
        time.setId(id);
        time.setNome(nome);
        time.setDataCriacao(dataCriacao);
        time.setCorUniformeSecundario(corUniformePrincipal);
        time.setCorUniformePrincipal(corUniformeSecundario);
        if(listTime.containsKey(time.getId())){
            throw new IdentificadorUtilizadoException();
        }
    }

    @Desafio("incluirJogador")
    public void incluirJogador(Long id, Long idTime, String nome, LocalDate dataNascimento, Integer nivelHabilidade, BigDecimal salario) {
        Jogador jogador = new Jogador();

        if(listTime.containsKey(jogador.getId())){
            throw new IdentificadorUtilizadoException();
        };

        throw new UnsupportedOperationException();
    }

    @Desafio("definirCapitao")
    public void definirCapitao(Long idJogador) {
        throw new UnsupportedOperationException();
    }

    @Desafio("buscarCapitaoDoTime")
    public Long buscarCapitaoDoTime(Long idTime) {
        throw new UnsupportedOperationException();
    }

    @Desafio("buscarNomeJogador")
    public String buscarNomeJogador(Long idJogador) {
        throw new UnsupportedOperationException();
    }

    @Desafio("buscarNomeTime")
    public String buscarNomeTime(Long idTime) {
        throw new UnsupportedOperationException();
    }

    @Desafio("buscarJogadoresDoTime")
    public List<Long> buscarJogadoresDoTime(Long idTime) {
        throw new UnsupportedOperationException();
    }

    @Desafio("buscarMelhorJogadorDoTime")
    public Long buscarMelhorJogadorDoTime(Long idTime) {
        throw new UnsupportedOperationException();
    }

    @Desafio("buscarJogadorMaisVelho")
    public Long buscarJogadorMaisVelho(Long idTime) {
        throw new UnsupportedOperationException();
    }

    @Desafio("buscarTimes")
    public List<Long> buscarTimes() {
        throw new UnsupportedOperationException();
    }

    @Desafio("buscarJogadorMaiorSalario")
    public Long buscarJogadorMaiorSalario(Long idTime) {
        throw new UnsupportedOperationException();
    }

    @Desafio("buscarSalarioDoJogador")
    public BigDecimal buscarSalarioDoJogador(Long idJogador) {
        throw new UnsupportedOperationException();
    }

    @Desafio("buscarTopJogadores")
    public List<Long> buscarTopJogadores(Integer top) {
        throw new UnsupportedOperationException();
    }

    @Desafio("buscarCorCamisaTimeDeFora")
    public String buscarCorCamisaTimeDeFora(Long timeDaCasa, Long timeDeFora) {
        throw new UnsupportedOperationException();
    }
}