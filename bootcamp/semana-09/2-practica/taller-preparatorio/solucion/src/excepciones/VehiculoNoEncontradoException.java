package excepciones;

/**
 * Excepción lanzada cuando no se encuentra un vehículo.
 */
public class VehiculoNoEncontradoException extends Exception {
    public VehiculoNoEncontradoException(String placa) {
        super("Vehículo con placa '" + placa + "' no encontrado en el sistema");
    }
}
