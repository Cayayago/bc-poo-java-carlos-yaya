package co.edu.sena.traslados_seguros.interfaces;

public interface Calificable {

    void agregarCalificacion(int puntos);

    double obtenerPromedioCalificaciones();

    int obtenerTotalCalificaciones();

    String obtenerNivelCalidad();
}