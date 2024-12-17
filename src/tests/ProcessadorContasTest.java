package tests;

import models.Conta;
import models.Fatura;
import models.TipoPagamento;
import services.ProcessadorContas;

import java.time.LocalDate;
import java.util.Arrays;

public class ProcessadorContasTest {

    @Test
    public void testFaturaPagaComBoletosNoPrazo() {
        Fatura fatura = new Fatura("Cliente A", LocalDate.of(2023, 2, 20), 1500.0);

        Conta conta1 = new Conta("123", LocalDate.of(2023, 2, 20), 500.0, TipoPagamento.BOLETO);
        Conta conta2 = new Conta("124", LocalDate.of(2023, 2, 20), 400.0, TipoPagamento.BOLETO);
        Conta conta3 = new Conta("125", LocalDate.of(2023, 2, 20), 600.0, TipoPagamento.BOLETO);

        ProcessadorContas processador = new ProcessadorContas();
        processador.processar(fatura, Arrays.asList(conta1, conta2, conta3));

        assertTrue(fatura.isPaga());
            }
        
            private void assertTrue(boolean paga) {
                // TODO Auto-generated method stub
                throw new UnsupportedOperationException("Unimplemented method 'assertTrue'");
            }
        
            @Test
    public void testFaturaPendentePorPagamentosInsuficientes() {
        Fatura fatura = new Fatura("Cliente B", LocalDate.of(2023, 2, 20), 1500.0);

        Conta conta1 = new Conta("123", LocalDate.of(2023, 2, 20), 700.0, TipoPagamento.BOLETO);
        Conta conta2 = new Conta("124", LocalDate.of(2023, 2, 17), 800.0, TipoPagamento.TRANSFERENCIA_BANCARIA);

        ProcessadorContas.processar(fatura, Arrays.asList(conta1, conta2));

        assertTrue(fatura.isPaga());
    }
}
