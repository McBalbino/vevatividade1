import models.Conta;
import models.Fatura;
import services.ProcessadorContas;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Criar uma fatura com valor total de 1500.0
        Fatura fatura = new Fatura("Cliente A", null, 1500.0);

        List<Conta> contas = Arrays.asList(
            new Conta("001", null, 700.0, null),
            new Conta("002", null, 800.0, null)
        );

        boolean paga = ProcessadorContas.processar(fatura, contas);

        System.out.println("Fatura está paga? " + (paga ? "Sim" : "Não"));
    }
}

