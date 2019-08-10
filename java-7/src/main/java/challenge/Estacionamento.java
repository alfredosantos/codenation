package challenge;

import java.util.ArrayList;
import java.util.List;

public class Estacionamento {

  private static final int MAX_PONTOS = 20;
  private static final int IDADE_MIN = 18;
  private static final int SENIOR = 55;
  private static final int MAX_VAGAS = 10;

  private List<Carro> listEstacionados = new ArrayList<>();
  public int countCarrosEstacionados;

  public void estacionar(Carro carro) {
    validarCarro(carro);
    if (countCarrosEstacionados < MAX_VAGAS) {
      listEstacionados.add(carro);
    } else {
      validaSeRemoveCarro();
      listEstacionados.add(carro);
    }
    countCarrosEstacionados += countCarrosEstacionados < MAX_VAGAS ? 1 : 0;
  }

  private void validaSeRemoveCarro() {
    for (Carro listEstacionado : listEstacionados) {
      if (listEstacionado.getMotorista().getIdade() < SENIOR) {
        listEstacionados.remove(listEstacionado);
        countCarrosEstacionados--;
        return;
      }
    }
    throw new EstacionamentoException(
        "Não podera estacionar, fora da regra.");
  }

  public int carrosEstacionados() {
    return countCarrosEstacionados;
  }

  public boolean carroEstacionado(Carro carro) {
    return listEstacionados.contains(carro);
  }

  final private void validarCarro(Carro carro) {
    if (carro.getMotorista() == null) {
      throw new EstacionamentoException("Nada de carro autônomo");
    }
    if (carro.getMotorista().getIdade() < IDADE_MIN) {
      throw new EstacionamentoException("Nada de menor de idade.");
    }
    if (carro.getMotorista().getPontos() >= MAX_PONTOS) {
      throw new EstacionamentoException("Não é permitido motorista menor de idade.");
    }
  }
}
