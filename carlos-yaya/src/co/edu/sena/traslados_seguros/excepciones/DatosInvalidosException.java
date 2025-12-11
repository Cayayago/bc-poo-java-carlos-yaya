package co.edu.sena.traslados_seguros.excepciones;

public class DatosInvalidosException extends Exception {

    /**
     * Constructor con mensaje de error.
     *
     * @param mensaje Descripcion del error de validacion
     */
    public DatosInvalidosException(String mensaje) {
        super(mensaje);
    }

    /**
     * Constructor con mensaje y causa.
     *
     * @param mensaje Descripcion del error de validacion
     * @param causa Excepcion que causo este error
     */
    public DatosInvalidosException(String mensaje, Throwable causa) {
        super(mensaje, causa);
    }
}
