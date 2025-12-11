package co.edu.sena.traslados_seguros;

import java.util.ArrayList;
import java.util.List;

// Semana 4: Cliente hereda de Persona
public class Cliente extends Persona implements Calificable, Notificable {

    // Semana 1: Atributos especificos de Cliente
    private String email;
    private List<MovingService> historialServicios;
    // Semana 6: Atributos para Calificable
    private List<Integer> calificaciones;
    // Semana 6: Atributos para Notificable
    private List<String> notificacionesPendientes;
    // Semana 4: Constructor 1
    public Cliente(String nombre, String telefono, String identificacion) {
        this(nombre, telefono, identificacion, null);
    }
    // Semana 4: Constructor 2
    public Cliente(String nombre, String telefono, String identificacion, String email) {
        super(nombre, telefono, identificacion);
        setEmail(email);
        this.historialServicios = new ArrayList<>();
        this.calificaciones = new ArrayList<>(); // Semana 6
        this.notificacionesPendientes = new ArrayList<>(); // Semana 6
    }

    public String getEmail() {
        return email;
    }

    public List<MovingService> getHistorialServicios() {
        return new ArrayList<>(historialServicios);
    }

    public void setEmail(String email) {
        if (email != null && !email.trim().isEmpty()) {
            if (validarEmail(email)) {
                this.email = email.trim().toLowerCase();
            } else {
                throw new IllegalArgumentException("Email invalido: formato incorrecto");
            }
        } else {
            this.email = null;
        }
    }

    private boolean validarEmail(String email) {
        return email.matches("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$");
    }

    public void agregarServicio(MovingService servicio) {
        if (servicio != null && !historialServicios.contains(servicio)) {
            historialServicios.add(servicio);
        }
    }

    public int contarServicios() {
        return historialServicios.size();
    }

    public void mostrarHistorial() {
        System.out.println("\n=== HISTORIAL DE " + nombre + " ===");
        if (historialServicios.isEmpty()) {
            System.out.println("No hay servicios registrados");
        } else {
            for (int i = 0; i < historialServicios.size(); i++) {
                MovingService s = historialServicios.get(i);
                System.out.println((i + 1) + ". " + s.getServiceCode() +
                        " | " + s.getOrigin() + " -> " + s.getDestination());
            }
        }
        System.out.println("Total servicios: " + historialServicios.size());
    }

    // Semana 4: Override del metodo heredado
    @Override
    public void mostrarInformacionBasica() {
        System.out.println("=== INFORMACION DEL CLIENTE ===");
        super.mostrarInformacionBasica(); // Semana 4: Llamada al metodo padre
        if (email != null) {
            System.out.println("Email: " + email);
        }
        System.out.println("Servicios contratados: " + historialServicios.size());
    }

    // Semana 4: Override de toString
    @Override
    public String toString() {
        String emailInfo = email != null ? " | Email: " + email : "";
        return "Cliente: " + nombre + " | Tel: " + telefono +
                " | ID: " + identificacion + emailInfo + " | Servicios: " + historialServicios.size();
    }
    // Semana 5: Override - obtenerTipoPersona
    @Override
    public String obtenerTipoPersona() {
        return "Cliente";
    }
    // Semana 6: Implementacion del metodo abstracto
    @Override
    public double calcularCostoOperacional() {
        // Costo operacional: $5000 por servicio contratado
        return historialServicios.size() * 5000.0;
    }
    @Override
    public void agregarCalificacion(int puntos) {
        if (puntos >= 1 && puntos <= 5) {
            calificaciones.add(puntos);
        } else {
            throw new IllegalArgumentException("Calificacion debe estar entre 1 y 5");
        }
    }

    @Override
    public double obtenerPromedioCalificaciones() {
        if (calificaciones.isEmpty()) {
            return 0.0;
        }
        int suma = 0;
        for (int cal : calificaciones) {
            suma += cal;
        }
        return (double) suma / calificaciones.size();
    }

    @Override
    public int obtenerTotalCalificaciones() {
        return calificaciones.size();
    }

    @Override
    public String obtenerNivelCalidad() {
        double promedio = obtenerPromedioCalificaciones();
        if (promedio >= 4.5) return "EXCELENTE";
        if (promedio >= 3.5) return "BUENO";
        if (promedio >= 2.5) return "REGULAR";
        if (promedio > 0) return "MALO";
        return "SIN CALIFICACIONES";
    }

    // ============================================
    // SEMANA 6: IMPLEMENTACION DE NOTIFICABLE
    // ============================================

    @Override
    public void enviarNotificacion(String mensaje) {
        notificacionesPendientes.add("[NORMAL] " + mensaje);
        System.out.println("Notificacion enviada a " + nombre + ": " + mensaje);
    }

    @Override
    public void enviarNotificacionUrgente(String mensaje) {
        notificacionesPendientes.add("[URGENTE] " + mensaje);
        System.out.println("*** URGENTE *** Notificacion a " + nombre + ": " + mensaje);
    }

    @Override
    public boolean tieneNotificacionesPendientes() {
        return !notificacionesPendientes.isEmpty();
    }

    public void mostrarNotificaciones() {
        System.out.println("\n=== NOTIFICACIONES DE " + nombre + " ===");
        if (notificacionesPendientes.isEmpty()) {
            System.out.println("No hay notificaciones pendientes");
        } else {
            for (int i = 0; i < notificacionesPendientes.size(); i++) {
                System.out.println((i + 1) + ". " + notificacionesPendientes.get(i));
            }
        }
    }
}