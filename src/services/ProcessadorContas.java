package services;

import java.util.List;
import models.Fatura;
import models.Conta;
import models.TipoPagamento;


public class ProcessadorContas {

    public static boolean processar(Fatura fatura, List<Conta> contas) {
        double totalPagamentos = 0.0;

        for (Conta conta : contas) {
            double valorPago = conta.getValor();
            
            if (conta.getTipoPagamento() == TipoPagamento.BOLETO && valorPago > 5000.0) {
                throw new IllegalArgumentException("Pagamento por boleto excede o limite de R$ 5000.00");
            }
            
            // Se for BOLETO com atraso, adicionar 10%
            if (conta.getTipoPagamento() == TipoPagamento.BOLETO && conta.getData().isAfter(fatura.getData())) {
                valorPago *= 1.1;
            }

            totalPagamentos += valorPago;
        }

        if (totalPagamentos >= fatura.getValorTotal()) {
            fatura.marcarComoPaga();
        }
                return false;
    }

    public static boolean processar(Fatura fatura, Conta[] contas) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'processar'");
    }
}

