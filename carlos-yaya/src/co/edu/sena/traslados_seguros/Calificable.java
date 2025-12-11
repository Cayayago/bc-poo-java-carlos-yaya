package co.edu.sena.traslados_seguros;

public interface Calificable {

    void agregarCalificacion(int puntos);

    double obtenerPromedioCalificaciones();

    int obtenerTotalCalificaciones();

    String obtenerNivelCalidad();
}