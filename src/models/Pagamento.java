package models;

import java.time.LocalDate;

public class Pagamento {
    private double valor;
    private LocalDate data;
    private TipoPagamento tipoPagamento;

    public Pagamento(double valor, LocalDate data, TipoPagamento tipoPagamento) {
        this.valor = valor;
        this.data = data;
        this.tipoPagamento = tipoPagamento;
    }

    public double getValor() { return valor; }
}

