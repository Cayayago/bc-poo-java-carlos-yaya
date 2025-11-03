package excepciones;

/**
 * Excepción lanzada cuando se intenta registrar una placa duplicada.
 */
public class PlacaDuplicadaException extends Exception {
    public PlacaDuplicadaException(String placa) {
        super("La placa '" + placa + "' ya está registrada en el sistema");
    }
}
