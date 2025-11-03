import excepciones.*;

public class GestorReservas {
    private int cupoMaximo = 2;
    private int reservasActuales = 0;
    
    /**
     * Agrega una reserva con validaciones
     */
    public void agregarReserva(String codigo, double precio)
            throws ReservaInvalidaException, DisponibilidadException {
        
        // Validar código
        if (!codigo.matches("R\\d{3}")) {
            throw new ReservaInvalidaException(
                "Código debe tener formato R### (ejemplo: R001)"
            );
        }
        
        // Validar precio
        if (precio <= 0) {
            throw new ReservaInvalidaException("Precio debe ser mayor a 0");
        }
        
        // Verificar disponibilidad
        if (reservasActuales >= cupoMaximo) {
            throw new DisponibilidadException(
                "No hay cupo disponible (máximo: " + cupoMaximo + ")"
            );
        }
        
        // Si todo está bien, agregar
        reservasActuales++;
        System.out.println("✅ Reserva agregada: " + codigo);
    }
}
