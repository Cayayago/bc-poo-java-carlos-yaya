package com.agencia;

// Imports de nuestros paquetes
import com.agencia.modelo.Cliente;
import com.agencia.servicio.GestorReservas;
// Import estático para usar métodos directamente
import static com.agencia.util.Validador.validarEmail;
import static com.agencia.util.Validador.validarCodigo;

import java.time.LocalDate;

/**
 * Clase principal - Demostración de paquetes e imports
 */
public class Main {
  public static void main(String[] args) {
    System.out.println("=== Sistema de Reservas ===\n");

    // Validar email usando import estático
    String emailCliente = "ana@mail.com";
    if (validarEmail(emailCliente)) {
      System.out.println("✅ Email válido: " + emailCliente);
    }

    // Crear cliente
    Cliente cliente = new Cliente("Ana García", emailCliente);

    // Crear gestor
    GestorReservas gestor = new GestorReservas();

    // Validar código usando import estático
    String codigo = "R001";
    if (validarCodigo(codigo)) {
      gestor.agregarReserva(codigo, cliente, LocalDate.now(), 1500000);
    }

    gestor.agregarReserva("R002", cliente, LocalDate.now().plusDays(5), 2000000);

    // Listar
    gestor.listarReservas();

    System.out.println("\n✅ Ejercicio 01 completado: Paquetes e Imports funcionando correctamente");
  }
}
