package br.com.codenation;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Main {
    public static void main(String args[]) {
        DesafioMeuTimeApplication desafio = new DesafioMeuTimeApplication();

        // Incluir Time
        desafio.incluirTime((long) 1, "Vasco", LocalDate.parse("1900-10-10"), "Preto", "Branco");
        desafio.incluirTime((long) 2, "Flamengo", LocalDate.parse("1890-10-10"), "Preto", "Vermelho");

        // Incluir Jogador
        desafio.incluirJogador((long) 1L, (long) 1L, "Yago Pikachu", LocalDate.parse("1990-10-10"), 100, BigDecimal.valueOf(155500.50));
        desafio.incluirJogador((long) 2L, (long) 1L, "Valdívia", LocalDate.parse("1989-10-10"), 90, BigDecimal.valueOf(155500.50));
        desafio.incluirJogador((long) 3L, (long) 1L, "Ramon Motta", LocalDate.parse("1970-10-10"), 80, BigDecimal.valueOf(1600.50));
        desafio.incluirJogador((long) 4L, (long) 1L, "Marcos Junior", LocalDate.parse("1991-10-10"), 70, BigDecimal.valueOf(1700.50));
        desafio.incluirJogador((long) 5L, (long) 1L, "Leandro Castán", LocalDate.parse("1992-10-10"), 60, BigDecimal.valueOf(1800.50));
        desafio.incluirJogador((long) 6L, (long) 1L, "Tiago Reis", LocalDate.parse("1993-10-10"), 50, BigDecimal.valueOf(1900.50));
        desafio.incluirJogador((long) 7L, (long) 1L, "Andrey", LocalDate.parse("1990-10-10"), 40, BigDecimal.valueOf(1505.50));
        desafio.incluirJogador((long) 8L, (long) 1L, "Marrony", LocalDate.parse("1995-10-10"), 30, BigDecimal.valueOf(1506.50));
        desafio.incluirJogador((long) 9L, (long) 1L, "Rosicley", LocalDate.parse("1996-10-10"), 20, BigDecimal.valueOf(1507.50));
        desafio.incluirJogador((long) 10L, (long) 1L, "Werley", LocalDate.parse("1997-10-10"), 10, BigDecimal.valueOf(1508.50));
        desafio.incluirJogador((long) 11L, (long) 1L, "Sidão", LocalDate.parse("1997-10-10"), 5, BigDecimal.valueOf(1500.50));

        desafio.incluirJogador((long) 12, (long) 2, "Gabriel Barbosa", LocalDate.parse("1990-10-10"), 98, BigDecimal.valueOf(2500.10));
        desafio.incluirJogador((long) 22, (long) 2, "Rafinha", LocalDate.parse("1990-10-10"), 78, BigDecimal.valueOf(2500.50));
        desafio.incluirJogador((long) 32, (long) 2, "Diego", LocalDate.parse("1990-10-10"), 68, BigDecimal.valueOf(2500.50));
        desafio.incluirJogador((long) 42, (long) 2, "Cuéllar", LocalDate.parse("1990-10-10"), 58, BigDecimal.valueOf(2500.50));
        desafio.incluirJogador((long) 52, (long) 2, "Arrascaeta", LocalDate.parse("1990-10-10"), 48, BigDecimal.valueOf(2500.50));
        desafio.incluirJogador((long) 62, (long) 2, "Bruno Henrique", LocalDate.parse("1990-10-10"), 38, BigDecimal.valueOf(2500.50));
        desafio.incluirJogador((long) 72, (long) 2, "Rodrigo Caio", LocalDate.parse("1990-10-10"), 28, BigDecimal.valueOf(2500.50));
        desafio.incluirJogador((long) 82, (long) 2, "Éverton Ribeiro", LocalDate.parse("1990-10-10"), 18, BigDecimal.valueOf(2500.50));
        desafio.incluirJogador((long) 92, (long) 2, "Victor", LocalDate.parse("1990-10-10"), 8, BigDecimal.valueOf(2500.50));
        desafio.incluirJogador((long) 25, (long) 2, "Diego Alves", LocalDate.parse("1990-10-10"), 4, BigDecimal.valueOf(2500.50));

        // Definir Capitão
        desafio.definirCapitao((long) 1); // Time 1
        desafio.definirCapitao((long) 25); // Time 2

        // Buscar Capitão do Time
        System.out.println("Buscar Capitão do Time");
        System.out.println(desafio.buscarCapitaoDoTime((long) 1)); // Time 1
        System.out.println(desafio.buscarCapitaoDoTime((long) 2)); // Time 2
        System.out.println();

        // Buscar Nome do Jogador
        System.out.println("Buscar Nome do Jogador");
        System.out.println(desafio.buscarNomeJogador((long) 1)); // Time 1
        System.out.println(desafio.buscarNomeJogador((long) 25)); // Time 2
        System.out.println();

        // Buscar Nome do Time
        System.out.println("Buscar Nome do Time");
        System.out.println(desafio.buscarNomeTime((long) 1)); // Time 1
        System.out.println(desafio.buscarNomeTime((long) 2)); // Time 2
        System.out.println();

        // Buscar Maior Salário
        System.out.println("Buscar Maior Salário");
        System.out.println(desafio.buscarJogadorMaiorSalario((long) 1)); // Time 1
        System.out.println(desafio.buscarJogadorMaiorSalario((long) 2)); // Time 2
        System.out.println();

        // Buscar Salário do Jogador
        System.out.println("Buscar Salário do Jogador");
        System.out.println(desafio.buscarSalarioDoJogador((long) 1)); // Time 1
        System.out.println(desafio.buscarSalarioDoJogador((long) 25)); // Time 2
        System.out.println();

        // Buscar Jogadores do Time
        System.out.println("Buscar Jogadores do Time");
        System.out.println(desafio.buscarJogadoresDoTime((long) 1)); // Time 1
        System.out.println(desafio.buscarJogadoresDoTime((long) 2)); // Time 2
        System.out.println();

        // Buscar Melhor Jogador do Time
        System.out.println("Buscar Melhor Jogador do Time");
        System.out.println(desafio.buscarMelhorJogadorDoTime((long) 1)); // Time 1
        System.out.println(desafio.buscarMelhorJogadorDoTime((long) 2)); // Time 2
        System.out.println();

        // Buscar Jogador Mais Velho
        System.out.println("Buscar Jogador Mais Velho");
        System.out.println(desafio.buscarJogadorMaisVelho((long) 1)); // Time 1
        System.out.println(desafio.buscarJogadorMaisVelho((long) 2)); // Time 1
        System.out.println();

        // Buscar Times
        System.out.println("Buscar Times");
        System.out.println(desafio.buscarTimes());
        System.out.println();

        // Buscar Tops Jogadores
        System.out.println("Buscar Tops Jogadores");
        System.out.println(desafio.buscarTopJogadores(5)); // Time 1
        System.out.println();

        // Buscar Cor da Camisa do Time de Fora
        System.out.println("Buscar Cor da Camisa do Time de Fora");
        System.out.println(desafio.buscarCorCamisaTimeDeFora((long) 1, (long) 2));
    }
}