package models;

public class Ingresso {
    private int id;
    private TipoIngresso tipo;
    private boolean vendido;

    public Ingresso(int id, TipoIngresso tipo) {
        this.id = id;
        this.tipo = tipo;
        this.vendido = false;
    }

    public void marcarComoVendido() { this.vendido = true; }
    public boolean isVendido() { return vendido; }
    public TipoIngresso getTipo() { return tipo; }
}
