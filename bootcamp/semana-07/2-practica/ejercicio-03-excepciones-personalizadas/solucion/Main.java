import excepciones.*;

/**
 * Ejercicio 03: Excepciones Personalizadas
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("=== Ejercicio 03: Excepciones Personalizadas ===\n");
        
        GestorReservas gestor = new GestorReservas();
        
        // Caso 1: Reserva válida
        probarReserva(gestor, "R001", 1500000);
        
        // Caso 2: Código inválido
        probarReserva(gestor, "ABC", 2000000);
        
        // Caso 3: Precio inválido
        probarReserva(gestor, "R002", -1000);
        
        // Caso 4: Reserva válida
        probarReserva(gestor, "R003", 2500000);
        
        // Caso 5: Sin disponibilidad
        probarReserva(gestor, "R004", 3000000);
        
        System.out.println("\n✅ Ejercicio 03 completado");
    }
    
    private static void probarReserva(GestorReservas gestor, String codigo, double precio) {
        try {
            gestor.agregarReserva(codigo, precio);
        } catch (ReservaInvalidaException e) {
            System.err.println("❌ Reserva inválida: " + e.getMessage());
        } catch (DisponibilidadException e) {
            System.err.println("❌ Sin disponibilidad: " + e.getMessage());
        }
    }
}
