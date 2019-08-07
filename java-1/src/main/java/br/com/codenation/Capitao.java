package br.com.codenation;

import java.util.Objects;

public class Capitao {
    Jogador jogador;

    Boolean capitao;

    public Jogador getJogador() {
        return jogador;
    }

    public void setJogador(Jogador jogador) {
        this.jogador = jogador;
    }

    public Boolean getCapitao() {
        return capitao;
    }

    public void setCapitao(Boolean capitao) {
        this.capitao = capitao;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Capitao capitao1 = (Capitao) o;
        return Objects.equals(jogador, capitao1.jogador) &&
                Objects.equals(capitao, capitao1.capitao);
    }

    @Override
    public int hashCode() {
        return Objects.hash(jogador, capitao);
    }

    @Override
    public String toString() {
        return "Capitao{" +
                "jogador=" + jogador +
                ", capitao=" + capitao +
                '}';
    }
}
