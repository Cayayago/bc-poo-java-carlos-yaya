package com.agencia.servicio;

// Import específico de las clases que necesitamos
import com.agencia.modelo.Reserva;
import com.agencia.modelo.Cliente;
import java.time.LocalDate;
import java.util.ArrayList;

/**
 * Gestor de reservas de la agencia
 */
public class GestorReservas {
    private ArrayList<Reserva> reservas = new ArrayList<>();
    
    public void agregarReserva(String codigo, Cliente cliente, LocalDate fecha, double precio) {
        Reserva nueva = new Reserva(codigo, cliente, fecha, precio);
        reservas.add(nueva);
        System.out.println("✅ Reserva agregada: " + nueva);
    }
    
    public void listarReservas() {
        System.out.println("\n📋 Listado de Reservas:");
        for (Reserva r : reservas) {
            System.out.println("  " + r);
        }
    }
}
