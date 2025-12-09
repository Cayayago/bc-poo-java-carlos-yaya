package co.edu.sena.traslados_seguros;

import java.util.ArrayList;
import java.util.List;

public class Cliente {

    private String nombre;
    private String telefono;
    private String identificacion;
    private List<MovingService> historialServicios;

    public Cliente(String nombre, String telefono, String identificacion) {
        this.nombre = nombre;
        this.telefono = telefono;
        this.identificacion = identificacion;
        this.historialServicios = new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public String getIdentificacion() {
        return identificacion;
    }

    public List<MovingService> getHistorialServicios() {
        return historialServicios;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public void setIdentificacion(String identificacion) {
        this.identificacion = identificacion;
    }

    public void agregarServicio(MovingService servicio) {
        if (!historialServicios.contains(servicio)) {
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

    @Override
    public String toString() {
        return "Cliente: " + nombre + " | Tel: " + telefono +
                " | ID: " + identificacion + " | Servicios: " + historialServicios.size();
    }
}