import models.Conta;
import models.Fatura;
import models.TipoPagamento;
import services.ProcessadorContas;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

class ProcessadorContasTest {

    @Test
    void testFaturaPagaComCartaoCredito() {
        Fatura fatura = new Fatura("Cliente A", LocalDate.now(), 1500.0);
        List<Conta> contas = Arrays.asList(
                new Conta("001", LocalDate.now(), 700.0, TipoPagamento.CARTAO_CREDITO),
                new Conta("002", LocalDate.now(), 800.0, TipoPagamento.CARTAO_CREDITO)
        );
        boolean paga = ProcessadorContas.processar(fatura, contas);
        assertTrue(fatura.isPaga());
    }

    @Test
    void testFaturaNaoPagaComBoletoDataFutura() {
        Fatura fatura = new Fatura("Cliente A", LocalDate.now(), 1500.0);
        List<Conta> contas = Arrays.asList(
                new Conta("001", LocalDate.now().plusDays(5), 700.0, TipoPagamento.BOLETO),
                new Conta("002", LocalDate.now().plusDays(5), 800.0, TipoPagamento.BOLETO)
        );
        boolean paga = ProcessadorContas.processar(fatura, contas);
        assertFalse(fatura.isPaga());
    }

    @Test
    void testErroPagamentoBoletoAcimaLimite() {
        Fatura fatura = new Fatura("Cliente A", LocalDate.now(), 5000.01);
        List<Conta> contas = List.of(new Conta("001", LocalDate.now(), 5000.01, TipoPagamento.BOLETO));
        assertThrows(IllegalArgumentException.class, () -> ProcessadorContas.processar(fatura, contas));
    }
}

package functionalTests;

import models.Ingresso;
import models.TipoIngresso;
import org.junit.jupiter.api.Test;
import services.SistemaIngressos;
import static org.junit.jupiter.api.Assertions.*;

class SistemaIngressosTest {

    @Test
    void testContagemIngressosNormais() {
        SistemaIngressos sistema = new SistemaIngressos();
        Ingresso ingresso = new Ingresso(1, TipoIngresso.NORMAL);
        sistema.adicionarIngresso(ingresso);
        ingresso.marcarComoVendido();
        assertEquals(1, sistema.contarIngressosVendidos(TipoIngresso.NORMAL));
    }

    @Test
    void testContagemIngressosVIP() {
        SistemaIngressos sistema = new SistemaIngressos();
        Ingresso ingresso = new Ingresso(2, TipoIngresso.VIP);
        sistema.adicionarIngresso(ingresso);
        ingresso.marcarComoVendido();
        assertEquals(1, sistema.contarIngressosVendidos(TipoIngresso.VIP));
    }

    @Test
    void testIngressoNaoVendidoNaoConta() {
        SistemaIngressos sistema = new SistemaIngressos();
        Ingresso ingresso = new Ingresso(3, TipoIngresso.MEIA_ENTRADA);
        sistema.adicionarIngresso(ingresso);
        assertEquals(0, sistema.contarIngressosVendidos(TipoIngresso.MEIA_ENTRADA));
    }
}
