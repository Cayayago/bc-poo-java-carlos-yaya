package co.edu.sena.traslados_seguros.excepciones;

public class OperacionInvalidaException extends Exception {

    /**
     * Constructor con mensaje de error.
     *
     * @param mensaje Descripcion de la operacion invalida
     */
    public OperacionInvalidaException(String mensaje) {
        super(mensaje);
    }

    /**
     * Constructor con mensaje y causa.
     *
     * @param mensaje Descripcion de la operacion invalida
     * @param causa Excepcion que causo este error
     */
    public OperacionInvalidaException(String mensaje, Throwable causa) {
        super(mensaje, causa);
    }
}