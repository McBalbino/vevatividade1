package services;

import java.util.ArrayList;
import java.util.List;
import models.Ingresso;
import models.TipoIngresso;


public class SistemaIngressos {
    private List<Ingresso> ingressos;

    public SistemaIngressos() {
        this.ingressos = new ArrayList<>();
    }

    public void adicionarIngresso(Ingresso ingresso) {
        ingressos.add(ingresso);
    }

    public long contarIngressosVendidos(TipoIngresso tipo) {
        return ingressos.stream()
                .filter(i -> i.getTipo() == tipo && i.isVendido())
                .count();
    }
}

