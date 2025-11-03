package excepciones;

/**
 * Excepción lanzada cuando una reserva no cumple los requisitos
 */
public class ReservaInvalidaException extends Exception {

  public ReservaInvalidaException(String mensaje) {
    super(mensaje);
  }

  public ReservaInvalidaException(String mensaje, Throwable causa) {
    super(mensaje, causa);
  }
}
