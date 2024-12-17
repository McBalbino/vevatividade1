package models;

import java.time.LocalDate;

public class Conta {
    private String codigo;
    private LocalDate data;
    private double valor;
    private TipoPagamento tipoPagamento;

    public Conta(String codigo, LocalDate data, double valor, TipoPagamento tipoPagamento) {
        this.codigo = codigo;
        this.data = data;
        this.valor = valor;
        this.tipoPagamento = tipoPagamento;
    }

    public double getValor() { return valor; }
    public LocalDate getData() { return data; }
    public TipoPagamento getTipoPagamento() { return tipoPagamento; }
}
