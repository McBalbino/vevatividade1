package tests;

import models.Ingresso;
import models.TipoIngresso;
import services.SistemaIngressos;

public class SistemaIngressosTest {

    @Test
    public void testContagemDeIngressosVendidos() {
        SistemaIngressos sistema = new SistemaIngressos();

        Ingresso vip1 = new Ingresso(1, TipoIngresso.VIP);
        Ingresso normal1 = new Ingresso(2, TipoIngresso.NORMAL);

        vip1.marcarComoVendido();
        sistema.adicionarIngresso(vip1);
        sistema.adicionarIngresso(normal1);

        assertEquals(1, sistema.contarIngressosVendidos(TipoIngresso.VIP));
                assertEquals(0, sistema.contarIngressosVendidos(TipoIngresso.NORMAL));
            }
        
            private void assertEquals(int i, long contarIngressosVendidos) {
                // TODO Auto-generated method stub
                throw new UnsupportedOperationException("Unimplemented method 'assertEquals'");
            }
}

