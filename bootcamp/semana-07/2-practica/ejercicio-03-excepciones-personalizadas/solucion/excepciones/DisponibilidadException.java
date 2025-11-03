package excepciones;

/**
 * Excepción lanzada cuando no hay disponibilidad
 */
public class DisponibilidadException extends Exception {

  public DisponibilidadException(String mensaje) {
    super(mensaje);
  }

  public DisponibilidadException(String mensaje, Throwable causa) {
    super(mensaje, causa);
  }
}
