package com.agencia.modelo;

import java.time.LocalDate;

/**
 * Representa una reserva de viaje
 */
public class Reserva {
    private String codigo;
    private Cliente cliente;
    private LocalDate fecha;
    private double precio;
    
    public Reserva(String codigo, Cliente cliente, LocalDate fecha, double precio) {
        this.codigo = codigo;
        this.cliente = cliente;
        this.fecha = fecha;
        this.precio = precio;
    }
    
    public String getCodigo() { return codigo; }
    public Cliente getCliente() { return cliente; }
    public LocalDate getFecha() { return fecha; }
    public double getPrecio() { return precio; }
    
    @Override
    public String toString() {
        return String.format("Reserva[%s, %s, %s, $%.2f]",
            codigo, cliente.getNombre(), fecha, precio);
    }
}
