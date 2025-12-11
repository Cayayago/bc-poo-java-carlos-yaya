package co.edu.sena.traslados_seguros.interfaces;

// Semana 6: Interface para entidades que pueden recibir notificaciones
public interface Notificable {

    void enviarNotificacion(String mensaje);

    void enviarNotificacionUrgente(String mensaje);

    boolean tieneNotificacionesPendientes();
}
