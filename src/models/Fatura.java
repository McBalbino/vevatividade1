package models;

import java.time.LocalDate;

public class Fatura {
    private String cliente;
    private LocalDate data;
    private double valorTotal;
    private boolean paga;

    public Fatura(String cliente, LocalDate data, double valorTotal) {
        this.cliente = cliente;
        this.data = data;
        this.valorTotal = valorTotal;
        this.paga = false;
    }

    public void marcarComoPaga() { this.paga = true; }
    public boolean isPaga() { return paga; }
    public double getValorTotal() { return valorTotal; }
    public LocalDate getData() { return data; }
}
