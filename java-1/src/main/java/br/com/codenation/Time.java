package br.com.codenation;

import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

public class Time {

  Long id;
  String nome;
  LocalDate dataCriacao;
  String corUniformePrincipal;
  String corUniformeSecundario;
  List<Jogador> jogadores;

  public Time() {
    jogadores = new LinkedList<>();
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public LocalDate getDataCriacao() {
    return dataCriacao;
  }

  public void setDataCriacao(LocalDate dataCriacao) {
    this.dataCriacao = dataCriacao;
  }

  public String getCorUniformePrincipal() {
    return corUniformePrincipal;
  }

  public void setCorUniformePrincipal(String corUniformePrincipal) {
    this.corUniformePrincipal = corUniformePrincipal;
  }

  public String getCorUniformeSecundario() {
    return corUniformeSecundario;
  }

  public void setCorUniformeSecundario(String corUniformeSecundario) {
    this.corUniformeSecundario = corUniformeSecundario;
  }

  public List<Jogador> getJogadores() {
    return jogadores;
  }

  public void setJogadores(List<Jogador> jogadores) {
    this.jogadores = jogadores;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Time time = (Time) o;
    return Objects.equals(id, time.id) &&
        Objects.equals(nome, time.nome) &&
        Objects.equals(dataCriacao, time.dataCriacao) &&
        Objects.equals(corUniformePrincipal, time.corUniformePrincipal) &&
        Objects.equals(corUniformeSecundario, time.corUniformeSecundario) &&
        Objects.equals(jogadores, time.jogadores);
  }

  @Override
  public int hashCode() {
    return Objects
        .hash(id, nome, dataCriacao, corUniformePrincipal, corUniformeSecundario, jogadores);
  }

  @Override
  public String toString() {
    return "Time{" +
        "id=" + id +
        ", nome='" + nome + '\'' +
        ", dataCriacao=" + dataCriacao +
        ", corUniformePrincipal='" + corUniformePrincipal + '\'' +
        ", corUniformeSecundario='" + corUniformeSecundario + '\'' +
        ", jogadores=" + jogadores +
        '}';
  }
}