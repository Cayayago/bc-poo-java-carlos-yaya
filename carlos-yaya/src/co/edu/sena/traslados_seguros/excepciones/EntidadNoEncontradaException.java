package co.edu.sena.traslados_seguros.excepciones;

public class EntidadNoEncontradaException extends Exception {

    /**
     * Constructor con mensaje de error.
     *
     * @param mensaje Descripcion de la entidad no encontrada
     */
    public EntidadNoEncontradaException(String mensaje) {
        super(mensaje);
    }

    /**
     * Constructor con mensaje y causa.
     *
     * @param mensaje Descripcion de la entidad no encontrada
     * @param causa Excepcion que causo este error
     */
    public EntidadNoEncontradaException(String mensaje, Throwable causa) {
        super(mensaje, causa);
    }
}
